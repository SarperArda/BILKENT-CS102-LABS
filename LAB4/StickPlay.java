/**
 * This class is main class
 * sarper arda bakır
 * 24 march 22
 */

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyVetoException;
import java.beans.VetoableChangeListener;

public class StickPlay {
    public static void main(String[] args){
        //Initializing
        JFrame frame = new JFrame ("Lab4");
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(2,1));
        StickFigure sf = new StickFigure(175*5,0,"grey",400);


        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(1,4));

        frame.getContentPane().add(sf);

        //Move Buttons
        JPanel panelMove = new JPanel();

        JButton mLeft = new JButton("Move Left");
        mLeft.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sf.setM(-5);
            }
        });
        mLeft.setSize(10,10);

        JButton mRight = new JButton("Move Right");
        mRight.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sf.setM(5);
            }
        });
        mRight.setSize(10,10);

        JButton stop = new JButton("Stop");
        stop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sf.setM(0);
            }
        });
        stop.setSize(10,10);

        panelMove.add(mRight);
        panelMove.add(stop);
        panelMove.add(mLeft);

        panel.add(panelMove);


        //Visibile Check Boxes
        JPanel panelVisible = new JPanel();

        JRadioButton eye = new JRadioButton("Eyes");

        eye.addActionListener(new ActionListener() {
            int eyeN = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                eyeN = eyeN + 1;
                if(eyeN % 2 == 1) {
                    sf.setVisibleEye(false);
                }
                if(eyeN % 2 == 0){
                    sf.setVisibleEye(true);
                }

            }
        });

        JRadioButton nose = new JRadioButton("Nose");
        nose.addActionListener(new ActionListener() {
            int x = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                if(x % 2 == 1) {
                    sf.setVisibleNose(false);
                }
                if(x % 2 == 0){
                    sf.setVisibleNose(true);
                }
            }
        });

        JRadioButton ear = new JRadioButton("Ear");
        ear.addActionListener(new ActionListener() {
            int earN = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                earN++;
                if(earN % 2 == 1) {
                    sf.setVisibleEar(false);
                }
                if(earN % 2 == 0){
                    sf.setVisibleEar(true);
                }
            }
        });

        panelVisible.add(nose);
        panelVisible.add(ear);
        panelVisible.add(eye);
        panel.add(panelVisible);

        //Chooser Color
        //This codes does not working properly.
       JColorChooser choseColor = new JColorChooser();
        choseColor.addVetoableChangeListener(new VetoableChangeListener() {
            @Override
            public void vetoableChange(PropertyChangeEvent evt) throws PropertyVetoException {
                String color = choseColor.getName();
                sf.setColor(color);
                System.out.println(color);
            }
        });


        //Height Changes Slider
        JSlider height = new JSlider(200,400);
        height.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int value = height.getValue();
                sf.setSize(value);
            }
        });


        panel.add(height);

        panel.add(choseColor);
        frame.add(panel);



        frame.pack();
        frame.setVisible(true);

    }


}
