/* 
 * Connect to Database and execute embedded SELECT Query.
 * Required: Table "Customers", with fields: custID, firstName, lastName, dob
 */
package JDBC;

import java.sql.*;

public class JavaApplication2 {

    public static void main(String[] args) {
        System.out.println("MySQL: Connect to Database and execute a 'raw' SELECT Statement");
        Connection conn = null;
        String url = "jdbc:mysql://localhost/";
        String dbName = "test";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "";

        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            System.out.println("Connected to the database.");

            // Statements allow us to issue SQL queries to the database
            statement = conn.createStatement();

            // Result set stores the result from the SQL query
            resultSet = statement.executeQuery("select * from Customers");

            // iterate over the resultSet to get each row
            while (resultSet.next()) {
                // Columns can be identified by column name or by number
                // The first column is number 1
                // e.g. resultSet.getString(2);
                int custID = resultSet.getInt(1);
//                int custID = resultSet.getInt("custID");
//                String fname = resultSet.getString("firstName");
                String fname = resultSet.getString(2);
                String lname = resultSet.getString(3);  // get third value
//                Date dob = resultSet.getDate("dob");
                Date dob = resultSet.getDate(4);

                System.out.print(custID + ", ");
                System.out.print(fname + ", ");
                System.out.print(lname + ", ");
                System.out.println(dob);
            }

            conn.close();
            System.out.println("Disconnected from database");
        } catch (Exception e) {
            System.out.println("Failed to connect to database - check that MySQL is running, and that userid and password is correcct");
            e.printStackTrace();
        }
    }
}
