/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 26/02/2026
 * Propósito clase: Clase que implementa la lista doblemente encadenada
*/
public class DoublyLinkedList<T> extends AbstractList<T> {
    //Nodo
    private DoubleNode<T> head;
    //Constructor
    public DoublyLinkedList() {
        head = null;
        size = 0;
    }

    @Override
    public void addFirst(T element) {
        
        DoubleNode<T> newNode = new DoubleNode<>(element);

        // El nuevo nodo apunta al antiguo head
        newNode.next = head;

        // Si ya había nodos, el antiguo head apunta hacia atrás
        if (head != null) {
            head.prev = newNode;
        }

        // head ahora es el nuevo nodo
        head = newNode;

        size++;
    }

    @Override
    public T removeFirst() {

        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        T value = head.data;

        // Avanzamos head
        head = head.next;

        // Si no es null, quitamos referencia hacia atrás
        if (head != null) {
            head.prev = null;
        }

        size--;

        return value;
    }

    @Override
    public T getFirst() {

        if (isEmpty()) {
            throw new RuntimeException("Lista vacía");
        }

        return head.data;
    }
}