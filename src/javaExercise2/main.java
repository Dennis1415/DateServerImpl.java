package javaExercise2;

import java.io.*;

public class main {

    //Calls print() Method of each Object in list[]
    private static void printList(Display list[]) {
        System.out.println("__________List____________ ");
        for (int i = 0; i < list.length; i++) {
            System.out.println("i: " + i);
            list[i].print();
            System.out.println("\n");
        }

    }

    public static void main(String[] args) {

        /*
        Publication[] allP = new Publication[3];
        allP[0] = new Publication("Hund", "DE",456.444);
        allP[1] = new Publication("Kadse", "EN",1336.433);
        allP[2] = new Book("Dennis", "DE34334-324234-234", "Biografiee", "DE", 0.4);

        for(int i=0; i< allP.length;i++){
            allP[i].print();
        }
*/


        //Creates Display Array list[] containing Car, Book & Publication Objects
        Display list[] = {
                new Car("Gelb", 222, 5),
                new Book("Dennis", "DE123213123", "Wer Gänsehaut schlägt auch Hühner", "De", 420.69),
                new Publication("Titel", "Detusch", 0.4)
        };

        printList(list);

        //________ Serialization & Deserialization ________
        String fileLocation = "src\\javaExercise2\\list.ser";


        //Serialization
        try {
            FileOutputStream fileOut = new FileOutputStream(fileLocation);
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(list);
            out.close();
            fileOut.close();    //auch schließen, oder ?
            System.out.println("Object serialized to " + fileLocation);
        } catch (IOException e) {
            e.printStackTrace();
        }


        //Deserialization
        Display list02[] = new Display[3];
        try {
            FileInputStream fileIn = new FileInputStream(fileLocation);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            list02 = (Display[]) in.readObject();
            in.close();
            fileIn.close();
            System.out.println("Object deserialized from " + fileLocation);
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
        }

        printList(list02);

    }

}
