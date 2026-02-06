/**
 * @author: Paola
 * Fecha:
 * Propósito clase:
 *  
 */
public class VectorStack<T> implements Stack<T> {

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

    
    @Override
    public int size() {
        return size;
    }

   
    private void resize() {
        Object[] newVector = new Object[vector.length * 2];
        System.arraycopy(vector, 0, newVector, 0, vector.length);
        vector = newVector;
    }
}

