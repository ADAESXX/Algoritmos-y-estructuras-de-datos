/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: Esta clase implementa la interfaz Stack, es decir, define cómo se realizarán las acciones de una pila usando un vector. 
 */
public class VectorStack<T> extends AbstractStack<T> {

    private Object[] vector;   
    private int size;          

  
    public VectorStack() {
        vector = new Object[10];
        size = 0;
    }

    
    @Override
    public void push(T element) {
        if (size == vector.length) {
            resize();
        }
        vector[size++] = element;
    }

    //Elimina y retorna el elemento superior de la pila
    @Override
    @SuppressWarnings("unchecked")
    public T pop() {
        if (size == 0) {
            throw new RuntimeException("Pila vacía");
        }
        T element = (T) vector[--size];
        vector[size] = null;
        return element;
    }

    
    @Override
    @SuppressWarnings("unchecked")
    public T peek() {
        if (size == 0) {
            throw new RuntimeException("Pila vacía");
        }
        return (T) vector[size - 1];
    }

    
   
    private void resize() {
        Object[] newVector = new Object[vector.length * 2];
        System.arraycopy(vector, 0, newVector, 0, vector.length);
        vector = newVector;
    }

}
