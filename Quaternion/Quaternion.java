package Quaternion;

/**
 * Created by Александр on 13.03.14.
 */

import java.lang.Math;

public class Quaternion {
    private double w, x, y, z;

    public Quaternion() {
        w = 0.0;
        x = 0.0;
        y = 0.0;
        z = 0.0;
    }

    public Quaternion(double tempW, double tempX, double tempY, double tempZ){
        w = tempW;
        x = tempX;
        y = tempY;
        z = tempZ;
    }

    public void setW(double w) {
        this.w = w;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public double getW() {
        return w;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Quaternion that = (Quaternion) o;

        if (Double.compare(that.w, w) != 0) return false;
        if (Double.compare(that.x, x) != 0) return false;
        if (Double.compare(that.y, y) != 0) return false;
        if (Double.compare(that.z, z) != 0) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(w);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return w + " + " + x + "*i" + " + " + y + "*j" + " + " + z + "*k";
    }

    @Override
    public Quaternion clone(){
        return new Quaternion(this.w, this.x, this.y, this.z);
    }

    public Quaternion getConjugate (){
        return new Quaternion (w, -x, -y, -z);
    }

    public double getLength(){
        return Math.sqrt(w * w + x * x + y * y + z * z);
    }

    public void normalize (){

        double length =  this.getLength();
        if (Math.abs(length) < 1e-8)
            throw new IllegalStateException("Cannot normalize due to null length");

        w /= length;
        x /= length;
        y /=length;
        z /= length;
    }

    public boolean isNormalized (){
        return Math.abs(1.0 - Math.abs(this.getLength())) < 1e-8;
    }
}
