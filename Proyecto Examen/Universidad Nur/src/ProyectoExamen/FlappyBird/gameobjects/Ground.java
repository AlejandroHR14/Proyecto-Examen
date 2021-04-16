package ProyectoExamen.FlappyBird.gameobjects;

import ProyectoExamen.FlappyBird.loaders.GraphicsLoader;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Ground {
    private BufferedImage image;
    private int x1;
    private int x2;
    private float velX;

    public Ground() {
        this.x1= 0;
        this.x2= 432;
        this.velX= 3.0f;
        this.image= GraphicsLoader.loadGraphics("ground.png");
    }
    public void tick() {
        this.x1 -= (int) this.velX;
        this.x2 -= (int) this.velX;
        if (this.x1 + 432 < 0) {
            this.x1= 432;
        }
        if (this.x2 + 432 < 0) {
            this.x2= 432;
        }
    }
    public void render (Graphics g) {
        g.drawImage(this.image, this.x1, 600, null);
        g.drawImage(this.image, this.x2, 600, null);
    }
}
