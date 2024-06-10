
package Utiliti;

import java.sql.*;


public class DBConnection {

    public static final String HOSTNAME = "localhost";
    public static final String PORT = "1433";
    public static final String DBNAME = "DUAN1_NHOM5";
<<<<<<< HEAD
    public static final String USERNAME = "sa";
    public static final String PASSWORD = "123456789";

=======
    public static final String USERNAME = "sa1";
    public static final String PASSWORD = "123456";
>>>>>>> 1eeae9b02218b17e9b8f17b03b2df8066407a144

    /**
     * Get connection to MSSQL Server
     *
     * @return Connection
     */
    public static Connection getConnection() {

        // Create a variable for the connection string.
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";encrypt=true;trustservercertificate=true;";
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl, USERNAME, PASSWORD);
        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }

    public static void main(String[] args) {
        getConnection();
    }

}
