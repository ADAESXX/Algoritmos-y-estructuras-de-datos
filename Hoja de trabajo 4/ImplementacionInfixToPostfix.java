/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: Esta clase será la encargada de convertir una expresión infix a postfix
 */
public class ImplementacionInfixToPostfix implements InfixToPostfix{
    //Referencia para un stack, en el cual se realizarán todas las operaciones (VectorStack)
    private Stack<Integer> stack;
    //constructor
    public ImplementacionInfixToPostfix(Stack<Integer> stack){
        this.stack=stack;
    }

    @Override
    public String convertir(String expresion) {
        //Lista donde se almacenara la expresión contenida en el datos.txt pero como un vector, donde cada valor u operando se colocará en un espacio definido de la lista 
        String[] datos = expresion.split(" ");
        // StringBuilder es una clase que permite crear y modificar cadenas de texto de manera eficiente, es decir, es mutable, a diferencia de String que es inmutable
        StringBuilder postfix = new StringBuilder();
        for (String dato: datos) {
            if(isNumber(dato)){
                //si es un número se agrega a la expresión postfix
                postfix.append(dato).append(" ");
            }
            else{
                //si es un operador se ingresa al stack para poder usarlo posteriormente
                stack.push(0);
                postfix.append(dato).append(" ");
            }
        }
        return postfix.toString().trim();
            
    }

    public boolean isNumber(String dato){
        //permite evaluar si es un número, para ello usa regex
        return dato.matches("\\d");
    }


}
