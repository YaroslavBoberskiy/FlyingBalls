import javax.swing.*;
import java.awt.*;
import java.util.*;

public class BallField extends JComponent {

    private static final int FIELD_W = 400;
    private static final int FIELD_H = 400;

    private Ball redBall;
    private Ball blueBall;
    private Ball greenBall;
    private Ball yellowBall;
    private Ball redBall2;
    private Ball blueBall2;
    private Ball greenBall2;
    private Ball yellowBall2;

    private ArrayList<Ball> balls = new ArrayList<Ball>();


    BallField() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(FIELD_W, FIELD_H));
        frame.setLayout(new BorderLayout());
        frame.add(this);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        redBall = new Ball(Color.red, 0, 0, 20, 5, "RIGHT");
        blueBall = new Ball(Color.blue, 0, 40, 20, 10, "RIGHT");
        greenBall = new Ball(Color.green, 0, 80, 20, 20, "RIGHT");
        yellowBall = new Ball(Color.yellow, 0, 120, 20, 30, "RIGHT");
        redBall2 = new Ball(Color.red, 0, 160, 20, 5, "RIGHT");
        blueBall2 = new Ball(Color.blue, 0, 200, 20, 10, "RIGHT");
        greenBall2 = new Ball(Color.green, 0, 240, 20, 20, "RIGHT");
        yellowBall2 = new Ball(Color.yellow, 0, 280, 20, 30, "RIGHT");

        balls.add(redBall);
        balls.add(blueBall);
        balls.add(greenBall);
        balls.add(yellowBall);
        balls.add(redBall2);
        balls.add(blueBall2);
        balls.add(greenBall2);
        balls.add(yellowBall2);

        startMoving();
    }

    private void startMoving() {
        Thread t1 = new Thread(redBall);
        Thread t2 = new Thread(blueBall);
        Thread t3 = new Thread(greenBall);
        Thread t4 = new Thread(yellowBall);
        Thread t5 = new Thread(redBall2);
        Thread t6 = new Thread(blueBall2);
        Thread t7 = new Thread(greenBall2);
        Thread t8 = new Thread(yellowBall2);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();
        t8.start();

        while (true) {
            repaint();
            try {
                Thread.sleep(15);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        for (Ball b : balls) {
            b.draw(g2);
        }
    }

}
