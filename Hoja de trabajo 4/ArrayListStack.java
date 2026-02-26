/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: Clase que utiliza la estructura arraylist para funcioar como "stack"
*/
import java.util.ArrayList;

public class ArrayListStack<T> extends AbstractStack<T> {

    private ArrayList<T> list;

    public ArrayListStack() {
        list = new ArrayList<>();
    }

    @Override
    public void push(T element) {
        list.add(element);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        size--;
        return list.remove(size);
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return list.get(size - 1);
    }
}