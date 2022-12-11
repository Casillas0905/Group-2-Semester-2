package Client.View.Login;

import Client.Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ObservableValue;

import java.sql.SQLException;

public class LoginViewModel
{
  private Model model;
  private StringProperty username;
  private StringProperty password;
  private StringProperty error;

  public LoginViewModel(Model model)
  {
    this.model = model;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
    error= new SimpleStringProperty();
  }

  public void setUsername()
  {
    String input = username.get();
    {
      if(input != null && !"".equals(input))
      {
        model.setUser(input);
      }
    }
  }

  public StringProperty usernameProperty()
  {
    return username;
  }

  public StringProperty passwordProperty()
  {
    return password;
  }

  public StringProperty errorProperty()
  {
    return error;
  }

  public void showError(){
    error.set("Username/password incorrect or empty");
  }

  public boolean logIn() throws SQLException
  {
    String usernameInp= username.get();
    String passwordInp= password.get();
   return model.LogIn(usernameInp,passwordInp);
  }


}
