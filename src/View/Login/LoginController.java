package View.Login;

import Core.ViewHandler;
import Core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoginController
{
  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;

  @FXML
  private TextField username;
  @FXML
  private TextField password;

  public void init(ViewHandler viewHandler, ViewModelFactory viewModelFactory)
  {
    this.viewHandler = viewHandler;
    loginViewModel = viewModelFactory.getLoginViewModel();
    username.textProperty().bindBidirectional(loginViewModel.usernameProperty());
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
