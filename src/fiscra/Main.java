/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package fiscra;

import com.formdev.flatlaf.FlatIntelliJLaf;
import vista.GerenteMain;

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
        FlatIntelliJLaf.registerCustomDefaultsSource("styles");
        new GerenteMain().setVisible(true);
    }
    
}
