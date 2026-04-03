/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 03/04/2026
 * Propósito clase: Hace lo mismo que el Main, pero utilizando la clase PriorityQueue de Java en lugar de la clase VectorHeap
 */
import java.io.*;
import java.util.PriorityQueue;

public class MainJCF {
    public static void main(String[] args) {
        //instanncia del PriorityQueue
        PriorityQueue<Paciente> pq = new PriorityQueue<>();
        //lectura del archivo
        try (BufferedReader br = new BufferedReader(new FileReader("pacientes.txt"))) {
            String linea;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length == 3) {
                    pq.add(new Paciente(
                        datos[0].trim(),
                        datos[1].trim(),
                        datos[2].trim()
                    ));
                }
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("\nOrden de atencion:");
        while (!pq.isEmpty()) {
            System.out.println(pq.poll());
        }
    }
}