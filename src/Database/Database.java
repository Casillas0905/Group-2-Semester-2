package Database;


import Shared.TransferObjects.Item;
import javafx.collections.ObservableList;

import java.sql.SQLException;
import java.util.ArrayList;

public interface Database
{
  void registerUser(String fname,String lname,String username,String password,String email,String birth)
      throws SQLException;
  void addItem(String title, String price, String desc, String user,String subcategory,String url) throws SQLException;
  ArrayList<String> getUsersRegistered() throws SQLException;
  ArrayList<String> getEmailsRegistered() throws SQLException;
  ObservableList<Item> getAllItems() throws SQLException;
  boolean LogIn(String username, String password) throws SQLException;
  int getUserId(String user) throws SQLException;
  String getUserById(int id) throws SQLException;

}
