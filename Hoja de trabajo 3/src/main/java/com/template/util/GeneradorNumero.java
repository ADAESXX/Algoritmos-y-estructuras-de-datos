package com.template.util;
/**
 * @author: Abigail Escobar
 * Carne:25862
 * Fecha: 09/02/2026
 * Decripción: Esta clase se encarga de generar un arreglo de objetos Numero con valores aleatorios.
 */
import com.template.model.Numero;
import java.util.Random;

public class GeneradorNumero {
    //definimos un valor máximo para los números aleatorios

    private static final int valormax= 10000;

    public static Numero[] generarNumeros(int cantidad) {
        Random random = new Random();
        Numero[] numeros = new Numero[cantidad];

        for (int i = 0; i < cantidad; i++) {
            //generamos un número aleatorio entre 0 y MAX_VALOR-1 y lo asignamos a un nuevo objeto Numero
            numeros[i] = new Numero(random.nextInt(valormax));
        }

        return numeros;
    }
}
