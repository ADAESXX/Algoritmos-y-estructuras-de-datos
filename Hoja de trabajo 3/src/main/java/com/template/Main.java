package com.template;
/**
 * @author: Abigail Escobar
 * Carne:25862  
 * Fecha: 09/02/2026
 * Descripción: Esta clase es el punto de entrada del programa, donde se generan los números
 */
import com.template.model.Numero;
import com.template.sort.*;
import com.template.util.FileManager;
import com.template.util.GeneradorNumero;
import com.template.util.MedidaTiempo;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    //archivo donde se guardaran los numeros
    private static final String archivo = "numeros.txt";

    public static void main(String[] args) throws IOException {

        //definimos los tamaños de los arreglos que se van a generar para probar los algoritmos de ordenamiento
        int[] tamanios = {10, 100, 500, 1000, 2000, 3000};
        //Esto permitirá probar cada algoritmo con diferentes tamaños de entrada y observar cómo varía su rendimiento a medida que aumenta el número de elementos a ordenar
        AlgoritmoSort<Numero>[] algoritmos = new AlgoritmoSort[]{
                new GnomeSort<>(),
                new BubbleSort<>(),
                new MergeSort<>(),
                new QuickSort<>(),
                new RadixSort()
        };
        // Iteramos sobre cada tamaño definido
        for (int n : tamanios) {

            System.out.println("\n--------------------------------Tamaño: " + n + "--------------------------------");

            // Generar números
            Numero[] originales = GeneradorNumero.generarNumeros(n);

            // se guarda en archivo
            FileManager.guardarEnArchivo(archivo, originales);

            // Leer del archivo
            Numero[] datosArchivo = FileManager.leerDesdeArchivo(archivo);

            for (AlgoritmoSort<Numero> sort : algoritmos) {

                // Hacemos una copia para cada sort, para que cada algoritmo trabaje con los mismos datos y así tener una comparación adecuada
                Numero[] copia = Arrays.copyOf(datosArchivo, datosArchivo.length);
                // Peor caso: desordenado
                long tiempoDesordenado = MedidaTiempo.medir(() -> sort.sort(copia));

                // Mejor caso: ya ordenado
                long tiempoOrdenado = MedidaTiempo.medir(() -> sort.sort(copia));

                // Imprimimos los resultados para cada algoritmo y tamaño, mostrando el tiempo que tomó ordenar tanto en el caso desordenado como en el caso ya ordenado
                System.out.println(sort.getClass().getSimpleName());
                System.out.println("  Desordenado (ns): " + tiempoDesordenado);
                System.out.println("  Ordenado (ns):    " + tiempoOrdenado);
            }
        }
    }
}


