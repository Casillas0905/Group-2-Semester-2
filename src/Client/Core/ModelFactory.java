package Client.Core;

import Client.Model.Model;
import Client.Model.ModelManager;

public class ModelFactory
{
  private Model model;
  private ClientFactory clientFactory;

  public ModelFactory(ClientFactory clientFactory)
  {
    this.clientFactory = clientFactory;
  }

  public Model getModel()
  {
    if(model == null)
    {
      model = new ModelManager(clientFactory.getClient());
    }
    return model;
  }
}
