package Client.Model;


import Database.Database;
import Database.DatabaseMethods;
import Shared.TransferObjects.User;
import Client.Network.Client;
import Shared.TransferObjects.Item;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;

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
      String subCategory) throws SQLException
  {
    client.uploadItem(new Item(picture, user, price, title, desc, subCategory));
  }

  @Override public void setUser(String user)
  {
    this.user = user;
    client.setUser(user);
  }

  @Override public void registerUser(String fname,String lname,String username,String password,String email,String birth)
      throws SQLException
  {
    System.out.println("Model Manager");
    if(isUserOrEmailFree(email,username)){
      client.Register(new User(username, email, password, fname, lname, birth));
    }
  }

  public boolean isUserOrEmailFree(String email,String username) throws SQLException
  {
    if (!(database.getEmailsRegistered().contains(email.toLowerCase())) || !(database.getUsersRegistered().contains(username.toLowerCase())))
    {return true;}
      else return false;
  }

  @Override public boolean LogIn(String username, String password)
      throws SQLException
  {
    return database.LogIn(username, password);
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
