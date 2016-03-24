package day8;


import javax.swing.*;
import java.awt.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class HwFr3Square2 {
    private int r;
    private int b;
    private SquarePanel panel;

    public static void main(String[] args) {
        HwFr3Square2 fr3=new HwFr3Square2();
    }

    public HwFr3Square2(){
        JFrame frame=new JFrame();
        frame.setLocation(100,100);
        frame.setMinimumSize(new Dimension(800,600));

        b=0;
        r=0;
        panel=new SquarePanel();

        panel.addMouseListener(new ChangeColor());
        frame.getContentPane().add(panel);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    class SquarePanel extends JPanel{
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(new Color(r, 200, b));
            g.fillRect(250, 50, 300, 300);
        }
    }

    class ChangeColor implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {
            Random random =new Random();
            r=random.nextInt(255);
            b=random.nextInt(255);
            panel.repaint();

        }

        @Override
        public void mousePressed(MouseEvent e) {

        }

        @Override
        public void mouseReleased(MouseEvent e) {

        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
    }

}
