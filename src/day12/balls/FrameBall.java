package day12.balls;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class FrameBall extends JPanel{

    private ArrayList<Ball> balls;

    public FrameBall(){

        balls = new ArrayList<>();
        createListBalls();

        JFrame frame = new JFrame("BALLS");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocation(400,250);
        frame.setMinimumSize(new Dimension(500, 300));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        frame.pack();

        startBalls();

    }

    private void createListBalls(){
        balls.add(new Ball(5, 15, Color.MAGENTA, 10));
        balls.add(new Ball(5, 40, Color.GREEN, 20));
        balls.add(new Ball(5, 65, Color.ORANGE, 30));
        balls.add(new Ball(5, 90, Color.BLUE, 5));
        balls.add(new Ball(5, 115, Color.DARK_GRAY, 15));
    }

    private void startBalls () {
        for( Ball ball: balls) {
            ball.start();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball b: balls) {
            b.draw(g);
         }

        repaint();
    }
}

