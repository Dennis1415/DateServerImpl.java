package javaExerciseSheet5;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DishServer extends Remote {

    public String getName()throws RemoteException;
    public int getNutritionalValue()throws RemoteException;
    public double getPrice()throws RemoteException;
    public void setPrice(double price)throws RemoteException;



}
