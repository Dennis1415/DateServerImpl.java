package javaExercise4;

public class myThread extends Thread{
    private int number;

    myThread(int n){
        this.number=n;
    }

    public void run (){

        for(int i=0 ; i<5; i++){
            System.out.println(number);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
