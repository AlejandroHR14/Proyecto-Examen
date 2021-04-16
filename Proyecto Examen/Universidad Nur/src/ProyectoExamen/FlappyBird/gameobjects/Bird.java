package ProyectoExamen.FlappyBird.gameobjects;

import java.awt.Graphics;
import ProyectoExamen.FlappyBird.main.ProyectoExamen;
import ProyectoExamen.FlappyBird.supers.GameObject;
import java.awt.image.BufferedImage;
import ProyectoExamen.FlappyBird.handlers.ObjectHandler;
import ProyectoExamen.FlappyBird.loaders.GraphicsLoader;
import ProyectoExamen.FlappyBird.supers.Animation;

public class Bird extends GameObject {

    Animation animation;
    public float gravity;
    public float maxSpeed;

    public Bird(int x, int y, int width, int height) {
        super(x, y, width, height);
        this.gravity = 0.3f;
        this.maxSpeed = 12.0f;
        BufferedImage[] images = new BufferedImage[3];
        for (int i = 0; i < images.length; ++i) {
            images[i] = GraphicsLoader.loadGraphics("bird" + i + ".png");
        }
        (this.animation = new Animation(this, 100, true, images)).start();
        ObjectHandler.addObject(this);
    }

    @Override
    public void tick() {
        this.velY += this.gravity;
        this.y += (int)this.velY;
        if (this.velY > this.maxSpeed) {
            this.velY = this.maxSpeed;
        }
        if (this.y + this.height > 602) {
            this.y = 602 - this.height;
            this.setVelY(0.0f);
        }
        if (this.y < 0) {
            this.y = 0;
            this.setVelY(0.0f);
        }
        GameObject temp = null;
        for (int i = 0; i < ObjectHandler.List.size(); ++i) {
            temp = ObjectHandler.List.get(i);
            if (temp instanceof Tube && this.getBounds().intersects(temp.getBounds())) {
                ProyectoExamen.gameover = true;
            }
        }
        this.animation.tick();
    }

    @Override
    public void render(Graphics g) {
        this.animation.render(g);
    }
}
