import javax.swing.*;
import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class GameGUI extends JFrame implements KeyListener {

    private JLabel ballLabel;
    private JLabel netLabel;
    private JLabel scoreLabel;
    private JLabel highScoreLabel;
    private JLabel timerLabel;

    private JLabel fieldLabel;

    private Ball ballSpecs;
    private Net netSpecs;

    private Player player;

    private ArrayList<Integer> scores;
    private int currentScore;



    public GameGUI() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 500);
        // this.setLayout(null);
        this.setVisible(true);
        this.addKeyListener(this);



        scores = new ArrayList<>();


        fieldLabel = new JLabel();
        fieldLabel.setBounds(0, 0, 700, 500);
        fieldLabel.setOpaque(true);
        this.add(fieldLabel);

        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.exit(0);
            }

        };
        timer.schedule(task, 30000);

        scoreLabel = new JLabel("Score: 0");
        scoreLabel.setBounds(630, 0, 40, 10);
        scoreLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 8));
        scoreLabel.setForeground(Color.RED);
        scoreLabel.setBackground(Color.BLACK);
        scoreLabel.setOpaque(true);

        timerLabel = new JLabel("Timer: 00.00");
        timerLabel.setBounds(630, 10, 50, 10);
        timerLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 8));
        timerLabel.setForeground(Color.ORANGE);
        timerLabel.setBackground(Color.BLACK);
        timerLabel.setOpaque(true);

        highScoreLabel = new JLabel("High Score: " + getHighestScore() );
        highScoreLabel.setBounds(630, 20, 70, 10);
        highScoreLabel.setFont(new java.awt.Font("Arial", Font.BOLD, 8));
        highScoreLabel.setForeground(Color.YELLOW);
        highScoreLabel.setBackground(Color.BLACK);
        highScoreLabel.setOpaque(true);



        ballLabel = new JLabel();
        ballLabel.setBounds(325, 410, 100, 70);
        ballLabel.setOpaque(false);

        int netX = (int) (Math.random() * 475);
        netLabel = new JLabel();
        netLabel.setBounds(netX, 70, 200, 120);
        netLabel.setOpaque(false);

        ImageIcon ball = new ImageIcon("src/Ball.png");
        Image image = ball.getImage(); // transform it
        Image newimg = image.getScaledInstance(100, 70, java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        ball = new ImageIcon(newimg);  // transform it back
        ballLabel.setIcon(ball);


        ImageIcon net = new ImageIcon("src/Net.png");
        Image image2 = net.getImage();
        Image newimg2 = image2.getScaledInstance(200, 120, java.awt.Image.SCALE_SMOOTH);
        net = new ImageIcon(newimg2);
        netLabel.setIcon(net);


        fieldLabel.add(ballLabel);
        fieldLabel.add(netLabel);
        fieldLabel.add(scoreLabel);
        fieldLabel.add(timerLabel);
        fieldLabel.add(highScoreLabel);

        ImageIcon field = new ImageIcon("src/Field.png");
        Image image3 = field.getImage();
        Image newimg3 = image3.getScaledInstance(700, 500, Image.SCALE_SMOOTH);
        field = new ImageIcon(newimg3);
        fieldLabel.setIcon(field);


        ballSpecs = new Ball(25, 400);
        netSpecs = new Net(10);

        player = new Player(0);


    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();

        if (code == KeyEvent.VK_A) {
            ballLabel.setLocation(ballLabel.getX() - ballSpecs.getNormalSpeed(), ballLabel.getY());
        }
        if (code == KeyEvent.VK_D) {
            ballLabel.setLocation(ballLabel.getX() + ballSpecs.getNormalSpeed(), ballLabel.getY());
        }

        if (code == 32) {
            ballMovement();
        }
        System.out.println(e.getKeyCode());


    }

    public void keyReleased(KeyEvent e) {

    }


    public void ballMovement() {
        for (int i = 0; i < 300; i++) {
            ballLabel.setLocation(ballLabel.getX(), ballLabel.getY() - 1);
        }
        goalChecker();
        System.out.println("ball is kicked");
    }


    public void goalChecker() {
        int ballXMin = ballLabel.getX();
        int ballXMax = ballLabel.getX() + 100;
        int ballYMin = ballLabel.getY();
        int ballYMax = ballLabel.getY() + 70;


        int netMinX = netLabel.getX();
        int netMaxX = netLabel.getX() + 200;
        int goalLine = netLabel.getY() + 120;

        if (ballXMin >= netMinX) {
            if (ballXMax <= netMaxX) {
                if (ballYMin <= goalLine && ballYMax <= goalLine) {
                    player.addScore(1);
                }
            }
        }
        System.out.println("Score: " + player.getScore());
        scoreLabel.setText("Score: " + player.getScore());
        Timer resetPositions = new Timer();

        TimerTask taskPositions = new TimerTask() {
            @Override
            public void run() {
                resetPositions();
            }
        };

        resetPositions.schedule(taskPositions, 1000);

    }

    public void resetPositions() {
        ballLabel.setLocation(325, 410);
        int netX = (int) (Math.random() * 475);
        ballLabel.setLocation(netX, 70);
    }



}
