package ProyectoExamen.FlappyBird.gameobjects;

import ProyectoExamen.FlappyBird.handlers.ObjectHandler;
import ProyectoExamen.FlappyBird.loaders.GraphicsLoader;
import ProyectoExamen.FlappyBird.main.ProyectoExamen;
import ProyectoExamen.FlappyBird.supers.GameObject;
import ProyectoExamen.FlappyBird.enums.TubeType;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Tube extends GameObject {
    TubeType type;
    BufferedImage tubeBlock;
    BufferedImage tube;

    public Tube (int x, int y, int width, int height, TubeType type) {
        super(x, y, width, height);
        this.type= type;
        this.velX= 3.0f;
        this.tube = GraphicsLoader.loadGraphics("tube.png");
        if(type == TubeType.BOTTOM) {
            this.tubeBlock = GraphicsLoader.loadGraphics("tubebottomdown.png");
        }
        else if (type == TubeType.TOP) {
            this.tubeBlock= GraphicsLoader.loadGraphics("tubebottomtop.png");
        }
    }

    @Override
    public void tick() {
        this.x -= (int) this.velX;
        if (this.x + this.width < 0) {
            ObjectHandler.removeObject(this);
            if (this.type == TubeType.TOP) {
                ProyectoExamen.score++;
            }
        }
    }

    @Override
    public void render(final Graphics g) {
        if (this.type == TubeType.BOTTOM) {
            g.drawImage(this.tube, this.x, this.y, 72, this.height, null);
            g.drawImage(this.tubeBlock, this.x - 3, this.y, null);
        }
        else if (this.type == TubeType.TOP) {
            g.drawImage(this.tube, this.x, this.y, 72, this.height, null);
            g.drawImage(this.tubeBlock, this.x - 3, this.y + this.height - 36, null);
        }
    }
}
