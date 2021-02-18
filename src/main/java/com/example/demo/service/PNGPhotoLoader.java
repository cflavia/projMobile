package com.example.demo.service;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class PNGPhotoLoader implements PhotoLoader {

    public static void load(String url) throws IOException {

        File file = new File(url);
        BufferedImage image = null;
        image = ImageIO.read(file);
        JLabel picLabel = new JLabel(new ImageIcon(image));

        JPanel jPanel = new JPanel();
        jPanel.add(picLabel);

        JFrame f = new JFrame();
        f.setSize(new Dimension(image.getWidth(), image.getHeight()));
        f.add(jPanel);
        f.setVisible(true);
    }
}
