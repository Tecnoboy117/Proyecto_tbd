
package vistas;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginAC {


    public static void main(String[] args) {

        java.awt.EventQueue.invokeLater(new Runnable() {
                public void run() {
                    try {
                        new ProductosT().setVisible(true);
                    } catch (SQLException ex) {
                        Logger.getLogger(LoginAC.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });

    }
    
}
