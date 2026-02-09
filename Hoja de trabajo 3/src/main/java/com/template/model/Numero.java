/**
 * @author: Abigail Escobar
 * Carne: 25862
 * Fecha de entrega: 13/02/2026
 * Descripción: Esta clase representa un número entero y proporciona métodos para comparar y representar el número como una cadena.
 */
package com.template.model;

public class Numero implements Comparable<Numero> {

    //atributo para almacenar el valor del número
    private int valor;

    public Numero(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    //método para comparar este número con otro número, para determinar su orden
    public int compareTo(Numero otro) {
        return Integer.compare(this.valor, otro.valor);
    }

    @Override
    public String toString() {
        return String.valueOf(valor);
    }
}
