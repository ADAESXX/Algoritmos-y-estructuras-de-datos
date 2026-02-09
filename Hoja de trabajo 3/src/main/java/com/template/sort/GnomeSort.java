package com.template.sort;
/**
 * @author: Abigail Escobar
 * Carne: 25862
 * Fecha de entrega: 13/02/2026
 * Descripción: Implementación del algoritmo de ordenamiento Gnome Sort para ordenar un arreglo de objetos de tipo T que implementan la interfaz Comparable.
 */
public class GnomeSort<T extends Comparable<T>> implements AlgoritmoSort<T> {

    @Override
    public void sort(T[] array) {
        int index = 0;

        while (index < array.length) {
            if (index == 0) {
                index++;
            //si el elemento actual es mayor o igual al elemento anterior, se mueve al siguiente elemento
            } else if (array[index].compareTo(array[index - 1]) >= 0) {
                index++;
            //si el elemento actual es menor que el elemento anterior, se intercambian los elementos y se mueve al elemento anterior para comparar nuevamente
            } else {
                T temp = array[index];
                array[index] = array[index - 1];
                array[index - 1] = temp;
                index--;
            }
        }
    }
}
