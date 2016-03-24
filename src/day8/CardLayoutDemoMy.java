package day8;


import day8.HwBirds.Bird;
import day8.HwBirds.BirdsStore;
import day8.HwBirds.BirdsType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CardLayoutDemoMy {
    BirdsStore store=new BirdsStore("store1");
   JPanel cards; //a panel that uses CardLayout
    //final static String BUTTONPANEL = "Card with JButtons";
    //final static String TEXTPANEL = "Card with JTextField";

    public void addComponentToPane(Container pane) {


        //Put the JComboBox in a JPanel to get a nicer look.

        JPanel birdsPanel = new JPanel(); //use FlowLayout

        String[] comboBoxItems=store.getBirdsTypeArray();

        JComboBox comboBoxBirds = new JComboBox(comboBoxItems);

        comboBoxBirds.setEditable(false);
        comboBoxBirds.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                CardLayout cl = (CardLayout)(cards.getLayout());
                cl.show(cards, (String)e.getItem());
            }
        });

        birdsPanel.add(comboBoxBirds);

        //
        cards = new JPanel(new CardLayout());
        for(String item:comboBoxItems){
            JPanel card = new JPanel();


            JLabel label=new JLabel(item);
            card.add(label);
            System.out.println(item+"=="+BirdsType.valueOf(item)+"==="+store.getBirdsByTypeList(item).size());
            for(Bird bird: store.getBirdsByTypeList(item)){
                System.out.println(bird.getName());
                JRadioButton rButton=new JRadioButton(bird.getName());
                rButton.setActionCommand(bird.getName());
                card.add(rButton);
            }



            cards.add(card,item);
        }

        pane.add(birdsPanel, BorderLayout.PAGE_START);
        pane.add(cards, BorderLayout.CENTER);
    }


    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("CardLayoutDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Create and set up the content pane.
        CardLayoutDemoMy demo = new CardLayoutDemoMy();
        demo.addComponentToPane(frame.getContentPane());

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();

    }
}
