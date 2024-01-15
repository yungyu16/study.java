package com.github.study.demo.misc;

import org.apache.commons.imaging.ImageInfo;
import org.apache.commons.imaging.ImageReadException;
import org.apache.commons.imaging.Imaging;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class ImageTest {
    public static void main(String[] args) throws IOException, ImageReadException {
        ImageInfo imageInfo = Imaging.getImageInfo(Paths.get("test.png").toFile());
        System.out.println(imageInfo.toString());
        BufferedImage bufferedImage = Imaging.getBufferedImage(Paths.get("test.png").toFile());
    }
}
