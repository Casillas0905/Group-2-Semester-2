package Server;

import Server.Model.ManagerImpl;
import Server.Network.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer
{
  public static void main(String[] args) throws RemoteException,
      AlreadyBoundException
  {
    RMIServerImpl rmiServer = new RMIServerImpl(new ManagerImpl());
    rmiServer.startServer();
  }
}
