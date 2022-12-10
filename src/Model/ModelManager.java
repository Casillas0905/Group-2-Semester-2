package Model;

import Database.Database;
import Database.DatabaseMethods;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModelManager implements Model
{
  private List<Item> items = new ArrayList<>();
  private String user;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Database database= new DatabaseMethods();

  public ModelManager()
  {}

  @Override public Item uploadItem(String price, String title, String desc,
      String subCategory)
  {
    /*Image image = new Image(pictureReference);
    ImageView picture = new ImageView(image);*/
    Item item = new Item(user, price, title, desc, subCategory);
    items.add(item);
    support.firePropertyChange("itemPosted", null, item);
    return item;
  }

  @Override public void setUser(String user)
  {
    this.user = user;
  }

  @Override public void registerUser(String email,String password,String username,String fname,String lname,String birth)
      throws SQLException
  {
    for (int i=0;i<database.getEmailsRegistered().size();i++){
      if(!(email.equalsIgnoreCase(database.getEmailsRegistered().get(i)))){
        for (int j=0;j<database.getUsersRegistered().size();j++){
          if(!(username.equalsIgnoreCase(database.getUsersRegistered().get(i)))){
            System.out.println("user registered");
            database.registerUserr(email, password, username, fname, lname, birth);
        }
        }
      }
    }
  }

  @Override public void addListener(PropertyChangeListener listener)
  {
    support.addPropertyChangeListener(listener);
  }

  @Override public void addListener(PropertyChangeListener listener,
      String eventName)
  {
    support.addPropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(PropertyChangeListener listener,
      String eventName)
  {
    support.removePropertyChangeListener(eventName,listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }

}
