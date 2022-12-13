package Client.Model;

import Shared.Util.PropertyChangeSubject;

import java.sql.SQLException;

public interface Model extends PropertyChangeSubject
{
  void uploadItem(String picture, String price, String title, String desc, String subCategory)
      throws SQLException;
  void setUser(String user);
  void registerUser(String fname,String lname,String username,String password,String email,String birth)
      throws SQLException;
  boolean isUserOrEmailFree(String email,String username) throws SQLException;
  boolean LogIn(String username, String password) throws SQLException;
}
