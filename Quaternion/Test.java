package Quaternion;

/**
 * Created by Александр on 13.03.14.
 */
public class Test {
    public  static void main(String [] args){

        Quaternion x = new Quaternion(1.0, 2.0, 3.0, 4.0);
        Quaternion y = new Quaternion(1.0, 2.0, 3.0, 4.0);

        System.out.println("Conjugate for x: " + x.getConjugate());

        System.out.println("Multiplication: " + QuaternionOperations.multiply(x, y));
        System.out.println("Addition: " + QuaternionOperations.add(x, y));
        System.out.println("Subtraction: " + QuaternionOperations.subtract(x, y));

        System.out.println(y.isNormalized());
        y.normalize();
        System.out.println(y.isNormalized());
        System.out.println(y.getLength());

        System.out.println("Normalized y: " + y);

        Quaternion z = new Quaternion();
        try{
        z.normalize();
        }catch(IllegalStateException exception){
            System.out.println("The exception has been caught");
        }
    }
}
