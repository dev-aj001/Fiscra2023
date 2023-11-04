/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vista;

import custom.userData;
import java.awt.EventQueue;
import java.util.List;
import javax.swing.JOptionPane;
import jpa.JPAController;
import modelos.Usuario;

/**
 *
 * @author jairi
 */
public class LoginFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginFrame
     */
    public LoginFrame() {
        initComponents();
        login = new Login();
        setContentPane(login);
        
        login.btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
    }
    
    Login login = null;
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        validarLogin();
    } 

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(102, 255, 0));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1084, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 493, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    private void validarLogin() {
        try {
            validarUsuario(login.txtUsuario.getText().strip(), login.txtPasword.getText().strip());
            
        } catch (Exception e) {
        }
        
    }
    
    private void validarUsuario(String usuarioTXT, String passTXT){
        
        JPAController jpa = new JPAController();
        
        String msj="";
        
        List<Usuario> listUsuarios = jpa.getListaUsuarios();
        
        for (Usuario usuario : listUsuarios) {
            if(usuario.getUsuario().equals(usuarioTXT)){
                if(usuario.getContrasena().equals(passTXT)){
                    userData.nombre = usuario.getNombre();
                    userData.rol = usuario.getRol();
                    userData.id = usuario.getIdUsuarios();
                    JOptionPane.showMessageDialog(rootPane, "Bienvenido "+userData.nombre);
                    if("123456".equals(usuario.getContrasena())){
                        dispose();
                        new ResetLoginFrame().setVisible(true);
                    }else{
                        dispose();
                        new GerenteMain().setVisible(true);
                    }
                    
                    return;
                }else
                    JOptionPane.showMessageDialog(rootPane, "La contraseña es incorrecta");
                    return;
            }
            
        }
        
        JOptionPane.showMessageDialog(rootPane, "El usuario no existe");
    } 
}
