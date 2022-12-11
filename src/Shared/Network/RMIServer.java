package Shared.Network;

import Shared.TransferObjects.Item;
import Shared.TransferObjects.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface RMIServer extends Remote
{
  Item uploadItem(Item item) throws RemoteException;
  User registerUser(User user) throws SQLException, RemoteException;
  String setUser(String user) throws RemoteException;
  void registerClient(ClientCallBack client) throws RemoteException;
}