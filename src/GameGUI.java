import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements KeyListener {

    private JLabel label;
    private JPanel panel;
    private ImageIcon ball;

    public GameGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLayout(null);
        this.setVisible(true);
        this.addKeyListener(this);

        label = new JLabel();
        label.setBounds(0, 0, 60, 60);
        label.setOpaque(true);
        this.add(label);


        ImageIcon ball = new ImageIcon("src/Ball.png");
        Image image = ball.getImage(); // transform it
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ball = new ImageIcon(newimg);  // transform it back

        label.setIcon(ball);
    }

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyChar()) {
            case 'a': label.setLocation(label.getX()-10, label.getY());
                break;
            case 'w': label.setLocation(label.getX(), label.getY() -10);
                break;
            case 's': label.setLocation(label.getX(), label.getY()+10);
                break;
            case 'd': label.setLocation(label.getX() + 10, label.getY());
                break;
        }
    }

    public void keyReleased(KeyEvent e) {

    }

}
