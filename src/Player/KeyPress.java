package Player;

import Player.Logic;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyPress implements KeyListener {

    private Logic logic;

    public KeyPress(Logic logic){
        this.logic = logic;
    }
    @Override
    public void keyTyped(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            logic.moveUp();
        }
        else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            logic.moveDown();
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            logic.moveLeft();
        }
        else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            logic.moveRight();
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_UP) {
                logic.moveUp();
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                logic.moveDown();
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                logic.moveLeft();
            }
            else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                logic.moveRight();
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
