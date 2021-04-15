/**
 * Author: Shengye Zang
 * Date: April 9 2021
 * Assignment: Week 10 Lab
 */

public class Point {
    private int x, y; // protected?

    // constructors
    public Point() {}

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(Point other) {
        this.x = other.x;
        this.y = other.y;
    }

    // getters and setters
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int[] getXY() {
        int[] coords = {x, y};
        return coords;
    }

    public void setXY(int x, int y) {
        setX(x);
        setY(y);
    }

    // other behaviors
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)    return true;
        if (other == null)    return false;
        if (getClass() != other.getClass())   return false;

        Point point = (Point) other;
        return x == point.x && y == point.y;
    }

    public double distance(int x, int y) {
        return Math.sqrt(Math.pow(this.x - x, 2) + Math.pow(this.y - y, 2));
    }

    public double distance(Point other) {
        return distance(other.getX(), other.getY());
    }

    public double distance() {
        return distance(0, 0);
    }

    public static double distance(Point one, Point two) {
        return Math.sqrt(Math.pow(one.x - two.x, 2) + Math.pow(one.y - two.y, 2));
    }
}