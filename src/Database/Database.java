package Database;


import java.sql.SQLException;
import java.util.ArrayList;

public interface Database
{
  void registerUserr(String email,String password,String username,String fname,String lname,String birth)
      throws SQLException;
  void addItem(String title, String price,  String desc)
      throws SQLException;
  ArrayList<String> getUsersRegistered() throws SQLException;
  ArrayList<String> getEmailsRegistered() throws SQLException;

}
