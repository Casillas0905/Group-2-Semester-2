package Client.Network;

import Shared.Network.ClientCallBack;
import Shared.Network.RMIServer;
import Shared.TransferObjects.Item;
import Shared.TransferObjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class RMIClient implements Client, ClientCallBack, Serializable
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient()
  {
    support = new PropertyChangeSupport(this);

    try
    {
      UnicastRemoteObject.exportObject(this, 0);
      startClient();
      server.registerClient(this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public Item uploadItem(Item item) throws SQLException
  {
    Item item1 = null;
    try
    {
      item1 = server.uploadItem(item);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return item1;
  }

  @Override public User Register(User user) throws SQLException
  {
    User user1= null;
    System.out.println("RMIClient");

    try
    {
      user1=server.registerUser(user);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }

    return user1;
  }

  @Override public String setUser(String user)
  {
    try
    {
      return server.setUser(user);
    }
    catch (RemoteException e)
    {
      throw new RuntimeException("Could not contact the server...");
    }
  }

  @Override public void startClient()
  {
    Registry registry = null;

    try
    {
      registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("ThriftShopServer");
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    catch (NotBoundException e)
    {
      e.printStackTrace();
    }
  }



  @Override public void update(Item item) throws RemoteException
  {
    support.firePropertyChange("itemPosted", null, item);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addListener(PropertyChangeListener listener,
      String eventName)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(PropertyChangeListener listener,
      String eventName)
  {
    support.removePropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
