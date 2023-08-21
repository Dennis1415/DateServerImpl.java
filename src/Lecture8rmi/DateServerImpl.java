
package Lecture8rmi;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.*;
import java.util.Date;

public class DateServerImpl extends UnicastRemoteObject implements DateServer {
  public DateServerImpl () throws RemoteException {
  }

  public Date getDate () throws RemoteException {
    System.out.println("Invocation of getDate()");
    return new Date ();
  }

  public static void main (String[] args) {

    try {
      Registry registry = LocateRegistry.createRegistry(Registry.REGISTRY_PORT);
      //DateServer dateServer = new DateServerImpl ();

      DateServerImpl dateServer = new DateServerImpl ();
      Naming.rebind ("DateServer", dateServer);
      System.out.println("The server is up");
      
    } catch (Exception e) {
		System.out.println("DateServerImpl: " + e.getMessage());
		e.printStackTrace();
	}
  }
}
