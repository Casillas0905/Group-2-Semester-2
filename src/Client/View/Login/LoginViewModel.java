package Client.View.Login;

import Client.Model.Model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class LoginViewModel
{
  private Model model;
  private StringProperty username;
  private StringProperty password;

  public LoginViewModel(Model model)
  {
    this.model = model;
    username = new SimpleStringProperty();
    password = new SimpleStringProperty();
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
}
