package Ejercicios.e2;
public class Ejercicio2 {
    public static void main(String[] args) {
        System.out.println("Enter main()");
        try {
            methodA();
        } catch (ArithmeticException e) {
            System.out.println("Exception caught in main(): " + e);
        }
        System.out.println("Exit main()");
    }

    public static void methodA() {
        System.out.println("Enter methodA()");
        methodB();
        System.out.println("Exit methodA()");
    }

    public static void methodB() {
        System.out.println("Enter methodB()");
        methodC();
        System.out.println("Exit methodB()");
    }

    public static void methodC() {
        System.out.println("Enter methodC()");
        System.out.println(1 / 0); // divide-by-0 triggers an ArithmeticException
        System.out.println("Exit methodC()");
    }
}