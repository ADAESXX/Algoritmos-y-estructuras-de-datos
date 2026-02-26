/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 26/02/2026
 * Propósito clase: Clase abstracta que se puede usar como base para cualquier tipo de stack
*/
public abstract class AbstractStack<T> implements Stack<T> {
    // Aquí se pueden implementar métodos comunes a todas las pilas, si es necesario
    protected int size;
    @Override
    public int size() {
        return size;
    }
    
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    
}
