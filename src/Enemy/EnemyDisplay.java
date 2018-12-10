package Enemy;
import Enemy.EnemyLogic;
import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class EnemyDisplay extends JPanel {
    private int x ;
    private int y ;
    private boolean harmless = false;
    private Color colour;
    int red;
    int green;
    int blue;

    public EnemyDisplay(){
         red = randCol();
         green = randCol();
         blue = randCol();
    }

    public void drawEnemy(Graphics g) {

        if (!harmless) {
            g.setColor(new Color(randCol(), randCol(), randCol()));
        }
        else
        {
            g.setColor(new Color(red, green, blue));

        }
        g.fillRect(x, y , EnemyLogic.eHight , EnemyLogic.eWidth);
    }
    private int randCol() {
        int num;
        Random randomNumber = new Random();
        num = randomNumber.nextInt(255);
        return num;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public void isHarmless(){this.harmless = true;}
}
