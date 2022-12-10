import Client.Core.ClientFactory;
import Client.Core.ModelFactory;
import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ThriftShopSystem extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory clientFactory = new ClientFactory();
    ModelFactory modelFactory = new ModelFactory(clientFactory);
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
