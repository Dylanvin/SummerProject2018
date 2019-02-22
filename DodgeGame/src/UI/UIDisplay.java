package UI;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class UIDisplay extends JPanel{
        public Frame frame;
        public int boarderHeight;
        public int time;

        public UIDisplay(Frame frame, int boarderHeight) {
            this.frame = frame;
            this.boarderHeight = boarderHeight;
        }
        public void drawUI(Graphics g) {
           // Graphics g2 = new Graphics(g);
            g.setColor(new Color(100, 100, 0));
            g.fillRect(0, 0, frame.getWidth(),  boarderHeight);
         //   g.drawString(Integer.toString(time), frame.getWidth() / 2, boarderHeight / 2);
        }
        public void setTime(int time){
            this.time = time;

        }
    }

