package java_db_mysql_barang;

import java.awt.Frame;
import javax.swing.JFrame;
import javax.swing.UIManager;

public class Java_DB_Mysql_Barang {

    public static void main(String[] args) {
        //set tema
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch( Exception e ){
            e.printStackTrace();
        }
        
        FMenu f = new FMenu();
        f.setExtendedState(FMenu.MAXIMIZED_BOTH); //full screen
        f.setVisible(true);
    }   
}
