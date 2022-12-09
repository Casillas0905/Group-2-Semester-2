package Server.Model;

import Shared.TransferObjects.Item;
import Shared.Util.PropertyChangeSubject;

public interface Manager extends PropertyChangeSubject
{
  Item uploadItem(Item item);
  void setUser(String user);
}
