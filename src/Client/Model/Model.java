package Client.Model;

import Shared.Util.PropertyChangeSubject;

import java.sql.SQLException;

public interface Model extends PropertyChangeSubject
{
  void uploadItem(String picture, String price, String title, String desc, String subCategory);
  void setUser(String user);
  void registerUser(String email,String password,String username,String fname,String lname,String birth)
      throws SQLException;
  boolean isUserOrEmailFree(String email,String username) throws SQLException;
  boolean LogIn(String username, String password) throws SQLException;
}
