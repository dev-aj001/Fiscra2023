package vista;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import custom.PasswordStrengthStatus;
import custom.userData;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import jpa.JPAController;
import modelos.Usuario;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author jairi
 */
public class ResetLogin extends JPanel{

    public ResetLogin() {
        init();
    }
    
    
    private void init(){
        setLayout(new MigLayout("fill,insets 20","[center]","[center]"));
        txtPasword1 = new JPasswordField();
        txtPasword2 = new JPasswordField();
        btnLogin = new JButton("Actualizar");
        PasswordStrengthStatus pss = new PasswordStrengthStatus();
        
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "fill,350:280"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""+
                "arc:20;"+
                "[light]background:darken(@background,3%);"+
                "[dark]background:lighten(@background,3%)"
                );
        
        JLabel lbTitle = new JLabel("¡Su contraseña actual no es segura!");
        JLabel descripcion = new JLabel("Porfavor actualice su contraseña");
        
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""+
                "font:bold +10"
                );
        
        descripcion.putClientProperty(FlatClientProperties.STYLE, ""+
                "[light]foreground:lighten(@foreground,30%);"+
                "[dark]foreground:darken(@foreground,30%)"
                );
        
        txtPasword1.putClientProperty(FlatClientProperties.STYLE, ""+
                "showRevealButton:true"
                );
        
        txtPasword2.putClientProperty(FlatClientProperties.STYLE, ""+
                "showRevealButton:true"
                );
        
        pss.initPasswordField(txtPasword1);
        
        panel.add(lbTitle);
        panel.add(descripcion);
        panel.add(new JLabel("Nueva contraseña"),"gapy 8");
        panel.add(txtPasword1);
        panel.add(pss, "gapy 8");
        panel.add(new JLabel("Confirmar contraseña"),"gapy 8");
        panel.add(txtPasword2);
        panel.add(btnLogin, "gapy 15");
        
        
        
        add(panel);
    }
    
    
    public JPasswordField txtPasword1;
    public JPasswordField txtPasword2;
    public JButton btnLogin;

    void validar() {
        if(!txtPasword1.getText().equals(txtPasword2.getText()))
            JOptionPane.showMessageDialog(this, "Las contraseñas no coinciden");
        else{
            actualizarPass();
            JOptionPane.showMessageDialog(this, "Contraseña actualizada exitosamente!");
            new GerenteMain().setVisible(true);
        }
        
        
    }

    private void actualizarPass() {
        JPAController jpa = new JPAController();
        Usuario user = jpa.getUsuario(userData.id);
        user.setContrasena(txtPasword1.getText());
        jpa.modificarUsuario(user);
    }

    
}
