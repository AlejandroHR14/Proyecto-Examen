package ProyectoExamen.FlappyBird.handlers;

import ProyectoExamen.FlappyBird.main.ProyectoExamen;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == 32) {
            ProyectoExamen.bird.setVelY(-5.0f);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
