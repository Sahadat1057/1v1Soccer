import javax.swing.*;
import java.awt.*;

public class Ball {
    private int normalSpeed;
    private int maxSpeed;
    public Ball (int normalSpeed, int maxSpeed) {
        this.normalSpeed = normalSpeed;
        this.maxSpeed = maxSpeed;
    }

    public int getNormalSpeed() {
        return normalSpeed;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }
}
