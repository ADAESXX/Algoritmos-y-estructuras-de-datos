import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class HojaTrabajo2Test {

    @Test
    public void testPushPopStack() {
        Stack<Integer> stack = new VectorStack<>();
        stack.push(10);
        stack.push(20);

        assertEquals(20, stack.pop());
        assertEquals(10, stack.pop());
    }

    @Test
    public void testCalculoPostfix() {
        Stack<Integer> stack = new VectorStack<>();
        CalculadorPostfix calc = new ImplementacionCalculadora(stack);

        assertEquals(7, calc.calcular("3 4 +"));
    }
}
