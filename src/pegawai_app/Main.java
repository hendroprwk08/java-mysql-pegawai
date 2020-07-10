package pegawai_app;

import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class Main {

    public static void main(String[] args) {
        try {
            //tema
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog( null, ex);
        }
        
        FMenu f = new FMenu();
        f.setExtendedState(FMenu.MAXIMIZED_BOTH);
        f.setVisible( true );        
    }
    
}
