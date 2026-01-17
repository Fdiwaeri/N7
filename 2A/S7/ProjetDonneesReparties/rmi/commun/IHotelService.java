package rmi.commun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Interface pour le service Hotels
public interface IHotelService extends Remote {
    List<String> getHotels() throws RemoteException;
}
