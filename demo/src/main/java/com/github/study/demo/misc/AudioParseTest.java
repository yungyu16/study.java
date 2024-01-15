package com.github.study.demo.misc;

import lombok.extern.slf4j.Slf4j;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.audio.mp3.MP3FileReader;
import org.jaudiotagger.tag.id3.ID3v23Frame;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
@Slf4j
public class AudioParseTest {
    public static void main(String[] args) throws Exception {
        MP3File mp3File = (MP3File) new MP3FileReader().read(Paths.get("好汉歌mp3.data").toFile());
        MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();
        ID3v23Frame songnameFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TIT2");
        String songName = songnameFrame.getContent();
        ID3v23Frame artistFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TPE1");
        String artist = artistFrame.getContent();
        ID3v23Frame albumFrame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get("TALB");
        String album = albumFrame.getContent();
        int duration = audioHeader.getTrackLength();
        log.info("songName:{} artist:{} album:{} duration:{}", songName, artist, album, duration);
    }

    private static void parseMp3() throws IOException {
        try (SeekableByteChannel channel = Files.newByteChannel(Paths.get("好汉歌mp3.data"))) {
            long size = channel.size();
            channel.position(size - 128);
            ByteBuffer buffer = ByteBuffer.allocate(128);
            while (buffer.hasRemaining()) {
                channel.read(buffer);
            }
            System.out.println(buffer.remaining());
            buffer.flip();
            System.out.println(buffer.remaining());
            byte[] tagArr = new byte[3];
            buffer.get(tagArr);
            System.out.println(buffer.remaining());
            System.out.println(new String(tagArr));
            System.out.println("======================");
            channel.position(10);
            ByteBuffer tag = ByteBuffer.allocate(10);
            while (tag.hasRemaining()) {
                channel.read(tag);
            }
            tag.flip();
            byte[] array = tag.array();
            int limit = tag.limit();
            String x = new String(array, 0, 4);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println("==========");
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x);
            System.out.println(x + "hahha");
            String s = new String(new byte[]{65, 65, 65, 13, 65});
            System.out.println(s);
        }
    }
}
