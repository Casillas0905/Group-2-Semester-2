package Client.View.Login;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController
{
  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;

  @FXML
  private TextField username;
  @FXML
  private PasswordField password;

  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    loginViewModel = viewModelFactory.getLoginViewModel();
    username.textProperty().bindBidirectional(loginViewModel.usernameProperty());
    password.textProperty().bindBidirectional(loginViewModel.passwordProperty());
  }

  @FXML
  public void onNext(ActionEvent actionEvent)
  {
    loginViewModel.setUsername();
    viewHandler.openPrincipalPageView();

  }

  @FXML
  public void onReset(ActionEvent actionEvent)
  {
    System.out.println("reset button pressed");
  }

  public void register(ActionEvent actionEvent)
  {
    viewHandler.openRegisterView();
  }
}
