package Main;

import Enemy.EnemyDisplay;
import Player.Display;
import UI.UIDisplay;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Render extends JPanel {
    private Display display;
    private List<EnemyDisplay> enemyDisplayList = new ArrayList<EnemyDisplay>();
    private UIDisplay UI;


    public Render(Display display, List enemyDisplayList, UIDisplay UI){
        this.display = display;
        this.enemyDisplayList = enemyDisplayList;
        this.UI = UI;


    }
    public void paint(Graphics g){
        super.paint(g);
        UI.drawUI(g);
        display.drawPlayer(g);

        for(EnemyDisplay ed: enemyDisplayList){
            ed.drawEnemy(g);
        }

    }
}
