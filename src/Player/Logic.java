package Player;

import Main.Core;
import java.awt.*;

public class Logic {
    private Frame frame;
    private Display display;

    private int x = 200;
    private int y = 200;
    private int lastX = 200;
    private int lastY = 200;
    private int speed = 30;

    private int frameH;
    private int frameW;


    public Logic(Frame frame, Display display){
        this.frame = frame;
        this.display = display;
        //this.
    }

    //<editor-fold desc="Key Press methods">
    public void moveUp(){
        if(lastY - Core.playerHeight < Core.TOPBOARDER){
            y = Core.TOPBOARDER;
        }
        else{
            y = lastY - speed;
        }
        display.setY(y);
     //   frame.repaint();
        lastY = y;
    }
    public void moveDown(){
        if(lastY + Core.playerHeight + (speed * 2) > frame.getHeight()) {
            y = lastY;
        }
        else{
            y = lastY + speed;
        }
        display.setY(y);
      //  frame.repaint();
        lastY = y;
    }
    public void moveLeft(){
        if(x - Core.playerWidth < 0){
            x = 0;
        }
        else {
            x = lastX - speed;
        }
        display.setX(x);
      //  frame.repaint();
        lastX = x;
    }
    public void moveRight(){
        if(lastX + Core.playerWidth > frame.getWidth()){
            x = lastX;
        }
        else {
            x = lastX + speed;
        }
        display.setX(x);
       // frame.repaint();
        lastX = x;
    }
    //</editor-fold>

   public int getX(){
        return this.lastX;
   }
    public int getY(){
        return this.lastY;
    }
}

