/**
 * @author: Abigail Escobar
 * Carne: 25862
 * Fecha de entrega: 13/02/2026
 * Descripción: Esta clase implementa el algoritmo de ordenamiento Radix Sort para ordenar un arreglo de objetos de tipo Numero.
 */
package com.template.sort;

import com.template.model.Numero;

public class RadixSort implements AlgoritmoSort<Numero> {

    @Override
    //método para ordenar el arreglo de objetos enteros utilizando el algoritmo Radix Sort
    public void sort(Numero[] array) {
        int max = getMax(array);
        //Radix Sort ordena los números según cada dígito, comenzando por el dígito menos significativo hasta el más significativo (unidades, decenas, centenas, etc.) por eso se utiliza un bucle que itera sobre cada dígito del número máximo
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(array, exp);
        }
    }
    //para este método se necesita encontrar el número máximo en el arreglo para determinar el número de dígitos que se deben ordenar
    private int getMax(Numero[] array) {
        int max = array[0].getValor();
        for (Numero n : array) {
            if (n.getValor() > max) {
                max = n.getValor();
            }
        }
        return max;
    }

    //Radix Sort usa un método de conteo para ordenar los números según cada dígito, comenzando por el dígito menos significativo hasta el más significativo (unidades, decenas, centenas, etc.)
    private void countSort(Numero[] array, int exp) {
        int n = array.length;
        //arreglo de salida para almacenar los números ordenados temporalmente
        Numero[] output = new Numero[n];
        //arreglo de conteo para contar la cantidad de ocurrencias de cada dígito (0-9)
        int[] count = new int[10];
        
        for (Numero num : array) {
            //incrementa el conteo del digito 
            count[(num.getValor() / exp) % 10]++;
        }
        //actualiza el arreglo para que se obtenga la posición correcta de cada dígito en el arreglo de salida
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (array[i].getValor() / exp) % 10;
            output[count[digit] - 1] = array[i];
            count[digit]--;
        }
        //copia el arreglo de salida al arreglo original para que contenga los números ordenados según el dígito actual
        System.arraycopy(output, 0, array, 0, n);
    }
}
