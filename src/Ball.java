import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class Ball implements Runnable {

    private Color color;
    private double x;
    private double y;
    private double size;
    private int speed;
    private String direction;

    Ball (Color color, int xCoordinate, int yCoordinate, int size, int speed, String direction) {
        this.color = color;
        this.x = xCoordinate;
        this.y = yCoordinate;
        this.size = size;
        this.speed = speed;
        this.direction = direction;
    }

    public void move () throws InterruptedException {
        while (true) {
            if (getX() > 360) {
                setDirection("LEFT");
            }
            if (getX() < 0) {
                setDirection("RIGHT");
            }

            if (direction == "LEFT") {
                x--;
            }
            if (direction == "RIGHT") {
                x++;
            }
            if (direction == "UP") {
                y--;
            }
            if (direction == "DOWN") {
                y++;
            }
            Thread.sleep(speed);
        }
    }

    public void draw(Graphics2D g2){
        Ellipse2D ball = new Ellipse2D.Double(getX(), getY(), size, size);
        g2.setPaint(color);
        g2.fill(ball);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public void run() {
        try {
            this.move();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
