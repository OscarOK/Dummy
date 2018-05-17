package com.oscarok.Threads;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveThread extends Thread {
    private final JLabel image;
    private String title;

    public SaveThread(JLabel image, String title) {
        super("Save");
        this.image = image;
        this.title = title;
    }

    @Override
    public void run() {
        synchronized (image) {
            try {
                ImageIcon imageIcon = (ImageIcon) image.getIcon();
                Image image = imageIcon.getImage();
                BufferedImage bufferedImage = (BufferedImage) image;
                File file = new File(title + ".png");
                ImageIO.write(bufferedImage, "png", file);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}
