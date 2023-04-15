/*
US: 150 - 300, 350-400
Aus: 900-1000, 550-600
China 800-900, 370-420
India 750-810, 400-480
*/

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.time.*;
import java.util.*;

class FindZoneId {
    public static void main(String[] rk) {
        Set<String> zones = ZoneId.getAvailableZoneIds();
        for (String s : zones) {
            ZoneId z = ZoneId.of(s);
            System.out.println(s + "\t" + z);
        }

    }
}

class MouseListenerDemo {
    static public void main(String[] rk) {
        JFrame f = new JFrame();
        f.setSize(1150, 760);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel l = new JLabel("Location of Mouse", JLabel.CENTER);
        f.add(l, BorderLayout.NORTH);
        l.setFont(new Font(Font.SERIF, 3, 36));

        JLabel jl = new JLabel(new ImageIcon("map.jpg"));
        f.add(jl);

        class MyListener extends MouseAdapter {
            int x;
            int y, clicks;

            public void mouseMoved(MouseEvent m) {
                x = m.getX();
                y = m.getY();
                l.setText(x + ", " + y);
                if ((x >= 750 && x <= 810) && (y <= 480 && y >= 400)) // India
                {
                    ZoneId z = ZoneId.of("Asia/Calcutta");
                    LocalTime t = LocalTime.now(z);
                    l.setText("Welcome to India. Time is: " + t);
                }

                else if ((x >= 150 && x <= 300) && (y <= 400 && y >= 350)) // Us
                {
                    ZoneId z = ZoneId.of("US/Arizona");
                    LocalTime t = LocalTime.now(z);
                    l.setText("Welcome to US. Time is: " + t);
                } else if ((x >= 900 && x <= 1000) && (y <= 600 && y >= 550)) // Australia
                {
                    ZoneId z = ZoneId.of("Australia/Eucla");
                    LocalTime t = LocalTime.now(z);
                    l.setText("Welcome to Australia. Time is: " + t);
                } else if ((x >= 800 && x <= 900) && (y <= 420 && y >= 370)) // china
                {
                    ZoneId z = ZoneId.of("China");
                    LocalTime t = LocalTime.now(z);
                    l.setText("Welcome to China. Time is: " + t);
                } else if ((x >= 320 && x <= 480) && (y <= 275 && y >= 80)) // Greenland
                {
                    ZoneId z = ZoneId.of("Asia/Calcutta");
                    LocalTime t = LocalTime.now(z);
                    l.setText("Welcome to Greenland. Time is: " + t);
                }

            }

            public void mouseClicked(MouseEvent m) {
                clicks = m.getClickCount();
                System.out.println("Clicked");
                System.out.println(clicks + " times clicked");
            }

            public void mousePressed(MouseEvent m) {
                System.out.println("Pressed");
            }

            public void mouseReleased(MouseEvent m) {
                System.out.println("Released");

            }
        }

        MyListener ml = new MyListener();
        f.addMouseMotionListener(ml);
        f.addMouseListener(ml);
        f.setVisible(true);
    }
}