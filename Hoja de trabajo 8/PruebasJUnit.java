/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 02/04/2026
 * Propósito clase: Clase PruebasJUnit, que se encargará de realizar pruebas unitarias utilizando JUnit para verificar el correcto funcionamiento de los métodos de incersión y eliminación de un elemento.
 */
public class PruebasJUnit {
  
    public static void main(String[] args) {

        VectorHeap<Paciente> heap = new VectorHeap<>();
        //se insertan pacientes con diferentes códigos de emergencia para probar el ordenamiento por prioridad
        heap.add(new Paciente("Abi", "x", "C"));
        heap.add(new Paciente("Braulio", "x", "A"));
        heap.add(new Paciente("Camila", "x", "B"));

        //se muestra el paciente con mayor prioridad después de las inserciones, que debería ser Braulio con código de emergencia A
        System.out.println("Debe salir A: " + heap.poll());
        System.out.println("Debe salir B: " + heap.poll());
        System.out.println("Debe salir C: " + heap.poll());

        System.out.println("Orden esperado: A, B, C");
        System.out.println("Orden obtenido: " + heap.poll() + ", " + heap.poll() + ", " + heap.poll());
    }
}
