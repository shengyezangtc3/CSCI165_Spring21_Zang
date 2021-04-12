/**
 * Author: Shengye Zang
 * Date: April 9 2021
 * Assignment: Week 10 Lab
 */

public class Point3D extends Point {
    int z;

    // constructors
    public Point3D() {}

    public Point3D(int x, int y, int z) {
        super(x, y);
        this.z = z;
    }

    public Point3D(Point3D other) {
        super(other.getX(), other.getY());
        z = other.z;
    }

    // getters and setters
    public void setZ(int z) {
        this.z = z;
    }

    public int getZ() {
        return z;
    }

    public void setXYZ(int x, int y, int z) {
        super.setXY(x, y);
        setZ(z);
    }

    public void setXYZ(Point xy, int z) {
        super.setXY(xy.getX(), xy.getY());
        setZ(z);
    }

    public int[] getXYZ() {
        int[] coords = {super.getX(), super.getY(), z};
        return coords;
    }

    // other behaviors
    @Override
    public String toString() {
        return "(" + super.getX() + ", " + super.getY() + ", " + z + ")";
    }

    @Override
    public boolean equals(Object other) {
        if (other instanceof Point3D) {
            Point3D otherPoint = (Point3D) other;
            return super.equals(other) && z == otherPoint.z;
        }
        return false;
    }

}
