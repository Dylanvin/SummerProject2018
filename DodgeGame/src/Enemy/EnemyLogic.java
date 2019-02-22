package Enemy;
import Main.Core;
import Player.Display;
import Player.Logic;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class EnemyLogic{
    private Frame frame;
    private EnemyDisplay enemyDisplay;
    private Logic logic;
    private Core core;
    private int x;
    private int y;
    private int lastX;
    private int lastY;
    private int xSpeed = 5;
    private int ySpeed = 5;
    private int followSpeed = 3;
    private int counter = 100;
    private boolean harmless = true;
    private boolean bounce;
    public static int eHight = 30;
    public static int eWidth = 30;


    public EnemyLogic(Frame frame, EnemyDisplay enemyDisplay, Logic logic, Core core){
        this.frame = frame;
        this.enemyDisplay = enemyDisplay;
        this.logic = logic;
        this.core = core;
        int ranX;
        Random randomNumberX = new Random();
        ranX = randomNumberX.nextInt(frame.getWidth());
        this.lastX = ranX;
        int ranY;
        ranY = ThreadLocalRandom.current().nextInt(Core.TOPBOARDER, frame.getHeight() + 1);
        this.lastY = ranY;

        /// ai choice
        Random bounceBool = new Random();
        bounce = bounceBool.nextBoolean();


    }

    public void ai(){
        if(bounce) {
            if (lastY < Core.TOPBOARDER) {
                ySpeed = -ySpeed;
            } else if (lastY + eHight + (ySpeed * 2) > frame.getHeight()) {
                ySpeed = -ySpeed;
            }
            y = lastY + ySpeed;
            enemyDisplay.setY(y);
            //  frame.repaint();
            lastY = y;


            if (lastX - eWidth < 0) {
                xSpeed = -xSpeed;
            } else if (lastX + eWidth > frame.getWidth()) {
                xSpeed = -xSpeed;
            }
            x = lastX + xSpeed;
            enemyDisplay.setX(x);
            //  frame.repaint();
            lastX = x;

            System.out.println(lastX);
            System.out.println(lastY);

        }
        else {

            int diffX = logic.getX() - x;
            int diffY = logic.getY() - y;

            float angle = (float)Math.atan2(diffY, diffX);

            x += followSpeed * Math.cos(angle);
            y += followSpeed * Math.sin(angle);
            enemyDisplay.setX(x);
            enemyDisplay.setY(y);
            lastX = x;
            lastY = y;
        }

        if (counter != 0) {
            counter -= 1;       /////harmless
        } else {
            harmless = false;
            enemyDisplay.isHarmless();        ////harmful
            if (overlaps(lastX, lastY)) {
                core.end();
            }
        }
    }
    public boolean overlaps (int x, int y) {
        return x < logic.getX() + Core.playerWidth && x + eWidth > logic.getX() && y < logic.getY() + Core.playerHeight && y + eHight > logic.getY();
    }
}
