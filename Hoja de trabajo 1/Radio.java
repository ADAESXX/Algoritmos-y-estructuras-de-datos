/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 *
 * Interface que define que puede hacer el radio
 */
public interface Radio{
    void prenderRadio();
    void apagarRadio();
    void avanzarEstacion();
    void guardarEstacion(int numeroBoton);
    void cargarEstacion(int numeroBoton);
    void cambiarAM();
    void cambiarFM();
}