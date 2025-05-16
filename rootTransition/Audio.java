import javazoom.jl.decoder.*;
import org.lwjgl.openal.AL;
import org.lwjgl.system.MemoryUtil;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

import org.lwjgl.openal.ALC;

import static org.lwjgl.openal.ALC10.*;
import static org.lwjgl.openal.AL10.*;

public class Audio {

    public static class DecodedMP3 {
        public ByteBuffer buffer;
        public int sampleRate;
        public int format;
    }

    private static long startTime = 0;
    private static int audioSource = -1;

    public static void init() {
        long device = alcOpenDevice((ByteBuffer) null); // default device
        if (device == 0) throw new IllegalStateException("Failed to open the default OpenAL device.");

        long context = alcCreateContext(device, (int[]) null);
        alcMakeContextCurrent(context);
        AL.createCapabilities(ALC.createCapabilities(device));
    }

    public static DecodedMP3 decodeMP3(String filepath) throws Exception {
        Bitstream bitstream = new Bitstream(new BufferedInputStream(new FileInputStream(filepath)));
        Decoder decoder = new Decoder();

        List<Short> samplesList = new ArrayList<>();
        int sampleRate = 44100;
        int channels = 2;

        Header header;
        SampleBuffer output;

        while ((header = bitstream.readFrame()) != null) {
            output = (SampleBuffer) decoder.decodeFrame(header, bitstream);
            sampleRate = output.getSampleFrequency();
            channels = output.getChannelCount();

            short[] samples = output.getBuffer();
            for (short s : samples) {
                samplesList.add(s);
            }

            bitstream.closeFrame();
        }
        bitstream.close();

        ByteBuffer pcmBuffer = MemoryUtil.memAlloc(samplesList.size() * 2);
        for (short s : samplesList) {
            pcmBuffer.putShort(s);
        }
        pcmBuffer.flip();

        int format = (channels == 1) ? AL_FORMAT_MONO16 : AL_FORMAT_STEREO16;
        if (channels != 1 && channels != 2) {
            throw new IllegalArgumentException("Unsupported channel count: " + channels);
        }

        DecodedMP3 result = new DecodedMP3();
        result.buffer = pcmBuffer;
        result.sampleRate = sampleRate;
        result.format = format;

        System.out.println("Decoded MP3 - Samples: " + samplesList.size() + ", SampleRate: " + sampleRate + ", Channels: " + channels);
        return result;
    }

    public static void play(String filePath) throws Exception {
        DecodedMP3 decoded = decodeMP3(filePath);
        int buffer = alGenBuffers();
        alBufferData(buffer, decoded.format, decoded.buffer, decoded.sampleRate);

        audioSource = alGenSources();
        alSourcei(audioSource, AL_BUFFER, buffer);
        alSourcef(audioSource, AL_GAIN, 1.0f);
        alSourcePlay(audioSource);

        startTime = System.currentTimeMillis();
        System.out.println("Audio started at: " + startTime + " ms");
    }

    public static long getStartTime() {
        return startTime;
    }

    public static void stop() {
        if (audioSource != -1) {
            alSourceStop(audioSource);
            alDeleteSources(audioSource);
            audioSource = -1;
        }
    }
}
