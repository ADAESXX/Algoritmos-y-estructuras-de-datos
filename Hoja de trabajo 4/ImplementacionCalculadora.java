/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 25/02/2026
 * Propósito clase: esta clase será la encargada de pasar la operación String a número operables. Para ello los convertirá al tipo Integer y los ingresará y sacará del stack para poder operarlos.
 *  
 */
public class ImplementacionCalculadora implements CalculadorPostfix{
    @SuppressWarnings("FieldMayBeFinal")
    //Referencia para un stack, en el cual se realizarán todas las operaciones (VectorStack)
    private Stack<Integer> stack;
    //constructor
    public ImplementacionCalculadora(Stack<Integer> stack){
        this.stack=stack;
    }

    @Override
    public int calcular(String expresion) {
        //Lista donde se almacenara la expresión contenida en el datos.txt pero como un vector, donde cada valor u operando se colocará en un espacio definido de la lista (para saber cuando separarlos debe estar separado por un espacio)
        String[] datos = expresion.split(" ");
        for (String dato: datos) {
            if(isNumber(dato)){
                //ingresamos cada operando y operador al stack
                stack.push(Integer.valueOf(dato));
            }
            else{
                // en caso de que sea un operando se usan los ultimos dos numeros ingresados al stack para hacer la operacion correspondiente
                int b=stack.pop();
                int a= stack.pop();
                int resultado=operar(a,b,dato);
                //se ingresa el resultado al stack para poder continuar con las operaciones restantes
                stack.push(resultado);
            }
        }
        //retorna el resultado final
        return stack.pop();
    }

    public boolean isNumber(String dato){
        //permite evaluar si es un número, para ello usa regex
        return dato.matches("\\d+");
    }

    public int operar(int a, int b, String operador){
        //según el tipo de operando que se requiera, será el tipo de proceso que se realizará
        switch (operador) {
            case "+" -> {
                return a+b;
            }
            case "-" -> {
                return a-b;
            }
            case "*" -> {
                return a*b;
            }
            case "/" -> {
                if(b==0){
                    throw new ArithmeticException("Divisióm entre cerp");
                }
                else{
                    return a/b;
                }
            }
                    
            default -> throw new AssertionError();
        }
    }
}
