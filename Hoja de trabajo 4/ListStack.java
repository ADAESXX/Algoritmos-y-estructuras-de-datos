/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: Clase que usa la lista (simplmente encadenada o doblemente encadenada) como stack 
*/

public class ListStack<T> extends AbstractStack<T> {
    //creacion de la lista "stack"
    private List<T> list;

    //constructor
    public ListStack(List<T> list) {
        this.list = list;
    }

    @Override
    public void push(T element) {
        list.addFirst(element);
        size++;
    }

    @Override
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        size--;
        return list.removeFirst();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Pila vacía");
        }
        return list.getFirst();
    }
}