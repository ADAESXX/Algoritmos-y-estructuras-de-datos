/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha:25/02/2026
 * Propósito clase: ADT, es decir clase abstracta con la que el programa podra implementar cualquier programa que controle la calculadora de postfix
 *  
 */
public interface CalculadorPostfix {
    // método abstracto para poder evaluar la expresión postfix
    int calcular(String expresion);
}
