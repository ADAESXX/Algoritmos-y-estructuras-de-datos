/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: Esta clase será la encargada de convertir una expresión infix a postfix
 */
public class ImplementacionInfixToPostfix implements InfixToPostfix{
    //Referencia para un stack, en el cual se realizarán todas las operaciones (VectorStack)
    private Stack<String> stack;
    //constructor
    public ImplementacionInfixToPostfix(Stack<String> stack){
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
            else if(dato.equals("(")){
                //si es un paréntesis de apertura se agrega al stack
                stack.push(dato);
            }
            else if(dato.equals(")")){
                //si es un paréntesis de cierre se sacan los elementos del stack hasta encontrar el paréntesis de apertura, y se agregan a la expresión postfix
                while (!stack.peek().equals("(")){
                    postfix.append(stack.pop()).append(" ");
                }
                //se elimina el paréntesis de apertura del stack
                stack.pop();
            }
            else{
                //si es operador
                while (stack.size()>0 && precedencia(stack.peek())>=precedencia(dato)){
                    postfix.append(stack.pop()).append(" ");
                }
                stack.push(dato);
            }
        }
        //se sacan los elementos restantes del stack y se agregan a la expresión postfix
        while (stack.size()>0){
            postfix.append(stack.pop()).append(" ");
        }
        return postfix.toString().trim();
    }

    public boolean isNumber(String dato){
        //permite evaluar si es un número, para ello usa regex
        return dato.matches("\\d+");
    }

    //basicamente asigna un valor de precedencia a cada operador, para poder comparar entre ellos y saber cuál se debe colocar primero en la expresión postfix
    private int precedencia(String operador) {
        return switch (operador) {
            case "+", "-" -> 1;
            case "*", "/" -> 2;
            default -> 0;
        };
        
    }


}
