/**
 * 
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 02/04/2026
 * Propósito clase: Clase Main, que se encargará de ejecutar el programa y leer el archivo "Pacientes.txt" para crear objetos de la clase Paciente y almacenarlos en un VectorHeap, el cual se ordenará por prioridad de atención utilizando el código de emergencia.
 */
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //se crea un VectorHeap para almacenar los pacientes, utilizando la clase VectorHeap que implementa la interfaz PriorityQueue
        VectorHeap<Paciente> heap = new VectorHeap<>();
        //En esta primera parte se leerá el archivo y se insertarán los pacientes en el VectorHeap, mostrando cada paciente insertado
        String ruta="pacientes.txt";

        try(BufferedReader br= new BufferedReader(new FileReader(ruta))){
            String linea;
            //mientras haya una línea que leer
            while ((linea=br.readLine())!=null) {
                //se guardan los datos en un arreglo, separando los elementos por comas
                String[] datos = linea.split(",");
                //como son 3 elementos los que se suponen que hay en cada línea, si hay más de esos se ignora la línea
                if (datos.length == 3) {
                    //trim es para eliminar espacios en blanco al inicio y al final de cada dato
                    //Se guardan los datos en su correspondiente varia
                    String nombre = datos[0].trim();
                    String desSintomas = datos[1].trim();
                    String codigoEmergencia = datos[2].trim();
                    //se insertan en el VectorHeap, creando un nuevo objeto de la clase Paciente con los datos leídos
                    heap.add(new Paciente(nombre, desSintomas, codigoEmergencia));
                    //se muestra el paciente insertado
                    System.out.println("Paciente insertado: " + nombre + ", " + desSintomas + ", " + codigoEmergencia);
                }
            }
            System.out.println("Paciente con mayor prioridad despues de la insercion: " + heap.peek().toString());
        } 
        catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        //Como segundo paso se mostrará un menu para eliminar pacientes del VectorHeap, mostrando el paciente eliminado y el paciente con mayor prioridad después de cada eliminación
        Scanner sc= new Scanner(System.in);
        while (!heap.isEmpty()) {
            System.out.println("¿Atender siguiente paciente? (s/n)");
            String respuesta = sc.nextLine();

            if (respuesta.equalsIgnoreCase("s")) {
                Paciente eliminado = heap.poll();
                System.out.println("\nPaciente atendido: " + eliminado.toString());
            } else {
                break;
            }
        }
    }
}
