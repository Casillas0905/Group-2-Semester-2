package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ModelManager implements Model
{
  private List<Item> items;
  private PropertyChangeSupport support = new PropertyChangeSupport(this);

  @Override public void uploadItem(User user, int price, String title, String desc,
      String subCategory)
  {
    Item uploadedItem = new Item(user, price, title, desc, subCategory);
    items.add(uploadedItem);
    support.firePropertyChange("itemUploaded", null, uploadedItem);
  }

  @Override public void addListener(PropertyChangeListener listener)
  {

  }

  @Override public void addListener(PropertyChangeListener listener,
      String eventName)
  {

  }

  @Override public void removeListener(PropertyChangeListener listener,
      String eventName)
  {

  }

  @Override public void removeListener(PropertyChangeListener listener)
  {

  }

}
