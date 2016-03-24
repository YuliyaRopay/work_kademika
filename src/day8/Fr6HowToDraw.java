package day8;

import javax.swing.*;
import java.awt.*;

public class Fr6HowToDraw  extends JPanel{

    static int x=50;

    public Fr6HowToDraw(){
        JFrame frame=new JFrame("Title");
        frame.setLocation(750,150);
        frame.setMinimumSize(new Dimension(600,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //добавляем панель в ContentPane
        //extends JPanel -чтобы было удобно переписывать методы панели
        frame.getContentPane().add(this);

        frame.pack();
        frame.setVisible(true);

        //repaint();
    }

    //переписываем метод, для отрисовки своей панели
    @Override
    protected void paintComponent(Graphics g) {
        //обнуляет, очищает панель и все заново перерисовывает
        super.paintComponent(g);

        g.setColor(Color.orange);
        g.fillRect(x,50,10,10);

        g.setColor(Color.blue);
        g.fillRect(100,100,10,10);
    }

    public static void main(String[] args) throws Exception{

        Fr6HowToDraw htd =new Fr6HowToDraw();

        Thread.sleep(5000);
        System.out.println("woke up");

        x=150;

        //repaint вызывает paintComponent
        htd.repaint();


    }

}
