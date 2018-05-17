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
        photos = photoInterpreter.run(title);

        try {
            BufferedImage image = ImageIO.read(new URL(photos[0].getUrl()));
            ImageLabel.setIcon(new ImageIcon(image));
            return;
        } catch (ConnectException e) {
            System.err.println("Time limit exceeded");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Something went wrong");
        }

        ImageLabel.setText("¯\\_(ツ)_/¯");
    }
}
