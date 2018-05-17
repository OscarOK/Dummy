package com.oscarok.Window;

import com.oscarok.Resources.Photo;
import com.oscarok.Interpreters.PhotoInterpreter;
import com.oscarok.Threads.PhotoThread;
import com.oscarok.Threads.PostThread;
import com.oscarok.Threads.SaveThread;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class MainWindow {
    private JPanel Panel;
    private JTabbedPane tabbedPane;
    private JPanel PostsPanel;
    private JPanel PhotosPanel;
    private JTextArea postArea;
    private JTextField TitleTextField;
    private JButton searchButton;
    private JButton clearButton;
    private JLabel imageField;
    private JTextField imageTitleField;
    private JButton searchButtonImage;
    private JButton saveButtonImage;
    private JButton clearButtonImage;
    private JLabel ImageLabel;

    public MainWindow() {

        clearButton.addActionListener(e -> {
            TitleTextField.setText("");
            postArea.setText("");
        });
        searchButton.addActionListener(e -> {
            if (!TitleTextField.getText().isEmpty()) {
                PostThread postThread = new PostThread(TitleTextField.getText(), postArea);
                postThread.run();
            }
        });
        searchButtonImage.addActionListener(e -> {
            if (!imageTitleField.getText().isEmpty()) {
                PhotoThread photoThread = new PhotoThread(imageTitleField.getText(), imageField);
                photoThread.start();
            }
        });
        clearButtonImage.addActionListener(e -> {
            imageTitleField.setText("");
            imageField.setText("");
            imageField.setIcon(null);
        });
        saveButtonImage.addActionListener(e -> {
            if (imageField.getIcon() != null && !imageTitleField.getText().isEmpty()) {
                (new SaveThread(imageField, imageTitleField.getText())).start();
            }
        });
    }


    public static void main(String[] args) {
        MainWindow mainWindow = new MainWindow();
        JFrame frame = new JFrame("Dummy");
        frame.setContentPane(mainWindow.Panel);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
