package Client.Network;

import Shared.TransferObjects.Item;
import Shared.TransferObjects.User;
import Shared.Util.PropertyChangeSubject;

import java.sql.SQLException;

public interface Client extends PropertyChangeSubject
{
  Item uploadItem(Item item) throws SQLException;
  String setUser(String user);
  void startClient();
  User Register(User user) throws SQLException;
}
