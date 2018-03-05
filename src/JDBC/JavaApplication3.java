/* 
 * Connect to Database and execute Prepared Statement to INSERT
 */
package JDBC;

import java.sql.*;

public class JavaApplication3 {

    public static void main(String[] args) {
        System.out.println("MySQL Connect Example.");
        Connection conn = null;
        String url = "jdbc:mysql://localhost/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";  //  or password = null; if there is no password on your database

        Statement statement = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        String firstName = "Charlie";     // Normally, these variables would be filled
        String lastName = "Haughey";      // from input boxes in the User Interface of the
        String birthDate = "1950-02-01";  // Java application.

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database");
            System.out.println("Inserting row for Charlie Haughey....");

            preparedStatement = conn.prepareStatement("insert into test.Customers values (null, ?, ?, ?)");

            // Parameters are numbered statring with 1, and correspond to order of the question marks above
            // 1 corresponds to first question mark, and so on...
            // The first field is an Auto-Incremant field in teh database, so we specify a null value for it
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setDate(3, Date.valueOf(birthDate));

            preparedStatement.executeUpdate();

            // Statements allow to issue SQL queries to the database
            statement = conn.createStatement();

            // Execute the Prepared Statement and get a result set
            resultSet = statement.executeQuery("select * from Customers");

            while (resultSet.next()) {
                // It is possible to get the columns via name (as shown)
                // or via the column number which starts at 1
                // e.g. resultSet.getSting(2);
                int custID = resultSet.getInt("custID");
                String fname = resultSet.getString("firstName");
                //String fname = resultSet.getString(2); // same effect as line above
                String lname = resultSet.getString("lastName");
                Date dob = resultSet.getDate("dob");

                System.out.print(custID + ", ");
                System.out.print(fname + ", ");
                System.out.print(lname + ", ");
                System.out.println(dob);
            }
            
            
            

            System.out.println("\n\nDelete all customers hwose name is charlie");

            preparedStatement = conn.prepareStatement("delete from test.Customers where firstName = ?");

            preparedStatement.setString(1, firstName);

            preparedStatement.executeUpdate();
           
            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from Customers");

            while (resultSet.next()) {
          
                int custID = resultSet.getInt("custID");
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                Date dob = resultSet.getDate("dob");

                System.out.print(custID + ", ");
                System.out.print(fname + ", ");
                System.out.print(lname + ", ");
                System.out.println(dob);
            }
            
            
            System.out.println("update last name of customer where id = 4");
            
            preparedStatement = conn.prepareStatement("update test.Customers set lastName = ? where custID = ?");
            lastName = "Gilhooley";
            int custID = 4;
            preparedStatement.setString(1, lastName);
            preparedStatement.setInt(2, custID);
            preparedStatement.executeUpdate();
            
            statement = conn.createStatement();
            resultSet = statement.executeQuery("select * from Customers");

            while (resultSet.next()) {
          
                custID = resultSet.getInt("custID");
                String fname = resultSet.getString("firstName");
                String lname = resultSet.getString("lastName");
                Date dob = resultSet.getDate("dob");

                System.out.print(custID + ", ");
                System.out.print(fname + ", ");
                System.out.print(lname + ", ");
                System.out.println(dob);
            }
            

            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
