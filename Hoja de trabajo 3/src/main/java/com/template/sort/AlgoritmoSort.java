package com.template.sort;
/**
 * @author: Abigail Escobar
 * Carne: 25862
 * Fecha de entrega: 13/02/2026
 * Descripción: interfaz AlgoritmoSort que define el método sort para ordenar un arreglo de objetos de tipo T que implementan la interfaz Comparable.
 */
public interface AlgoritmoSort<T extends Comparable<T>> {
    //método para ordenar un arreglo de objetos de tipo T (en este caso T son enteros según la guía)
    void sort(T[] array);
}
