package Shared.Network;

import Shared.TransferObjects.Item;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIServer extends Remote
{
  Item uploadItem(Item item) throws RemoteException;
  String setUser(String user) throws RemoteException;
  void registerClient(ClientCallBack client) throws RemoteException;
}
