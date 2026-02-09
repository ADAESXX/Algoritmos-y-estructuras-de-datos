package com.template.sort;
/**
 * @author: Abigail Escobar
 * Carne: 25862
 * Fecha de entrega: 13/02/2026
 * Descripción: Implementación del algoritmo de ordenamiento Quick Sort para ordenar un arreglo de objetos de tipo T que implementan la interfaz Comparable.
 */
public class QuickSort<T extends Comparable<T>> implements AlgoritmoSort<T> {

    @Override
    public void sort(T[] array) {
        quickSort(array, 0, array.length - 1);
    }

    //Dividide el arreglo en dos partes y ordena cada parte de forma recursiva
    private void quickSort(T[] array, int low, int high) {
        if (low < high) {
            int pi = partition(array, low, high);
            quickSort(array, low, pi - 1);
            quickSort(array, pi + 1, high);
        }
    }
    //sirve para escoger a un elemento clave y organizr los elementos (menores a la izquierda y mayores a la derecha)
    private int partition(T[] array, int low, int high) {
        //se escoge el último elemento como pivote
        T pivot = array[high];
        //se inicializa un índice para el elemento más pequeño
        int i = low - 1;
        //Se recorre el arreglo desde el primer elemento hasta el penúltimo elemento, comparando cada elemento con el pivote
        for (int j = low; j < high; j++) {
            if (array[j].compareTo(pivot) <= 0) {
                i++;
                T temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        T temp = array[i + 1];
        array[i + 1] = array[high];
        array[high] = temp;

        return i + 1;
    }
}
