package ProyectoExamen.FlappyBird.main;
import ProyectoExamen.FlappyBird.handlers.TubeHandler;
import ProyectoExamen.FlappyBird.handlers.ObjectHandler;
import ProyectoExamen.FlappyBird.loaders.GraphicsLoader;
import ProyectoExamen.FlappyBird.handlers.KeyHandler;
import ProyectoExamen.FlappyBird.handlers.MouseHandler;
import ProyectoExamen.FlappyBird.supers.Button;
import ProyectoExamen.FlappyBird.gameobjects.Bird;
import ProyectoExamen.FlappyBird.gameobjects.Ground;

import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.Color;
import java.awt.Font;
import java.net.ServerSocket;
import java.awt.image.BufferedImage;
import java.awt.Canvas;

@SuppressWarnings("serial")
public class ProyectoExamen extends Canvas implements Runnable {
    public static final int WIDTH = 432;
    public static final int HEIGHT = 768;

    public boolean running;
    public static boolean gameover;
    public static BufferedImage img_gameover;
    public static BufferedImage background;
    public static Ground ground;
    public static Bird bird;
    public static Button startButton;
    public static int score;

    Thread thread;
    ServerSocket serverSocket;

    public static void main(final String[] args) {
        new Window(432, 768, "FlappyBird Alejandro Hurtado :)", new ProyectoExamen());
    }

    public synchronized void start() {
        this.running = true;
        (this.thread = new Thread()).start();
        this.run();
    }

    public void init() {
        this.addKeyListener(new KeyHandler());
        this.addMouseListener(new MouseHandler());
        ProyectoExamen.img_gameover = GraphicsLoader.loadGraphics("gameover.png");
        ProyectoExamen.background = GraphicsLoader.loadGraphics("background.png");
        ProyectoExamen.ground = new Ground();
        ProyectoExamen.bird = new Bird(50, 50, 51, 36);
        ProyectoExamen.startButton = new Button(138, 200, 156, 87, GraphicsLoader.loadGraphics("playbutton.png"));
    }

    public void tick() {
        if (!ProyectoExamen.gameover) {
            ObjectHandler.tick();
            ProyectoExamen.ground.tick();
        }
    }

    public void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.drawImage(ProyectoExamen.background, 0, 0, null);
        ProyectoExamen.ground.render(g);
        ObjectHandler.render(g);
        if (ProyectoExamen.gameover) {
            g.drawImage(ProyectoExamen.img_gameover, 72, 130, null);
            ProyectoExamen.startButton.render(g);
        }
        g.setFont(new Font("Arial", 1, 48));
        g.setColor(Color.WHITE);
        String s = Integer.toString(ProyectoExamen.score);
        int textWidth = g.getFontMetrics().stringWidth(s);
        g.drawString(s, 216 - textWidth / 2, 40);
        g.dispose();
        bs.show();
    }

    @Override
    public void run() {
        this.init();
        this.requestFocus();
        long pastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0.0;
        long timer = System.currentTimeMillis();
        int updates = 0;
        int frames = 0;
        while (this.running) {
            long now = System.nanoTime();
            delta += (now - pastTime) / ns;
            pastTime = now;
            while (delta > 0.0) {
                this.tick();
                ++updates;
                this.render();
                ++frames;
                --delta;
            }
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS: " + frames + " | TICKS: " + updates);
                TubeHandler.tick();
                updates = 0;
                frames = 0;
            }
        }
    }
}
