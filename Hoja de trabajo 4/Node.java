/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 26/02/2026
 * Propósito clase: Está clase tiene como proposito ser el nodo de la lista simplemente encadenada, el cual guardará el dato y una referencia al siguiente nodo
*/
class Node<T> {
    //Dato almacenado
    T data;
    // Referencia al siguiente nodo
    Node<T> next;

    //Constructior del nodo
    Node(T data) {
        this.data = data;
        this.next = null;
    }
}