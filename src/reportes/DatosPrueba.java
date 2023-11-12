/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package reportes;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;


/**
 *
 * @author jairi
 */
public class DatosPrueba implements JRDataSource{
    
    private int index;
    
    private String nombrePac ;
    private String nombreFam ;
    private String fecha ;

    public DatosPrueba() {
        index = -1;
        nombrePac = "paciente nombre completo";
        nombreFam = "nombre completo del familiar";
        fecha = "fecha actual";
    }
    
    
    
    @Override
    public boolean next() throws JRException {
        index++;
        return(index<3);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        
        String value = null;
        
        String fieldName = jrf.getName();
        
        switch (fieldName) {
            case "Nombre_paciente":
                value = nombrePac;
                break;
            case "Nombre_familiar":
                value = nombreFam;
                break;
            case "fecha":
                value = fecha;
                break;
            default:
                throw new AssertionError();
        }
        
        return value;
    }
    
    public static JRDataSource getDataSource(){
        return new DatosPrueba();
    }
    
}
