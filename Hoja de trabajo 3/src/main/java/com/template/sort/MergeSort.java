package com.template.sort;
/**
 * @author: Abigail Escobar
 * Carne: 25862
 * Fecha de entrega: 13/02/2026
 * Descripción: Implementación del algoritmo de ordenamiento Merge Sort para ordenar un arreglo de objetos de tipo T que implementan la interfaz Comparable.
 */

import java.util.Arrays;

public class MergeSort<T extends Comparable<T>> implements AlgoritmoSort<T> {

    @Override
    public void sort(T[] array) {
        //si el arreglo tiene menos de 2 elementos, ya está ordenado
        if (array.length < 2) return;
        //se divide el arreglo en dos mitades, para luego ordenar cada mitad de forma recursiva y finalmente combinar las mitades ordenadas
        int mid = array.length / 2;

        T[] left = Arrays.copyOfRange(array, 0, mid);
        T[] right = Arrays.copyOfRange(array, mid, array.length);

        //lo hace de manera recursiva, es decir hasta que cada mitad tenga menos de 2 elmentos
        sort(left);
        sort(right);
        merge(array, left, right);
    }

    private void merge(T[] result, T[] left, T[] right) {
        int i = 0, j = 0, k = 0;
        //compara los elementos de los dos arreglos para saber cual es el menor y cual el mayor para colocarlo en un arreglo
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) result[k++] = left[i++];
        while (j < right.length) result[k++] = right[j++];
    }
}
