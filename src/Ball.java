import java.awt.*;

public class Ball extends Entities {
    public boolean playerShot = false;

    public Ball (int x, int y) {
        super(x, y);
        hitBox = new Rectangle(8, 8, 32, 32);
    }
}
