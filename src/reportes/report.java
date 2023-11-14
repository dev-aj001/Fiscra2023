/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;

import javax.swing.WindowConstants;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author jairi
 */
public class report {

    public report() {
        
        try {
            JasperReport reporte = (JasperReport) JRLoader.loadObject(getClass().getResource("/reportes/ReporteIngreso.jasper"));
            JasperPrint jprint = JasperFillManager.fillReport(reporte, null, DatosPrueba.getDataSource());
            
            JasperViewer view = new JasperViewer(jprint, false);
            view.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            view.setVisible(true);
            
        } catch (Exception e) {
            e.getMessage();
        }
        
    }
    
    
    
    public static void main(String[] args) {
        report r = new report();
    }
}
