/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fiscra;

import com.formdev.flatlaf.FlatDarkLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.EventQueue;
import vista.GerenteMain;
import vista.LoginFrame;
import vista.ResetLogin;
import vista.ResetLoginFrame;

/**
 *
 * @author jairi
 */
public class Main {
    
    /**
     * Global arguments
     */
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // TODO code application logic here
        System.setProperty("flatlaf.uiScale", "1.0");
        FlatLaf.registerCustomDefaultsSource("styles");
        //FlatLightLaf.setup();
        FlatLightLaf.setup();
        new LoginFrame().setVisible(true);
    }
    
}
