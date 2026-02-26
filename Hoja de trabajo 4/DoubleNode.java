/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 26/02/2026
 * Propósito clase: Nodos para la lista doblemente encadenada
*/
// Nodo para lista doblemente encadenada
class DoubleNode<T> {
    //dato 
    T data;      
    //creacion del nodo siguiente          
    DoubleNode<T> next;
    //Creacion del nodo anterior     
    DoubleNode<T> prev;

    //Constructor del nodo
    DoubleNode(T data) {
        this.data = data;
    }
}