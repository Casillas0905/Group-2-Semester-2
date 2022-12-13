package Client.Core;


import Client.View.Login.LoginController;
import Client.View.PostItems.PostItemController;
import Client.View.PrincipalPage.PrincipalPageController;
import Client.View.Register.RegisterController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class ViewHandler
{
  private ViewModelFactory viewModelFactory;

  private Scene logInScene, mainPageScene, postItemScene,registerScene;
  private Stage stage;

  public ViewHandler(ViewModelFactory viewModelFactory)
  {
    this.viewModelFactory = viewModelFactory;
  }

  public void start()
  {
    stage = new Stage();
    openLogInView();
  }

  public void openLogInView()
  {
    {
      try
      {
        Parent root = loadFXMLlogIn("../View/Login/login.fxml");
        stage.setTitle("Log in");
        logInScene = new Scene(root);
      }
      catch (IOException e)
      {
        e.printStackTrace();
      }
      stage.setScene(logInScene);
      stage.show();
    }
  }

  private Parent loadFXMLlogIn(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    LoginController controller = loader.getController();
    controller.init(this, viewModelFactory);
    return root;
  }

  private Parent loadFXMLPrincipalPage(String path)
      throws IOException, SQLException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    PrincipalPageController controller = loader.getController();
    controller.init(this, viewModelFactory);
    return root;
  }

  private Parent loadFXMLPostItem(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    PostItemController controller = loader.getController();
    controller.init(this, viewModelFactory);
    return root;
  }
  private Parent loadFXMLRegister(String path) throws IOException
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = loader.load();

    RegisterController controller = loader.getController();
    controller.init(this, viewModelFactory);
    return root;
  }

  public void openPostItemView()
  {
    try
    {
      Parent root = loadFXMLPostItem("../View/PostItems/PostItem.fxml");

      stage.setTitle("Post Item");
      postItemScene = new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    stage.setScene(postItemScene);
    stage.show();
  }

  public void openPrincipalPageView()
  {
    try
      {
        Parent root = loadFXMLPrincipalPage(
            "../View/PrincipalPage/Principal page.fxml");

        stage.setTitle("Principal Page");
        mainPageScene = new Scene(root);
      }
      catch (IOException | SQLException e)
      {
        e.printStackTrace();
      }
      stage.setScene(mainPageScene);
      stage.show();
    }

  public void openRegisterView()
  {
    try
    {
      Parent root = loadFXMLRegister(
          "../View/Register/Register.fxml");

      stage.setTitle("Register");
      registerScene = new Scene(root);
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    stage.setScene(registerScene);
    stage.show();
  }


}
