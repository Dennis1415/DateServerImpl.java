package javaExerciseSheet5;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

/*
public class RestaurantServerImpl extends UnicastRemoteObject implements RestaurantServer {
    private String name;
    private ArrayList<Dish> servedDishes = new ArrayList<Dish>();

    public RestaurantServerImpl () throws RemoteException{
    }

    public Dish searchDish(String name)throws RemoteException {
        for (Dish dish : servedDishes) {
            if (dish.getName().equals(name)) return dish;
        }
        System.out.println("No dish with name " + name + " found!!");
        return null;
    }

    public void addDish(String name, int nutritionalV, double price)throws RemoteException {
        servedDishes.add(new Dish(name, nutritionalV, price));
    }

    public ArrayList<Dish> getDishes() throws RemoteException{
        return servedDishes;
    }

    public String getRestaurantName() throws RemoteException{
        return name;
    }


    public void initializeStandardDishes(){
        this.addDish("Pizza-Salami", 900,6.99);
        this.addDish("Nudeln", 450,7.99);
        this.addDish("Osaft", 200,2.99);
        this.addDish("Cola",350,3.99);
        this.addDish("Bier",350,4.99);
    }


    public static void main(String[] args) {

        try {
            RestaurantServerImpl restaurantServer = new RestaurantServerImpl();
            Naming.rebind("RestaurantServer",restaurantServer);
            System.out.println("Restaurant Server started");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}

*/