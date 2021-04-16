package ProyectoExamen.FlappyBird.main;

import javax.swing.JFrame;
import java.io.IOException;
import java.net.ServerSocket;

@SuppressWarnings("serial")
public class Window extends JFrame {
    
    public Window(int width, int height, String title, ProyectoExamen game) {
        try {
            game.serverSocket = new ServerSocket(9999);
            
        } catch (IOException e){
            System.exit(0);
        }
        
        this.setTitle(title);
        this.pack();
        this.setSize(width + this.getInsets().left + this.getInsets().right, height + this.getInsets().top + this.getInsets().bottom);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(3);
        this.setVisible(true);
        this.add(game);
        game.start();
    }
    
}
