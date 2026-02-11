/**
 * @author Abigail Escobar
 * Carne: 25862
 * Fecha: 09/02/2026
 * Descripción: Prueba unitaria para el algoritmo de ordenamiento Gnome Sort.
 */

package com.template;

import com.template.model.Numero;
import com.template.sort.GnomeSort;
import com.template.sort.AlgoritmoSort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class GnomeSortTest {

    @Test
    public void testOrdenamientoGnomeSort() {

        Numero[] datos = {
                new Numero(5),
                new Numero(1),
                new Numero(4),
                new Numero(2),
                new Numero(8)
        };

        AlgoritmoSort<Numero> sort = new GnomeSort<>();
        sort.sort(datos);

        for (int i = 0; i < datos.length - 1; i++) {
            assertTrue(
                datos[i].getValor() <= datos[i + 1].getValor(),
                "El arreglo no está ordenado"
            );
        }
    }
}
