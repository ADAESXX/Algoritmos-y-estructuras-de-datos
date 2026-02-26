/**
 * @author Alyson Dulce Abigail Escobar Sandoval
 * Fecha: 26/02/2026
 * Propósito clase: 
 *  
 */
public interface List<T> {
    // Funciones principales de una pila pero aplicadas a las listas (serán simplemente encadenadas y doblemente encadenadas)
    void addFirst(T element);     
    T removeFirst();              
    T getFirst();                 
    int size();
    boolean isEmpty();

}
