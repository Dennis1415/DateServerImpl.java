package javaExercise3;
import java.net.StandardSocketOptions;
import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Iterator;

public class displayStrings {
    public static void main(String[] args) {

        HashSet<String> hashSet = new HashSet<String>();
        hashSet.add("Test");
        hashSet.add("Hund");
        hashSet.add("Drei");

      Iterator <String> it = hashSet.iterator();

      while(it.hasNext()){
          System.out.println(it.next());
      }

    }

}
