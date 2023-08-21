package javaExercise4;

public class main {


    public static void main(String[] args) {
        System.out.println("Main Anfang! ");

        myThread t1 = new myThread(1);
        myThread t2 = new myThread(2);
        myThread t3 = new myThread(3);
        t1.start();
        t2.start();
        t3.start();
        System.out.println("Main Ende! ");
    }

}
