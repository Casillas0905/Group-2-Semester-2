package Shared.Network;

import Shared.TransferObjects.Item;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallBack extends Remote
{
  void update(Item item) throws RemoteException;
}
