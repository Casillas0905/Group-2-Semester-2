package Client.Network;

import Shared.TransferObjects.Item;
import Shared.Util.PropertyChangeSubject;

public interface Client extends PropertyChangeSubject
{
  Item uploadItem(Item item);
  String setUser(String user);
  void startClient();
}
