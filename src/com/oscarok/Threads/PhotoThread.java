package com.oscarok.Threads;

import com.oscarok.Interpreters.PhotoInterpreter;
import com.oscarok.Resources.Photo;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.ConnectException;
import java.net.MalformedURLException;
import java.net.URL;

public class PhotoThread extends Thread {
    private String title;
    private Photo[] photos;
    private PhotoInterpreter photoInterpreter;
    private JLabel ImageLabel;

    public PhotoThread(String title, JLabel ImageJLabel) {
        this.title = title;
        this.ImageLabel = ImageJLabel;
        photoInterpreter = new PhotoInterpreter();
    }

    @Override
    public void run() {
        ImageLabel.setText("");
        photos = photoInterpreter.run();

        for (Photo photo : photos) {
            if (photo.getTitle().equals(title)) {
                try {
                    BufferedImage image = ImageIO.read(new URL(photo.getUrl()));
                    ImageLabel.setIcon(new ImageIcon(image));
                } catch (ConnectException e) {
                    System.err.println("Time limit exceeded");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (Exception e) {
                    System.err.println("Something went wrong");
                }
                return;
            }
        }

        ImageLabel.setText("¯\\_(ツ)_/¯");
    }
}
