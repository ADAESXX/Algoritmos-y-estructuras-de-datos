package com.template.util;
/**
 * @author: Abigail Escobar
 * Carne:25862
 * Fecha: 09/02/2026
 * Descripción: Esta clase se encarga de manejar la lectura y escritura de archivos para objetos Numero (en el caso de la guía dice enteros)
 */

import com.template.model.Numero;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    public static void guardarEnArchivo(String ruta, Numero[] numeros) throws IOException {
        //usamos try-with-resources para asegurar que el BufferedWriter se cierre automáticamente (guía de como hacerlo en google)
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(ruta))) {
            for (Numero n : numeros) {
                //escribimos el valor del número en el archivo seguido de un salto de línea. para así poder leerlo más facilmente
                writer.write(String.valueOf(n.getValor()));
                writer.newLine();
            }
        }
    }

    public static Numero[] leerDesdeArchivo(String ruta) throws IOException {
        //se almacenan los números leídos en una lista temporal (así vamos a saber el número que debe tener el arreglo final)
        List<Numero> lista = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                lista.add(new Numero(Integer.parseInt(linea)));
            }
        }
        //retorna el arreglo de objetos numero
        return lista.toArray(Numero[]::new);
    }
}
