/*
 * Connecting to MySQL Database 
*/
package JDBC;

import java.sql.*;

public class JavaApplication1
{
  public static void main(String[] args) 
  {
      System.out.println("Connecting to MySQL Database called \"test\" using MySQL JDBC Driver");
      Connection conn = null;
      String url = "jdbc:mysql://localhost/";
      String dbName = "test";
      String driver = "com.mysql.jdbc.Driver";
      String userName = "root"; 
      String password = "";
      
      try {
        Class.forName(driver).newInstance();
        conn = DriverManager.getConnection(url+dbName,userName,password);
        System.out.println("Your program has successfully connected to the database - horray!");
        System.out.println("... you could query the database using the SQL commands you learned in DBMS...");
        System.out.println("... but for now we will simply close the connection.");
        conn.close();
        System.out.println("Your program has disconnected from the database");
      } 
      catch (Exception e) 
      {
          System.out.println("Failed to connect to database - check MySQL is running and the userid and password");
            e.printStackTrace();
      }
  }
}