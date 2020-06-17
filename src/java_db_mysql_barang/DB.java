package java_db_mysql_barang;

import java.sql.*;
import javax.swing.JOptionPane;

public class DB {
    private static Connection conn;
    
    public static Connection connectDB(){
        try {
            String DB = "jdbc:mysql://localhost:3306/db_hrd_baru";
            String username = "root";
            String password = "";
            
            conn = (Connection) DriverManager.getConnection(DB, username, password); 

            return conn;               
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } 

        return null;
    }
    
    public static boolean exec(String sql){
        try {
            conn = (Connection) connectDB();            
            Statement pst = conn.createStatement();
            pst.execute(sql);
            
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return false;
    }
    
    public static ResultSet read(String sql){
        ResultSet rs = null;
        
        try {
            conn = (Connection) connectDB();            
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
        
        return rs;
    }
    
    public static void close(){
        try{
            conn.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
}
