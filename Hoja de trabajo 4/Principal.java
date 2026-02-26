/**
 * @author Alyson Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: permite que el programa interactue con el programa  por medio de la consola, además puede leer los archivos .txt 
 *  
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Principal {

    public static void main(String[] args) {
        //ruta donde estarán los datos en formato postfix
        String ruta="datos.txt";

        try(BufferedReader br= new BufferedReader(new FileReader(ruta))){
            //Variable para leer linea por linea
            String linea;
            while ((linea=br.readLine())!=null){
                //instancia del vector stack, que tiene como "padre" a la clase stack, por eso hay polimorfismo aqui
                Stack<Integer> stack= new VectorStack<>();
                //infix a postfix
                InfixToPostfix infixToPostfix= new ImplementacionInfixToPostfix(stack);
                //se envía la información del stack al constructor de la clase que lo implementará, así podrá realizar los calculos correspondientes con ese stack (stack vacio)
                CalculadorPostfix calculador= new ImplementacionCalculadora(stack);
                //manda la expresión parapoder calcular la respuesta usando el stack creado con anterioridad
                int resultado= calculador.calcular(linea);
                System.out.println("El resultado de " + linea + " es igual a " + resultado);
            }
        }
        catch(IOException e){
            System.out.println("Se ha encontrado un error: " + e.getMessage());
        }
        

    }

}
