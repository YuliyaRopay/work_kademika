package day12.balls;


import java.awt.*;

public class Ball extends Thread{

    private int x;
    private int y;

    private Color color;
    private int radius=20;

    private int speed;

    public Ball(){

    }

    public Ball(int x, int y, Color color, int speed) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.speed = speed;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void draw(Graphics g) {
        g.setColor(color);
        g.fillOval(x,y,radius,radius);
    }

    @Override
    public void run() {
        boolean flagDirection=true;

        System.out.println("Thread is starting .... : "+Thread.currentThread().getName());

        while (true){
            if(flagDirection){
                x=x+1;
            }
            else {
                x=x-1;
            }

            if((x+radius)==500){
                flagDirection=false;
            }

            if((x+radius)==0){
                flagDirection=true;
            }

            try {
                Thread.sleep(speed);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

