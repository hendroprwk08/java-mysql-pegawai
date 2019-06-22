package java_db_mysql_barang;

import java.sql.*;
import javax.swing.JOptionPane;

public class DB {
    private static Connection conn;
    
    public static Connection connectDB() throws SQLException{
        try {
            String DB = "jdbc:mysql://localhost:3306/dbpegawai";
            String username = "root";
            String password = "";

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            conn = (Connection) DriverManager.getConnection(DB, username, password); 

            return conn;               
        } catch (SQLException sQLException) {
            JOptionPane.showMessageDialog(null, sQLException.toString());
        }

        return null;
    }
}
