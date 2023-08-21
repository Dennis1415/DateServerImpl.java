package javaExercise1;

public class Factorial {

    private static int calculateFactorial(int f){
        int factorial = 1;
        while (f > 0){
            factorial = factorial *f;
            f--;
        }
        return factorial;
    }

    private static int printFactorials(int f){
        System.out.println("calculating factorial of "+f+"...");
        int fac = 1;
        int i=1;
        while(i <= f){
            fac = fac * i;
            System.out.println(i+"! = "+fac);
            i++;
        }
    return fac;
    }


    public static void main(String[] args) {
       System.out.println(calculateFactorial(4));
      printFactorials(10);

    }

}