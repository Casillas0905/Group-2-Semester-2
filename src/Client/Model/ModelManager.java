package Client.Model;

import Client.Network.Client;
import Shared.TransferObjects.Item;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private String user;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);
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
