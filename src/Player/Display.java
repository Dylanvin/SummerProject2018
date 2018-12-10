package Player;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Display extends JPanel {
    private int x = 200;
    private int y = 200;
    private int width;
    private int height;

    public Display(int width, int height){
        this.width = width;
        this.height = height;
    }

    public void drawPlayer(Graphics g) {
        g.setColor(new Color(0, 100, 0));
        g.fillRect(x, y , width , height);
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    private int randCol() {
        int num;
        Random randomNumber = new Random();
        num = randomNumber.nextInt(255);
        return num;
    }
}
