package Database;


import Shared.TransferObjects.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Database
{
  void registerUserr(String email,String password,String username,String fname,String lname,String birth)
      throws SQLException;
  void addItem(String title, String price,  String desc,String subCategory)
      throws SQLException;
  ArrayList<String> getUsersRegistered() throws SQLException;
  ArrayList<String> getEmailsRegistered() throws SQLException;
  ArrayList<Item> getAllItems();
  boolean LogIn(String username, String password) throws SQLException;

}
