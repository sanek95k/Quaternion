package Quaternion;

/**
 * Created by Александр on 13.03.14.
 */
public class QuaternionOperations {

    public static Quaternion multiply (Quaternion first, Quaternion second){

        double tempW = (first.getW() * second.getW()) - (first.getX()  * second.getX())
                - (first.getY() * second.getY()) - (first.getZ() * second.getZ());

        double tempX = (first.getX() * second.getW()) + (first.getW() * second.getX())
                + (first.getY() * second.getZ()) - (first.getZ() * second.getY());

        double tempY = (first.getY() * second.getW()) + (first.getW() * second.getY())
                + (first.getZ() * second.getX()) - (first.getX()  * second.getZ());

        double tempZ = (first.getZ() * second.getW()) + (first.getW() * second.getZ())
                + (first.getX()  * second.getY()) - (first.getY() * second.getX());
        
        return new Quaternion (tempW, tempX, tempY, tempZ);
    }

    public static Quaternion add (Quaternion first, Quaternion second){
        return new Quaternion (first.getW() + second.getW(),
                first.getX() + second.getX(),
                first.getY() + second.getY(),
                first.getZ() + second.getZ());
    }

    public static Quaternion subtract (Quaternion first, Quaternion second){
        return new Quaternion (first.getW() - second.getW(),
                first.getX() - second.getX(),
                first.getY() - second.getY(),
                first.getZ() - second.getZ());
    }
}