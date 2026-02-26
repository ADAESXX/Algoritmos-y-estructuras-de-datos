/**
 * @author Alyson Dulce Abigail Escobar Sandoval
 * Fecha: 26/02/2026
 * Propósito clase: permite que el programa interactue con el programa  por medio de la consola, además puede leer los archivos .txt 
 *  
 */
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        //ruta donde estarán los datos en formato postfix
        String ruta="datos.txt";

        Scanner sc= new Scanner(System.in);
        System.out.println("Para las preguntas que se le haran a continuacion, por favor solo ingrese el numero correspondiente (no puntos ni letras)");
        System.out.println("Seleccione la implementacion que desea urilizar:\n1. Vector\n2.Lista\n3.ArrayList\n");
        int opcion=sc.nextInt();

        try(BufferedReader br= new BufferedReader(new FileReader(ruta))){
            //Variable para leer linea por linea
            String linea;
            while ((linea=br.readLine())!=null){
                //instancia del vector stack, que tiene como "padre" a la clase stack, por eso hay polimorfismo aqui
                Stack<String> stackConversion= null;
                Stack<Integer> stackCalculo= null;
                switch (opcion) {
                    case 1:
                        stackConversion= new VectorStack<>();
                        stackCalculo= new VectorStack<>();
                        break;
                    case 2:
                        System.out.println("Seleccione el tipo de lista que desea utilizar:\n1.Simplmente encadenada\n2.Doblemente encadenada");
                        int tipoLista= sc.nextInt();

                        if(tipoLista ==1){
                            stackConversion= new ListStack<>(new SinglyLinkedList<>());
                            stackCalculo= new ListStack<>(new SinglyLinkedList<>());
                        }
                        else{
                            stackConversion= new ListStack<>(new DoublyLinkedList<>());
                            stackCalculo = new ListStack<>(new DoublyLinkedList<>());
                        }
                        break;
                    case 3:
                        stackConversion= new ArrayListStack<>();
                        stackCalculo= new ArrayListStack<>();
                        break;
                    default:
                        throw new AssertionError();
                }
                
                //infix a postfix
                InfixToPostfix infixToPostfix= new ImplementacionInfixToPostfix(stackConversion);
                //se envía la información del stack al constructor de la clase que lo implementará, así podrá realizar los calculos correspondientes con ese stack (stack vacio)
                CalculadorPostfix calculador= new ImplementacionCalculadora(stackCalculo);
                //se convierte la expresión infix a postfix
                String postfix= infixToPostfix.convertir(linea);
                //manda la expresión para poder calcular la respuesta usando el stack creado con anterioridad
                int resultado= calculador.calcular(postfix);
                System.out.println("El resultado de " + linea + " es igual a " + resultado);
            }
        }
        catch(IOException e){
            System.out.println("Se ha encontrado un error: " + e.getMessage());
        }
        

    }

}
