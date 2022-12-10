package Model;

import Util.PropertyChangeSubject;

import java.sql.SQLException;

public interface Model extends PropertyChangeSubject
{
  Item uploadItem(String price, String title, String desc, String subCategory);
  void setUser(String user);
  void registerUser(String email,String password,String username,String fname,String lname,String birth)
      throws SQLException;
}
