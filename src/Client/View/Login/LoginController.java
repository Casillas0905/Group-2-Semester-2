package Client.View.Login;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class LoginController
{

  private ViewHandler viewHandler;
  private LoginViewModel loginViewModel;

  @FXML
  public Label errorLabel;
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

    errorLabel.textProperty().bind(loginViewModel.errorProperty());
  }

  @FXML
  public void onNext(ActionEvent actionEvent) throws SQLException
  {
    if(loginViewModel.logIn()){
      loginViewModel.setUsername();
      viewHandler.openPrincipalPageView();
    }else {
      loginViewModel.showError();
    }
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
