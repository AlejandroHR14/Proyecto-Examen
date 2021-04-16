package ProyectoExamen.FlappyBird.handlers;

import ProyectoExamen.FlappyBird.gameobjects.Tube;
import ProyectoExamen.FlappyBird.enums.TubeType;
import java.util.Random;

public class TubeHandler {
    private static Random random;
    public static int groundSize;
    public static int area;
    public static int spacing;
    public static int minSize;
    public static int maxSize;
    public static int delay;
    public static int now;

    static {
        TubeHandler.random= new Random();
        TubeHandler.groundSize= 168;
        TubeHandler.area= 768 - TubeHandler.groundSize;
        TubeHandler.spacing= 120;
        TubeHandler.minSize= 40;
        TubeHandler.maxSize = TubeHandler.area - TubeHandler.spacing - TubeHandler.minSize;
        TubeHandler.delay= 1;
    }
    public static void spawnTube() {
        int heightTop;
        for (heightTop = TubeHandler.random.nextInt(TubeHandler.maxSize) + 1; heightTop < TubeHandler.minSize; heightTop = TubeHandler.random.nextInt(TubeHandler.maxSize) + 1) {

        }
        int heightBottom = TubeHandler.area - TubeHandler.spacing - heightTop;
        Tube tubeTop = new Tube(500, 0, 78, heightTop, TubeType.TOP);
        Tube tubeBottom = new Tube(500, heightTop + TubeHandler.spacing, 78, heightBottom, TubeType.BOTTOM);
        ObjectHandler.addObject(tubeTop);
        ObjectHandler.addObject(tubeBottom);
    }
    public static void tick() {
        if (TubeHandler.now < TubeHandler.delay) {
            TubeHandler.now++;
        }
        else {
            spawnTube();
            TubeHandler.now= 0;
        }
    }
}
