/**
 * @author Allysón Dulce Abigail Escobar 
 * Fecha:2/2/2026
 * Propósito clase: Define los métodos que debe de hacer, pero no cómo hacerlos, lo que lo hace más flexible al momento de implementar el cómo se hacen las acciones.
 *  
 */
public interface Stack <T> {
    void push(T element);
    T pop();
    T peek();
    int size();
    
}
