import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * Pruebas diseñadas para FALLAR intencionalmente
 */
public class HojaTrabajo2FailTest {

    @Test
    public void testFalloResultadoIncorrecto() {
        Stack<Integer> stack = new VectorStack<>();
        CalculadorPostfix calc = new ImplementacionCalculadora(stack);

        // Esta prueba está hecha para FALLAR
        assertEquals(10, calc.calcular("3 4 +"));
    }
}
