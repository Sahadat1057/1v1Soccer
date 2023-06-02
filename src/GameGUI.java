import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

public class GameGUI extends JFrame implements KeyListener {

    private JLabel ballLabel;
    private JLabel netLabel;

    private JPanel panel;
    private JLabel fieldLabel;
    private Ball ballSpecs;
    private Net netSpecs;
    public Image ballImage;
    public Image netImage;
    public Image fieldImage;


    public GameGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(650,300);
        this.setLayout(null);
        this.setVisible(true);
        this.addKeyListener(this);

        fieldLabel = new JLabel();
        fieldLabel.setBounds(0, 0, 650, 300);
        fieldLabel.setOpaque(true);
        this.add(fieldLabel);


        ballLabel = new JLabel();
        ballLabel.setBounds(325, 200, 60, 60);
        ballLabel.setOpaque(false);

        netLabel = new JLabel();
        netLabel.setBounds(325, 75, 100, 100);
        netLabel.setOpaque(false);


        ImageIcon ball = new ImageIcon("src/Ball.png");
        Image image = ball.getImage(); // transform it
        Image newimg = image.getScaledInstance(60, 60,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ball = new ImageIcon(newimg);  // transform it back
        ballLabel.setIcon(ball);

        ImageIcon net = new ImageIcon("src/Net.png");
        Image image2 = net.getImage();
        Image newimg2 = image2.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);
        net = new ImageIcon(newimg2);
        netLabel.setIcon(net);

        fieldLabel.add(ballLabel);
        fieldLabel.add(netLabel);

        ImageIcon field = new ImageIcon("src/Field.png");
        Image image3 = field.getImage();
        Image newimg3 = image3.getScaledInstance(650, 300, Image.SCALE_SMOOTH);
        field = new ImageIcon(newimg3);
        fieldLabel.setIcon(field);


        ballSpecs = new Ball(10,400);
        netSpecs = new Net(10);
    }

    public void keyTyped(KeyEvent e) {

    }
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {

            case 65:
                    ballLabel.setLocation(ballLabel.getX() - ballSpecs.getNormalSpeed(), ballLabel.getY());
                    break;
            case 68:
                ballLabel.setLocation(ballLabel.getX() + ballSpecs.getNormalSpeed(), ballLabel.getY());
                break;

            case 32:
            /*
                 int speed = ballSpecs.getMaxSpeed() / 10;
                 ballLabel.setLocation(ballLabel.getX(), ballLabel.getY() - speed);
                break;
                */

            }

        System.out.println(e.getKeyCode());

        }

        /*
    public void paintComponent (Graphics g) {
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage( , 0, 0, null);

    }
    */
         public void keyReleased(KeyEvent e){

         }




}
