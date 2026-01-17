package rmi.commun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Interface pour le service Téléphones
public interface IPhoneService extends Remote {
    String getPhone(String hotelName) throws RemoteException;
}
