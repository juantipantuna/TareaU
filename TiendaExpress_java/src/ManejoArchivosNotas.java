import java.io.*;

public class ManejoArchivosNotas {
    public static void main(String[] args) {
        
        String archivoNotas = "mis_notas.txt";
        
        // ESCRIBIR ARCHIVO
        try {
            PrintWriter escribir = new PrintWriter(new FileWriter(archivoNotas));
            
            escribir.println("Nota 1: Esta semana aprendí a manejar archivos en Java.");
            escribir.println("Nota 2: FileWriter y BufferedReader son clases útiles.");
            escribir.println("Nota 3: Es importante cerrar los archivos con .close().");
            
            escribir.close();
            System.out.println("Archivo mis_notas.txt creado exitosamente.");
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        // LEER ARCHIVO
        try {
            BufferedReader leer = new BufferedReader(new FileReader(archivoNotas));
            
            String linea;
            while ((linea = leer.readLine()) != null) {
                System.out.println("Nota: " + linea);
            }
            
            leer.close();
            
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}