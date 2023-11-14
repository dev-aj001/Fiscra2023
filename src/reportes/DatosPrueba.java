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
    private String declaracion1;

    public DatosPrueba() {
        index = -1;
        nombrePac = "paciente nombre completo";
        nombreFam = "nombre completo del familiar";
        fecha = "fecha actual";
        
        declaracion1 = """
                       Yo, Mar\u00eda L\u00f3pez, esposa de Juan P\u00e9rez, con domicilio en Calle Ju\u00e1rez No. 123, Tepic, Nayarit, declaro que mi esposo ha sido ingresado a la Cl\u00ednica de Rehabilitaci\u00f3n Tepic por un accidente automovil\u00edstico.
                       
                       Entiendo que el periodo de rehabilitaci\u00f3n de mi esposo ser\u00e1 indeterminado, hasta que se recupere por completo. Durante este tiempo, me comprometo a proporcionarle el apoyo necesario para su recuperaci\u00f3n, incluyendo supervisi\u00f3n, atenci\u00f3n m\u00e9dica y compa\u00f1\u00eda.
                       
                       Asimismo, autorizo a la Cl\u00ednica de Rehabilitaci\u00f3n Tepic a realizar todos los procedimientos m\u00e9dicos necesarios para la rehabilitaci\u00f3n de mi esposo.""";
    
    
    }
    
    
    
    @Override
    public boolean next() throws JRException {
        index++;
        return(index<1);
    }

    @Override
    public Object getFieldValue(JRField jrf) throws JRException {
        
        String value = null;
        
        String fieldName = jrf.getName();
        
        switch (fieldName) {
            case "Declaracion1":
                value = nombrePac;
                break;
            case "Declaracion2":
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
