package day12.rocket;


import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.io.IOException;

public class StartRocket extends JPanel{

    public static void main(String[] args) {
        new StartRocket();
    }

    private Image imageBg;
    private Image imageRocket;
    private Image imageBaum1;
    private Image imageBaum2;
    private Rocket rocket;
    private Gates gates;
    private boolean stopRocket=false;


    public StartRocket(){

        setAllImages();

        JFrame frame= new JFrame("STARGATE");
        frame.setLocation(450,100);
        frame.setMinimumSize(new Dimension(600,600));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.pack();
        frame.setVisible(true);

        rocket=new Rocket();
        gates=new Gates();

        turnOnGates();
        startRocket();

        while(true){

            repaint();
            sleep(1000/60);
        }

    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(imageBg, 0, 0,new ImageObserver(){
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height){
                return false;
            }
        });


        g.drawImage(imageRocket, rocket.x, rocket.y,new ImageObserver(){
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height){
                return false;
            }
        });

        g.drawImage(imageBaum2, gates.topX, gates.topY,new ImageObserver(){
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height){
                return false;
            }
        });

        g.drawImage(imageBaum1, gates.bottomX, gates.bottomY,new ImageObserver(){
            @Override
            public boolean imageUpdate(Image img, int infoflags, int x, int y, int width, int height){
                return false;
            }
        });
    }


    //
    private void turnOnGates(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    synchronized (gates){
                        gates.wait();
                    }

                    while (!stopRocket){
                        animateGates();
                    }

                    synchronized (rocket){
                        rocket.notify();
                    }
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

    //
    private void startRocket(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try{
                    moveRocket();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }


    //
    private void animateGates(){
        if(!gates.isOpen){
            if(gates.topX>gates.openTopX){
                gates.topX--;
            }
            if(gates.bottomX<gates.openBottomX){
                gates.bottomX++;
            }
            if(gates.topX==gates.openTopX){
                gates.bottomX=gates.openBottomX;
                gates.isOpen=true;
                synchronized (rocket){
                    rocket.notify();
                }

            }else{
                sleep(15);
            }
        }


        if(gates.isOpen){
            if(gates.topX<=gates.closeTopX){
                gates.topX++;
            }
            if(gates.bottomX>=gates.closeBottomX){
                gates.bottomX--;
            }
            if(gates.topX==gates.closeTopX){
                //stopRocket=true;
                //gates.isOpen=false;
            }
            sleep(25);
        }

    }


    //
    private void moveRocket() throws Exception{
        //while(rocket.y>=0){
        while(true){
            if(!gates.isOpen && isRocketNearGates()){
                synchronized (gates){
                    gates.notify();
                }
                synchronized (rocket){
                    rocket.wait();
                }
            }

            if(gates.isOpen && isRocketFlewGates()){
                 synchronized (gates){
                    gates.notify();
                }
            }

            rocket.y--;
            sleep(5);

            if(rocket.y+rocket.height<=0){
                rocket.y=450;
                rocket.x=260;
                gates.isOpen=false;
            }
        }
    }


    //
    private boolean isRocketNearGates(){
        return rocket.y<(gates.topY+40);
    }

    //
    private boolean isRocketFlewGates(){
        return (rocket.y+rocket.height)>(gates.topY+40);
    }


    //
    private void setAllImages(){
        imageBg=setImage("/day12/rocket/img/zvezda.png");
        imageRocket=setImage("/day12/rocket/img/rocket.png");
        imageBaum1=setImage("/day12/rocket/img/baum1.png");
        imageBaum2=setImage("/day12/rocket/img/baum2.png");
    }

    //
    private Image setImage(String nameImg){
        Image image=null;

        try{
            image= ImageIO.read(getClass().getResource(nameImg));
        }catch(IOException e){
            System.out.println("Error! The picture "+nameImg+" is not loaded"+" "+e.getMessage());

        }
        return image;
    }


    //
    private void sleep(int timeout){
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
