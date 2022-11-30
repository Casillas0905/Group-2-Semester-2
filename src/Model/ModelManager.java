package Model;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.awt.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.File;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ModelManager implements Model
{
  private List<Item> items = new ArrayList<>();
  private String user;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

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
