package Core;

import Model.Model;
import Model.ModelManager;

public class ModelFactory
{
  private Model model;

  public Model getModel()
  {
    if(model==null)
    {
      model = new ModelManager();
    }
    return model;
  }
}
