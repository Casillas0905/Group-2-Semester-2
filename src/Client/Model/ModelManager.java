package Client.Model;


import Database.Database;
import Database.DatabaseMethods;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Client.Network.Client;
import Shared.TransferObjects.Item;
import java.beans.PropertyChangeEvent;
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
  private String user;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Database database= new DatabaseMethods();
  private Client client;
  public ModelManager(Client client)
  {
    this.client = client;
    client.startClient();
    client.addListener(this::onNewItemPosted, "itemPosted");
  }

  private void onNewItemPosted(PropertyChangeEvent event)
  {
    support.firePropertyChange(event);
  }

  @Override public void uploadItem(String picture, String price, String title, String desc,
      String subCategory)
  {
    client.uploadItem(new Item(picture, user, price, title, desc, subCategory));
  }

  @Override public void setUser(String user)
  {
    this.user = user;
    client.setUser(user);
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
