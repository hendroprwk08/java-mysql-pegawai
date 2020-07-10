package pegawai_app;

import java.sql.*;
import javax.swing.JOptionPane;

public class DB {
    private static Connection conn;
    
    public static Connection connectDB() throws SQLException{
        String DB = "jdbc:mysql://localhost:3306/db_hrd_baru";
        String username = "root";
        String password = "";
        
        try{
            conn = ( Connection ) DriverManager.getConnection(DB, username, password);
            return conn;
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        return null;
    }
    
    
    //baca data dari mysql
    public static ResultSet read(String sql) throws SQLException{
        ResultSet rs = null;
        
        try {
            conn = (Connection) connectDB();
            Statement st = conn.createStatement();
            rs = st.executeQuery(sql);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
 
        return rs;
    } 
    
    //eksekusi data 
    public static boolean exec(String sql) throws SQLException{
        try {
            conn = (Connection) connectDB();
            Statement st = conn.createStatement();
            st.execute(sql);
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
        
        return false;
    } 
    
    public static void closeDB() throws SQLException{
        try {
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.toString());
        }
    }
}
