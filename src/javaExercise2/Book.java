package javaExercise2;

public class Book extends Publication{
    private String author;
    private String ISBN;

    Book(String author, String ISBN, String title, String language, double price){
            super(title, language, price);
            this.author=author;
            this.ISBN=ISBN;
        }
        public void print(){
            System.out.println(author);
            System.out.println(ISBN);
            super.print();
    }
}
