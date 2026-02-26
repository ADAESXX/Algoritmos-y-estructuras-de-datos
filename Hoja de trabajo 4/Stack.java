/**
 * @author Allysón Dulce Abigail Escobar 
 * Fecha:25/02/2026
 * Propósito clase: Define los métodos que debe de hacer, pero no cómo hacerlos, lo que lo hace más flexible al momento de implementar el cómo se hacen las acciones.
 *  
 */
public interface Stack <T> {
    // Funciones principales de una pila
    void push(T element);
    T pop();
    T peek();
    int size();
    boolean isEmpty();
    
}
