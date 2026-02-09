package com.template.sort;
/**
 * @author: Abigail Escobar
 * Carne: 25862
 * Fecha de entrega: 13/02/2026
 * Descripción: Implementación del algoritmo de ordenamiento Bubble Sort para ordenar un arreglo de objetos de tipo T que implementan la interfaz Comparable.
 */
public class BubbleSort<T extends Comparable<T>> implements AlgoritmoSort<T> {

    @Override
    public void sort(T[] array) {
        //indica si se hizo un intercambio
        boolean swapped;
        // recorre el arreglo
        for (int i = 0; i < array.length - 1; i++) {
            swapped = false;
            //compara cada elemento con el siguiente y los intercambia si están en el orden incorrecto
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j].compareTo(array[j + 1]) > 0) {
                    T temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }
}
