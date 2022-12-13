import java.sql.Connection;
import java.sql.DriverManager;

public class Connect
{
  public static void main(String[] args) {
    Connection conn = null;

    try {
      String userName = "postgres";
      String password = "Santiago32411";

      String url = "jdbc:postgresql://localhost:5432/postgres";
      Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
      conn = DriverManager.getConnection(url, userName, password);
      System.out.println("Database connection established");
    } catch (Exception e) {
      System.err.println("Cannot connect to database server");
      System.err.println(e.getMessage());
      e.printStackTrace();
    } finally {
      if (conn != null) {
        try {
          conn.close();
          System.out.println("Database Connection Terminated");
        } catch (Exception e) {}
      }
    }
  }
}