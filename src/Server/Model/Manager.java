package Server.Model;

import Shared.TransferObjects.Item;
import Shared.TransferObjects.User;
import Shared.Util.PropertyChangeSubject;

import java.sql.SQLException;

public interface Manager extends PropertyChangeSubject
{
  Item uploadItem(Item item) throws SQLException;
  void setUser(String user);
  User register(User user) throws SQLException;
  boolean LogIn(String username, String password) throws SQLException;
}
