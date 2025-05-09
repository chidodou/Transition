/**
 * Handles all audio within the window
 */

import org.lwjgl.openal.AL;
import org.lwjgl.openal.AL10;
import org.lwjgl.openal.ALC;
import org.lwjgl.openal.ALC10;
import org.lwjgl.openal.ALCapabilities;
import org.lwjgl.stb.STBVorbisInfo;
import org.lwjgl.system.MemoryStack;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.ALC11.*;
import static org.lwjgl.stb.STBVorbis.*;
import static org.lwjgl.system.MemoryStack.stackPush;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Audio {

    private long device;
    private long context;
    private int buffer;
    private int source;

    public void init(String filepath) {
        // Open default device
        device = alcOpenDevice((ByteBuffer) null);
        if (device == NULL) throw new IllegalStateException("Failed to open the default OpenAL device.");

        // Create context
        context = alcCreateContext(device, (IntBuffer) null);
        alcMakeContextCurrent(context);
        AL.createCapabilities(ALC.createCapabilities(device));

        // Load audio file
        buffer = alGenBuffers();
        source = alGenSources();

        try (MemoryStack stack = stackPush()) {
            IntBuffer channelsBuffer = stack.mallocInt(1);
            IntBuffer sampleRateBuffer = stack.mallocInt(1);

            ShortBuffer rawAudioBuffer = stb_vorbis_decode_filename(filepath, channelsBuffer, sampleRateBuffer);
            if (rawAudioBuffer == null) {
                throw new RuntimeException("Failed to load audio: " + filepath);
            }

            int channels = channelsBuffer.get(0);
            int sampleRate = sampleRateBuffer.get(0);
            int format = channels == 1 ? AL_FORMAT_MONO16 : AL_FORMAT_STEREO16;

            alBufferData(buffer, format, rawAudioBuffer, sampleRate);
        }

        alSourcei(source, AL_BUFFER, buffer);
    }

    public void play() { alSourcePlay(source); }

    public boolean isPlaying() { return alGetSourcei(source, AL_SOURCE_STATE) == AL_PLAYING; }

    public void cleanup() {
        alDeleteSources(source);
        alDeleteBuffers(buffer);
        alcDestroyContext(context);
        alcCloseDevice(device);
    }
}
