package com.strangerws.ssu.neuralnet.utils;

import com.strangerws.ssu.neuralnet.Main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageAnalyzer {
    public static int[][] analyze(String fileName) {
        int[][] imageArray = null;
        try {
            BufferedImage image = ImageIO.read(new File(fileName));
            imageArray = new int[image.getWidth()][image.getHeight()];
            for (int i = 0; i < image.getWidth(); i++) {
                for (int j = 0; j < image.getHeight(); j++) {
                    imageArray[i][j] = image.getRGB(i, j) / 0xffffff;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return imageArray;
    }
}
