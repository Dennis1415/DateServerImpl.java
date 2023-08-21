package javaExercise4;

import java.util.Scanner;

public class inputReader {

    public static void main(String[] args) {
        System.out.println("InputReader");
        Scanner sc = new Scanner(System.in);
        int i=1;
        while (true){
            String line = sc.nextLine();
            myThread mT1 = new myThread(i);
            mT1.start();
            i++;

        }
    }
}
