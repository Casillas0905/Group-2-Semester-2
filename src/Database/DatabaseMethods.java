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

    return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","Iker0905");

  }

  public Statement statement() throws SQLException
  {
    connect();
    connect().close();
    return connect().createStatement();
  }

  @Override public void registerUserr(String email,String password,String username,String fname,String lname,String birth)
      throws SQLException
  {
    connect();
    Statement stmt= statement();
    stmt.execute("INSERT INTO sepproject2.userr (email, pasword, username, fName, lName, birth)"
        + "VALUES ('"+email+"','"+password+"','"+username+"','"+fname+"','"+lname+"','"+birth+"')");
    System.out.println("Database methods");
    connect().close();
  }

  @Override public void addItem(String title, String price, String desc) throws SQLException
  {
    connect();
    Statement stmt= statement();

    stmt.execute("INSERT INTO sepproject2.items (title, price, description, user_id, is_sold, sub_category_id)"
        + "VALUES ('"+title+"','"+price+"','"+desc+"','0','false','0')");
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
      list.add(new Item(resultSet.getString("url"),(resultSet.getString("user_id")),(resultSet.getString("price")),(resultSet.getString("title")),(resultSet.getString("description")),
          (resultSet.getString("sub_category_id"))));
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
        + "FROM sepproject2.userr\n" + "WHERE username='"+username.toLowerCase()+"';");
    while (resultSet.next()){
      passwordDatabase=resultSet.getString("pasword");
    }
    return password.equals(passwordDatabase);
  }

}
