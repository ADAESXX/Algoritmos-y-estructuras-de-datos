/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: Esta clase es la implementación de la lista simplemente encadenada
*/
public class SinglyLinkedList<T> extends AbstractList<T> {

    //Referencia al primer nodo
    private Node<T> head;

    //constructor
    public SinglyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void addFirst(T element) {
        //Se crea el nodo con el dato
        Node<T> newNode = new Node<>(element);
        // El nuevo nodo apunta al antiguo head
        newNode.next = head;
        //ahora head se convierte en el nuevo nodo
        head = newNode;
        size++;
    }

    @Override
    public T removeFirst() {
        //si la lista está vacía
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }
        // Se guarda el dato del primer nodo
        T value = head.data;
        // head ahora apunta hacía el siguiente nodo
        head = head.next;
        size--;
        return value;
    }

    @Override
    public T getFirst() {
        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }
        //devuelve el primero sin eliminarlo
        return head.data;
    }
}