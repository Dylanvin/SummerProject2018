package Main;

import Enemy.EnemyLogic;
import Player.Display;
import Player.Logic;
import Player.KeyPress;
import Enemy.EnemyDisplay;
import UI.UIDisplay;
import UI.UILogic;

import javax.swing.*;
import java.awt.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Core {
    private Frame frame;
    private Display display;
    private Logic logic;
    private List<EnemyLogic> enemyLogicList = new ArrayList<EnemyLogic>();
    private List<EnemyDisplay> enemyDisplayList = new ArrayList<EnemyDisplay>();
    public static int playerWidth = 50;
    public static int playerHeight = 50;
    public static final int TOPBOARDER = 70;

    private int counter;

    public Instant start;
    public Instant end;


    public void run(){
        //// creating window
        JFrame frame = new JFrame("Dodge Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize( 1024, 768 );
        ////

        ////adding graphics
        Display display = new Display(playerWidth, playerHeight);
        EnemyDisplay enemyDisplay = new EnemyDisplay();
       // EnemyDisplay enemyDisplay2 = new EnemyDisplay();
        UIDisplay UI = new UIDisplay(frame, TOPBOARDER);
       // UILogic UIL = new UILogic(UI);/////////////////////////////////////////////////////////////////////////////////////
       // UIL.timer();///////////////////////////////////////////////////////////////////////////////////////////////////////
        Render render = new Render(display, enemyDisplayList, UI);
        frame.add(render);
        frame.setVisible(true);
        ////

        ////adding key listener
        Logic logic = new Logic(frame, display);
        frame.addKeyListener(new KeyPress(logic));
        ////
        EnemyLogic enemyLogic = new EnemyLogic(frame, enemyDisplay, logic, this);
        enemyLogicList.add(enemyLogic);
        enemyDisplayList.add(enemyDisplay);

        ////game loop

        start = Instant.now();


        while(true)
        {
            Render r = new Render(display, enemyDisplayList, UI);
            frame.add(r);

            for(EnemyLogic eL: enemyLogicList){
                eL.ai();
            }

            counter += 1;
            //// adding new instance of enemy logic and display
            if(counter == 300){
                enemyDisplayList.add(new EnemyDisplay());
                enemyLogicList.add(new EnemyLogic(frame, enemyDisplayList.get(enemyDisplayList.size() - 1), logic, this));
                counter = 0;
            }
            ////

            frame.repaint();
            try {
                Thread.sleep(20);
            }
            catch (Exception e) {
            }

        }
        ////
    }

    public void end(){
        end = Instant.now();
        Duration timeElapsed = Duration.between(start, end);
        System.out.println("Time taken: " + timeElapsed.getSeconds() + " Seconds");
        ScoreManager sm = new ScoreManager(timeElapsed.getSeconds());
        sm.setScore();
        frame.dispose();
    }

    public int getPlayerWidth(){
        return this.playerWidth;
    }
    public int getPlayerHeight(){
        return this.playerHeight;
    }
}
