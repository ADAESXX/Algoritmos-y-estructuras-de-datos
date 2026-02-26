/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 26/02/2026
 * Propósito clase: Clase abstracta que se puede usar como base para cualquier tipo de stack utilizando listas
*/
public abstract class AbstractList<T> implements List<T> {

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