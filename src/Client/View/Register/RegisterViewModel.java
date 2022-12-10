package Client.View.Register;

import Model.Model;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.DatePicker;
import javafx.util.converter.LocalDateStringConverter;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;

public class RegisterViewModel
{

  private Model model;
  private StringProperty firstName,LastName, Username, password, mail,birth;


  public RegisterViewModel(Model model)
  {
    this.model= model;
    firstName= new SimpleStringProperty();
    LastName= new SimpleStringProperty();
    Username= new SimpleStringProperty();
    password= new SimpleStringProperty();
    mail= new SimpleStringProperty();
    birth= new SimpleStringProperty();
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

  public void clear()
  {
    firstName.setValue("");
    LastName.setValue("");
    Username.setValue("");
    password.setValue("");
    mail.setValue("");
    birth.set("");
  }
}
