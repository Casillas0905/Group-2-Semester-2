package Shared.Util;

import java.beans.PropertyChangeListener;

public interface PropertyChangeSubject
{
  void addListener(PropertyChangeListener listener);
  void addListener(PropertyChangeListener listener, String eventName);
  void removeListener(PropertyChangeListener listener, String eventName);
  void removeListener(PropertyChangeListener listener);
}
