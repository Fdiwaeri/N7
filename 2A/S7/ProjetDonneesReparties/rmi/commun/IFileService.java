package rmi.commun;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

// Interface pour le service Fichier (Scénario 2)
public interface IFileService extends Remote {
    String getFichierConfidenciel() throws RemoteException;
}
