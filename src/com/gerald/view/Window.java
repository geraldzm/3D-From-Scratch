package com.gerald.view;

import com.gerald.model.Main;
import javax.swing.*;
import java.awt.*;

public class Window{
    public Window(int widht, int height, String title, Main game) {
        JFrame frame = new JFrame(title);

        frame.setPreferredSize(new Dimension(widht, height));
        frame.setMaximumSize(new Dimension(widht, height));
        frame.setMinimumSize(new Dimension(widht, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();
    }
}