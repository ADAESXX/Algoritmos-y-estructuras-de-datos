/**
 * @author Alyson Dulce Abigail Escobar Sandoval
 * Fecha: 
 * Propósito clase: permite que el programa interactue con el programa  por medio de la consola, además puede leer los archivos .txt 
 *  
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {

        String ruta="datos.txt";

        try(BufferedReader br= new BufferedReader(new FileReader(ruta))){
            String linea;
            while ((linea=br.readLine())!=null){
                //falta logica
                Object stack=null;
                CalculadorPostfix calculador= new ImplementacionCalculadora((Stack<Integer>) stack);
                int resultado= calculador.calcular(linea);
                System.out.println("El resultado de " + linea + " es igual a " + resultado);
            }
        }
        catch(IOException e){
            System.out.println("Se ha encontrado un error: " + e.getMessage());
        }
        

    }

}
