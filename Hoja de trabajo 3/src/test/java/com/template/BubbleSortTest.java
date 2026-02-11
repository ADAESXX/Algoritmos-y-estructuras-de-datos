/**
 * @author Abigail Escobar
 * Carne: 25862
 * Fecha: 09/02/2026
 * 
 */
package com.template;

import com.template.model.Numero;
import com.template.sort.BubbleSort;
import com.template.sort.AlgoritmoSort;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BubbleSortTest {

    @Test
    public void testOrdenamientoBubbleSort() {

        Numero[] datos = {
                new Numero(9),
                new Numero(3),
                new Numero(7),
                new Numero(1)
        };

        AlgoritmoSort<Numero> sort = new BubbleSort<>();
        sort.sort(datos);

        for (int i = 0; i < datos.length - 1; i++) {
            assertTrue(datos[i].getValor() <= datos[i + 1].getValor());
        }
    }
}
