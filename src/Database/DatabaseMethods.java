package Database;

import Shared.TransferObjects.Item;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;

public class DatabaseMethods implements Database
{
  public Connection connect() throws SQLException
  {

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Santiago32411");

  }

  public Statement statement() throws SQLException
  {
    connect();
    connect().close();
    return connect().createStatement();
  }

  @Override public void registerUser(String fname,String lname,String username,String password,String email,String birth)
      throws SQLException
  {
    connect();
    Statement stmt= statement();
    stmt.execute("INSERT INTO sepproject2.userr (email, pasword, username, fName, lName, birth)"
        + "VALUES ('"+email+"','"+password+"','"+username+"','"+fname+"','"+lname+"','"+birth+"')");
    System.out.println("Database methods");
    connect().close();
  }

  @Override public void addItem(String title, String price, String desc,
      String user, String subcategory, String url) throws SQLException
  {
    connect();
    Statement stmt= statement();
    stmt.execute("INSERT INTO sepproject2.items (title, price, description, user_id, is_sold, sub_category, url)"
        + "VALUES ('"+title+"','"+price+"','"+desc+"','"+getUserId(user)+"','false','"+subcategory+"','"+url+"')");
    connect().close();
  }

  @Override public ArrayList<String> getUsersRegistered() throws SQLException
  {
      ArrayList<String> userRegistered= new ArrayList<>();
      connect();
      Statement statement=statement();
      ResultSet resultSet=statement.executeQuery("select username from sepproject2.userr");
      while (resultSet.next()){
        userRegistered.add(resultSet.getString("username"));
      }
      connect().close();
      return userRegistered;
    }

  @Override public ArrayList<String> getEmailsRegistered() throws SQLException
  {
    ArrayList<String> emailRegistered= new ArrayList<>();
    connect();
    Statement statement=statement();
    ResultSet resultSet=statement.executeQuery("select email from sepproject2.userr");
    while (resultSet.next()){
      emailRegistered.add(resultSet.getString("email"));
    }
    connect().close();
    return emailRegistered;
  }

  @Override public ObservableList<Item> getAllItems() throws SQLException
  {
    connect();
    ObservableList<Item> list = FXCollections.observableArrayList();
    Statement statement=statement();
    ResultSet resultSet=statement.executeQuery("select * from sepproject2.items");

    while (resultSet.next()){
      int id= Integer.parseInt(resultSet.getString("user_id"));
      list.add(new Item(resultSet.getString("url"),(getUserById(id)),(resultSet.getString("price")),(resultSet.getString("title")),(resultSet.getString("description")),
          (resultSet.getString("sub_category"))));
    }
    return list;
  }

  @Override public boolean LogIn(String username, String password)
      throws SQLException
  {
    connect();
    Statement statement=statement();
    String passwordDatabase=null;
    ResultSet resultSet=statement.executeQuery("SELECT pasword,username\n"
        + "FROM sepproject2.userr\n" + "WHERE username='"+username+"';");
    while (resultSet.next()){
      passwordDatabase=resultSet.getString("pasword");
    }
    connect().close();
    statement.close();
    return password.equals(passwordDatabase);
  }

  @Override public int getUserId(String user2) throws SQLException
  {
    connect();
    Statement statement=statement();
    int user_id=0;
    ResultSet resultSet=statement.executeQuery("SELECT user_id FROM sepproject2.userr Where username='"+user2+"'");
    while (resultSet.next()){
      user_id= Integer.parseInt(resultSet.getString("user_id"));
    }
    return user_id;
  }

  @Override public String getUserById(int id) throws SQLException
  {
    connect();
    Statement statement=statement();
    String username=null;
    ResultSet resultSet=statement.executeQuery("SELECT username FROM sepproject2.userr Where user_id='"+id+"'");
    while (resultSet.next()){
      username= resultSet.getString("username");
    }
    return username;
  }


}
