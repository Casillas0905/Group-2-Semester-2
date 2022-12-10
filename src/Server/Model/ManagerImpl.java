package Server.Model;

import Database.Database;
import Database.DatabaseMethods;
import Shared.TransferObjects.Item;
import Shared.TransferObjects.User;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ManagerImpl implements Manager
{

  private String user;
  private List<Item> itemList = new ArrayList<>();
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
  private Database database= new DatabaseMethods();

  public ManagerImpl(){}

  @Override public Item uploadItem(Item item)
  {
    itemList.add(item);
    support.firePropertyChange("itemPosted", null, item);
    return item;
  }

  @Override public User register(User user) throws SQLException
  {
    System.out.println("register method enter");
    if (!(database.getEmailsRegistered().contains(user.getEmail().toLowerCase())))
    {
      if (!(database.getUsersRegistered().contains(user.getUsername().toLowerCase())))
      {
        database.registerUserr(user.getEmail().toLowerCase(), user.getPassword(), user.getUsername().toLowerCase(), user.getFname(), user.getLname(), user.getBirth());
        System.out.println("user registered");
      }
    }
    return user;
  }

  @Override public void setUser(String user)
  {
    this.user = user;
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
    support.removePropertyChangeListener(eventName, listener);
  }

  @Override public void removeListener(PropertyChangeListener listener)
  {
    support.removePropertyChangeListener(listener);
  }
}
