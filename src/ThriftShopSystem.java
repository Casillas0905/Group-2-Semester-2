import Core.ModelFactory;
import Core.ViewHandler;
import Core.ViewModelFactory;
import javafx.application.Application;
import javafx.stage.Stage;

public class ThriftShopSystem extends Application
{

  @Override public void start(Stage stage) throws Exception
  {
    ModelFactory modelFactory = new ModelFactory();
    ViewModelFactory viewModelFactory = new ViewModelFactory(modelFactory);
    ViewHandler viewHandler = new ViewHandler(viewModelFactory);
    viewHandler.start();
  }
}
