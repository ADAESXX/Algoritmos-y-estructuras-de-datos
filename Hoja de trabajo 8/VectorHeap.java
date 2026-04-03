
import java.util.ArrayList;

/*
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 02/04/2026
 * Propósito clase: Clase VectorHeap, que implementará un heap utilizando un vector para almacenar los elementos. Este heap se utilizará para almacenar objetos de la clase Paciente y ordenarlos por prioridad de atención utilizando el código de emergencia.
 */

//comparable se usa para definir el orden de los objetos en el heap
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E> {
    //atributo
    private ArrayList<E> data;
    //constructor
    public VectorHeap() {
        this.data = new ArrayList<>();
    }

    public void add(E value){
        data.add(value);
        //se obtiene el índice del último elemento agregado, que es el que se acaba de insertar
        int childIndex =data.size()-1;
        //se obtiene el índice del padre del elemento agregado, utilizando la fórmula (childIndex-1)/2 (presentacion de clase)
        int parentIndex = (childIndex-1)/2;
        //si el indice del padre es mayor o igual a 0, es decir, si el padre existe
        while (parentIndex >= 0) { 
            //se compara el elemento agregado con su padre, utilizando el método compareTo de la interfaz Comparable
            if (data.get(childIndex).compareTo(data.get(parentIndex)) < 0) {
                //si el elemento agregado es menor que su padre, se intercambian los elementos en el vector
                E temp = data.get(childIndex);
                data.set(childIndex, data.get(parentIndex));
                data.set(parentIndex, temp);
                //se actualizan los índices del hijo y del padre para continuar comparando hacia arriba en el heap
                childIndex = parentIndex;
                parentIndex = (childIndex-1)/2;
            } else {
                //si el elemento agregado no es menor que su padre, se detiene el proceso de comparación
                break;
            }
        }
    }

    public E poll(){
        //si el heap no está vacío, se devuelve el elemento en la raíz del heap, que es el elemento con mayor prioridad
        if (!data.isEmpty()) {
            E result = data.get(0);
            //se reemplaza el elemento en la raíz del heap con el último elemento del vector
            data.set(0, data.get(data.size() - 1));
            //se elimina el último elemento del vector
            data.remove(data.size() - 1);
            //se obtiene el índice del hijo izquierdo del elemento en la raíz del heap, utilizando la fórmula 2*index+1 (presentacion de clase)
            int index = 0;
            int leftChildIndex = 2 * index + 1;
            //mientras el índice del hijo izquierdo sea menor que el tamaño del vector, es decir, mientras existan hijos
            while (leftChildIndex < data.size()) {
                //se obtiene el índice del hijo derecho del elemento en la raíz del heap, utilizando la fórmula 2*index+2 (presentacion de clase)
                int rightChildIndex = leftChildIndex + 1;
                //se compara el hijo izquierdo con el hijo derecho para determinar cuál tiene mayor prioridad
                if (rightChildIndex < data.size() && data.get(rightChildIndex).compareTo(data.get(leftChildIndex)) < 0) {
                    leftChildIndex = rightChildIndex;
                }
                //se compara el elemento en la raíz del heap con el hijo que tiene mayor prioridad
                if (data.get(index).compareTo(data.get(leftChildIndex)) > 0) {
                    //si el elemento en la raíz del heap es mayor que su hijo, se intercambian los elementos en el vector
                    E temp = data.get(index);
                    data.set(index, data.get(leftChildIndex));
                    data.set(leftChildIndex, temp);
                    //se actualiza el índice para continuar comparando hacia abajo en el heap
                    index = leftChildIndex;
                    leftChildIndex = 2 * index + 1;
                } else {
                    //si el elemento en la raíz del heap no es mayor que su hijo, se detiene el proceso de comparación
                    break;
                }
            }
            return result;
        }
        return null;
    }
    
    
    public E peek() {
        //si el heap no está vacío, se devuelve el elemento en la raíz del heap, que es el elemento con mayor prioridad
        if (!data.isEmpty()) {
            return data.get(0);
        }
        return null;
    }

}