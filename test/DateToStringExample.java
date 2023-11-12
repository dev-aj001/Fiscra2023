import java.text.SimpleDateFormat;
import java.util.Date;

public class DateToStringExample {
    public static void main(String[] args) {
        // Obtén la fecha actual
        Date fechaActual = new Date();

        // Crea un objeto SimpleDateFormat con el formato deseado
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'del' yyyy");

        // Convierte la fecha a un String con el formato especificado
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Imprime el resultado
        System.out.println("Fecha formateada: " + fechaFormateada);
    }
}
