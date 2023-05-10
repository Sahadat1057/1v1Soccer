import java.awt.*;

public class Entities {
        public int xCoord;
        public int yCoord;
        public int speed;
        public int spriteCounter = 0;
        public int spriteNum = 1;
        public String direction;
        public Rectangle hitBox;
        public boolean collisionOn = false;

        public Entities()
        {

        }

        public Entities(int x , int y)
        {
            xCoord = x;
            yCoord = y;
        }
    }


