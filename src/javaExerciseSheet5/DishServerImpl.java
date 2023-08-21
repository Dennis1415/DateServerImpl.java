package javaExerciseSheet5;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class DishServerImpl extends UnicastRemoteObject implements DishServer{
    private String name;
    private int nutritionalValue;
    private double price;

    public DishServerImpl() throws RemoteException{

    }
    public String getName() throws RemoteException {
        return name;
    }
    public int getNutritionalValue()throws RemoteException {
        return nutritionalValue;
    }
    public double getPrice()throws RemoteException {
        return price;
    }
    //Setter
    public void setPrice(double price)throws RemoteException {
        this.price=price;
    }

}
