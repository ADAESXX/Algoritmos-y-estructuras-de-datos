/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 03/04/2026
 * Propósito clase: Clase PriorityQueue, que define la interfaz para una cola de prioridad
 */
public interface PriorityQueue<E> {
    /**
     * Agrega un elemento al heap y luego lo reordena para mantener la propiedad del heap
     * @param value
     */
    void add(E value);
    /**
     * @return el elemento con mayor prioridad del heap
     * El método poll elimina y devuelve el elemento con mayor prioridad del heap, luego reordena el heap para mantener la propiedad del heap
     */
    E poll();
    /**
     * @return el elemento con mayor prioridad del heap sin eliminarlo
     */
    E peek();
    /**
     * @return true si el heap está vacío, false en caso contrario
     */
    boolean isEmpty();
}
