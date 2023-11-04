package vista;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import net.miginfocom.swing.MigLayout;

/**
 *
 * @author jairi
 */
public class Login extends JPanel{

    public Login() {
        init();
    }
    
    
    private void init(){
        setLayout(new MigLayout("fill,insets 20","[center]","[center]"));
        txtUsuario = new JTextField();
        txtPasword = new JPasswordField();
        chRememberMe = new JCheckBox("Recordar contraseña");
        btnLogin = new JButton("Entrar");
        
        JPanel panel = new JPanel(new MigLayout("wrap,fillx,insets 35 45 30 45", "fill,250:280"));
        panel.putClientProperty(FlatClientProperties.STYLE, ""+
                "arc:20;"+
                "[light]background:darken(@background,3%);"+
                "[dark]background:lighten(@background,3%)"
                );
        
        JLabel lbTitle = new JLabel("Bienvenido!");
        JLabel descripcion = new JLabel("Porfavor ingrese sus credenciales");
        
        lbTitle.putClientProperty(FlatClientProperties.STYLE, ""+
                "font:bold +10"
                );
        
        descripcion.putClientProperty(FlatClientProperties.STYLE, ""+
                "[light]foreground:lighten(@foreground,30%);"+
                "[dark]foreground:darken(@foreground,30%)"
                );
        
        txtPasword.putClientProperty(FlatClientProperties.STYLE, ""+
                "showRevealButton:true"
                );
        
        panel.add(lbTitle);
        panel.add(descripcion);
        panel.add(new JLabel("Usuario"),"gapy 8");
        panel.add(txtUsuario);
        panel.add(new JLabel("Contraseña"),"gapy 8");
        panel.add(txtPasword);
        panel.add(chRememberMe, "grow 0");
        panel.add(btnLogin, "gapy 15");
        
        
        
        add(panel);
    }
    
    
    public JTextField txtUsuario;
    public JPasswordField txtPasword;
    public JCheckBox chRememberMe;
    public JButton btnLogin;

    
}
