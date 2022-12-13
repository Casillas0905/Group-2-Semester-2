package Client.View.Register;

import Client.Core.ViewHandler;
import Client.Core.ViewModelFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class RegisterController
{


  private ViewHandler viewHandler;
  private RegisterViewModel registerViewModel;

 @FXML
  public Label errorLabel;
  @FXML
  public TextField firstName;
  @FXML
  public TextField LastName;
  @FXML
  public TextField Username;
  @FXML
  public TextField password;
  @FXML
  public TextField mail;
  @FXML
  public TextField birthday;

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.viewHandler = viewHandler;
    this.registerViewModel = vmf.getRegisterViewModel();

    firstName.textProperty().bindBidirectional(registerViewModel.firstNameProperty());
    LastName.textProperty().bindBidirectional(registerViewModel.lastNameProperty());
    Username.textProperty().bindBidirectional(registerViewModel.usernameProperty());
    password.textProperty().bindBidirectional(registerViewModel.passwordProperty());
    mail.textProperty().bindBidirectional(registerViewModel.mailProperty());
    birthday.textProperty().bindBidirectional(registerViewModel.birthProperty());
    errorLabel.textProperty().bind(registerViewModel.errorProperty());
  }

  public void Register(ActionEvent actionEvent) throws SQLException
  {
    if((!registerViewModel.isUserOrEmailFree(mail.textProperty().get(),Username.textProperty().get()))){
      registerViewModel.showError();
    }
    else {registerViewModel.registerUser();
    registerViewModel.clear();
    viewHandler.openLogInView();}
  }

  public void BackToLogin(ActionEvent actionEvent)
  {
    viewHandler.openLogInView();
    System.out.println("back pressed");
  }
}
