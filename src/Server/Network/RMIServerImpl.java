package Server.Network;

import Server.Model.Manager;
import Shared.Network.ClientCallBack;
import Shared.Network.RMIServer;
import Shared.TransferObjects.Item;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class RMIServerImpl implements RMIServer
{
  private Manager manager;

  public RMIServerImpl(Manager manager) throws RemoteException
  {
    this.manager = manager;
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public Item uploadItem(Item item) throws RemoteException
  {
    return manager.uploadItem(item);
  }

  public void startServer() throws RemoteException, AlreadyBoundException
  {
    System.out.println("Server started...");
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("ThriftShopServer", this);
  }

  @Override public String setUser(String user) throws RemoteException
  {
    manager.setUser(user);
    return user;
  }

  @Override public void registerClient(ClientCallBack client)
      throws RemoteException
  {
    manager.addListener(evt -> {
      try
      {
        client.update((Item) evt.getNewValue());
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }, "itemPosted");

    System.out.println("Client entered");
  }
}
