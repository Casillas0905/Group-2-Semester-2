package Model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class ModelManager implements Model
{
  private Item item;
  private PropertyChangeSupport support;

  @Override public void uploadItem(int price, String title, String desc,
      String subCategory)
  {

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
