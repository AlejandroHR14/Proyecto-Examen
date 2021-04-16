package ProyectoExamen.FlappyBird.handlers;
import java.awt.Graphics;
import java.util.LinkedList;
import ProyectoExamen.FlappyBird.supers.GameObject;

public class ObjectHandler {
    public static LinkedList<GameObject> List = new LinkedList<GameObject>();
    public static void addObject(GameObject o) {
        ObjectHandler.List.add(o);
    }
    public static void removeObject(GameObject o) {
        ObjectHandler.List.remove(o);
    }
    public static void render(Graphics g) {
        GameObject temp= null;
        for(int i = 0; i <List.size(); i++) {
            temp=ObjectHandler.List.get(i);
            temp.render(g);
        }
    }
    public static void tick() {
        GameObject temp= null;
        for(int i=0; i <List.size(); i++) {
            temp= ObjectHandler.List.get(i);
            temp.tick();
        }
    }
}
