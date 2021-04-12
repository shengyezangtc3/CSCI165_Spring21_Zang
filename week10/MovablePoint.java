/**
 * Author: Shengye Zang
 * Date: April 9 2021
 * Assignment: Week 10 Lab
 */

public class MovablePoint extends Point {
    float xSpeed, ySpeed;

    // constructors
    public MovablePoint() {}

    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(int x, int y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(Point xy, float xSpeed, float ySpeed) {
        super(xy); 
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public MovablePoint(MovablePoint other) {
        super(other.getX(), other.getY());
        xSpeed = other.xSpeed;
        ySpeed = other.ySpeed;
    }

    // getters and setters
    public float getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getySpeed() {
        return ySpeed;
    }

    public void setySpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    
    public void setSpeeds(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float[] getSpeeds() {
        float[] speeds = {xSpeed, ySpeed};
        return speeds;
    }

    // other behaviors
    public MovablePoint move() {
        return new MovablePoint(super.getX(), super.getY(), xSpeed+1, ySpeed+1);
    }

    @Override
    public String toString() {
        return super.toString() + ": speed = (" + xSpeed + ", " + ySpeed + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof MovablePoint) {
            MovablePoint point = (MovablePoint) other;
            return super.equals(other) && xSpeed == point.xSpeed && ySpeed == point.ySpeed;
        }
        return false;
    }
}
