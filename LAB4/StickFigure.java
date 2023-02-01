/**
 * This class is for Stick Figure. This class takes an codes from Smiling Face to create face.
 *  * sarper arda bakır
 *  * 24 march 22
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StickFigure extends JPanel {

    //Variable
    private int x;
    private int y;
    private int m;
    private String color;
    private int size;
    Timer timer;
    private boolean visibleEye;
    private boolean visibleNose;
    private boolean visibleEar;

    //Constructor
    public StickFigure(int x, int y,String color, int size) {
        this.x = x;
        this.y = y;
        m = +5;
        this.color = color;
        this.size = size;
        visibleEye = true;
        visibleEar = true;
        visibleNose = true;

        ActionListener listener = new TimerListener();
        timer = new Timer(100,listener);
        timer.start();
        repaint();

    }
    //Setter methods
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }


    public void setM(int m) {
        this.m = m;
    }

    public void setVisibleEye(boolean visibleEye) {
        this.visibleEye = visibleEye;
    }

    public void setVisibleNose(boolean visibleNose) {
        this.visibleNose = visibleNose;
    }

    public void setVisibleEar(boolean visibleEar) {
        this.visibleEar = visibleEar;
    }

    public void setSize(int size) {
        this.size = size;
    }


    public void setColor(String color) {
        this.color = color;
        repaint();
    }

    /**
     * Move method is to animation.
     * @param x
     * @param y
     */
    public void move(int x, int y){
        setX(x);
        setY(y);
        repaint();
    }

    public void paintComponent (Graphics page) {
        super.paintComponent(page);

        //Smiling Face codes and visibility check
        if(color.equals("grey")){
         page.setColor(Color.gray);}
        else{
            page.setColor(Color.getColor(color));
        }
         page.fillOval(x, y, 80, 80);  // head
         if (visibleEar) {
             page.fillOval(x - 5, y + 20, 90, 40);  // ears

         }
         page.setColor(Color.cyan);
         if (visibleEye) {
             page.drawOval(x + 20, y + 30, 15, 7);  // eyes
             page.drawOval(x + 45, y + 30, 15, 7);
         }
         page.fillOval(x + 25, y + 31, 5, 5);   // pupils
        page.fillOval(x + 50, y + 31, 5, 5);

        page.drawArc(x + 20, y + 25, 15, 7, 0, 180);  // eyebrows
        page.drawArc(x + 45, y + 25, 15, 7, 0, 180);
        if (visibleNose) { page.drawArc(x + 35, y + 40, 15, 10, 180, 180);  // nose
        }
        page.drawArc(x + 20, y + 50, 40, 15, 180, 180);  // mouth

        //Body Parts
        page.setColor(Color.cyan);
        page.drawRect(x-size/2,y+80,size,size);
        page.setColor(Color.black);
        page.drawLine(x-size/2,y+80+size/2,x-size/2-size/2,y+80+size/2);
        page.drawLine(x+size/2,y+80+size/2,x+size,y+80+size/2);
        page.drawLine(x,y+80+size,x-size/2,y+80+size*3/2);
        page.drawLine(x,y+80+size,x+size/2,y+80+size*3/2);

    }
    //Timer Class
    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            move(x + m,y);
            if(x == 350 * 5){
                move(0,0);
            }


        }
    }


}
