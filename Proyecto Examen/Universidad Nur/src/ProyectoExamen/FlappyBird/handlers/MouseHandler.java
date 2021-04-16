package ProyectoExamen.FlappyBird.handlers;

import ProyectoExamen.FlappyBird.main.ProyectoExamen;

import ProyectoExamen.FlappyBird.supers.Button;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {

    }
    @Override
    public void mousePressed(MouseEvent e) {
        ProyectoExamen.bird.setVelY(-5.0f);
        if (Button.checkCollision(e.getX(), e.getY(), ProyectoExamen.startButton) && ProyectoExamen.gameover) {
            ProyectoExamen.startButton.pressed= true;
            ObjectHandler.List.clear();
            ObjectHandler.addObject(ProyectoExamen.bird);
            ProyectoExamen.gameover= false;
            ProyectoExamen.score= 0;
            ProyectoExamen.startButton.pressed= false;
        }
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
