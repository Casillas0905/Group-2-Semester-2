package Client.Core;

import Client.Network.Client;
import Client.Network.RMIClient;

public class ClientFactory
{
  private Client client;

  public Client getClient()
  {
    if(client == null)
    {
      client = new RMIClient();
    }
    return client;
  }
}
