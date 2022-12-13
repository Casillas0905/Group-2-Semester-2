package Client.View.Register;

import Client.Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.sql.SQLException;

public class RegisterViewModel
{

  private Model model;
  private StringProperty firstName,LastName, Username, password, mail,birth,error;


  public RegisterViewModel(Model model)
  {
    this.model= model;
    firstName= new SimpleStringProperty();
    LastName= new SimpleStringProperty();
    Username= new SimpleStringProperty();
    password= new SimpleStringProperty();
    mail= new SimpleStringProperty();
    birth= new SimpleStringProperty();
    error= new SimpleStringProperty();
  }

  public StringProperty firstNameProperty()
  {
    return firstName;
  }

  public StringProperty lastNameProperty()
  {
    return LastName;
  }

  public StringProperty usernameProperty()
  {
    return Username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty mailProperty()
  {
    return mail;
  }

  public StringProperty birthProperty()
  {
    return birth;
  }

  public void registerUser() throws SQLException
  {
    String fistNameInp= firstName.get();
    String lastNameInp= LastName.get();
    String usernameInp= Username.get();
    String passwordInP= password.get();
    String mailInp= mail.get();
    String birthInp= birth.get();
    model.registerUser(fistNameInp,lastNameInp,usernameInp,passwordInP,mailInp,birthInp);
  }

  public boolean isUserOrEmailFree(String email,String username)
      throws SQLException
  {
    return model.isUserOrEmailFree(email, username);
  }

  public void clear()
  {
    firstName.setValue("");
    LastName.setValue("");
    Username.setValue("");
    password.setValue("");
    mail.setValue("");
    birth.set("");
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public void showError(){
    error.set("Try another username or email");
  }
}
