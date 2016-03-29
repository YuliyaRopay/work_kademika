package day12.gate;


import javax.swing.*;
import java.awt.*;

public class StarGate extends JPanel{

    public static void main(String[] args) {
        new StarGate();
    }

    private static final int WIDTH=400;

    private Ship ship;
    private Gates gates;

    public StarGate(){
        JFrame frame= new JFrame("STARGATE");
        frame.setLocation(450,150);
        frame.setMinimumSize(new Dimension(WIDTH,400));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        ship=new Ship(10,170,5,Color.GREEN);
        gates=new Gates();

        turnOnGates();

        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    moveShip();
                }catch (Exception e){
                    // ignore
                }
            }
        }).start();


        while(true){
            repaint();
            sleep(1000/60);
        }
    }

    private boolean isShipInRange(){
        return ship.x>(gates.topX-18)&& ship.x<gates.topX;
    }

    private void turnOnGates(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    synchronized (gates){
                        System.out.println("Mothship: Waiting for the ship.");
                        gates.wait();
                    }

                    while(!gates.isOpen){
                        animateGates();
                    }

                    synchronized (ship){
                        ship.notify();
                    }
                }catch(Exception e){
                    //ignore
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void animateGates(){
        if(!gates.isOpen){
            if(gates.topY>gates.openTopY){
                gates.topY--;
            }
            if(gates.bottomY<gates.openBottomY){
                gates.bottomY++;
            }
            if(gates.topY==gates.openTopY){
                gates.bottomY=gates.openBottomY;
                gates.isOpen=true;
                System.out.println("Mothship: Gates opened, please come in...");
                synchronized (ship){
                    ship.notify();
                }

            }else{
                sleep(15);
            }
        }
    }

    private void moveShip() throws Exception{
        while(ship.x<=WIDTH-ship.radius*5){
            if(!gates.isOpen && isShipInRange()){
                synchronized (gates){
                    gates.notify();
                    System.out.println("Ship: Asked permissions");
                }
                synchronized (ship){
                    System.out.println(" nad waiting gates to open");
                    ship.wait();
                }
            }

            ship.x++;
            sleep(5);
        }

        System.out.println("Ship: Back home, waiting for other tasks");
    }


    private void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(ship.color);
        g.fillOval(ship.x, ship.y, ship.radius*2, ship.radius*2);

        g.setColor(gates.color);
        g.fillRect(gates.topX, gates.topY, gates.topWidth, gates.doorHeight);
        g.fillRect(gates.bottomX, gates.bottomY, gates.bottomWidth, gates.doorHeight);

    }
}
