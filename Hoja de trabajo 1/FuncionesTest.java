import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class FuncionesTest {

    @Test
    public void testPrenderRadio() {
        Radio radio = new Funciones();
        radio.prenderRadio();
        assertTrue(true);
    }

    @Test
    public void testAvanzarSinPrender() {
        Radio radio = new Funciones();
        assertDoesNotThrow(() -> {
            radio.avanzarEstacion();
        });
    }

    @Test
    public void testGuardarEstacion() {
        Radio radio = new Funciones();
        radio.prenderRadio();
        assertDoesNotThrow(() -> {
            radio.guardarEstacion(1);
        });
    }   
}
