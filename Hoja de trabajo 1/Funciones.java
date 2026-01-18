
import java.util.Arrays;

/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 */
public class Funciones implements Radio{
    private String frecuencia="AM";
    private String[] botones= new String[12];
    @Override
    public void prenderRadio() {
        System.out.println("Radio encendida");
        System.out.println("Emisora actual: 530 AM ");
        frecuencia="AM";
    }

    @Override
    public void apagarRadio() {
        System.out.println("Radio apagada");
    }

    @Override
    public void avanzarEstacion() {
        float e=0.0f;
        if (frecuencia.equals("AM")){
            EmisoraAM e1= new EmisoraAM();
            e=e1.cambiarEstacion();
        }
        else{
            EmisoraFM e2= new EmisoraFM();
            e=e2.cambiarEstacion();
        }
        System.out.println("Ahora se encuentra en " + e + " " + frecuencia);
    }

    @Override
    public void guardarEstacion(int numeroBoton) {
        float e=0.0f;
        if (frecuencia.equals("AM")){
            EmisoraAM e1= new EmisoraAM();
            e=e1.estacionActual();
        }
        else{
            EmisoraFM e2= new EmisoraFM();
            e=e2.estacionActual();
        }
        botones[numeroBoton]=e+" " + frecuencia;
        System.out.println("Se guardo la estacion en el boton " + numeroBoton + ": " + botones[numeroBoton]);
        System.out.println(Arrays.toString(botones));

        
    }

    @Override
    public void cargarEstacion(int numeroBoton) {
        System.out.println("Se esta cargando la estacion " + botones[numeroBoton]);
        
    }

    @Override
    public void cambiarAM() {
        System.out.println("La frecuencia ha cambiado a AM");
        frecuencia= "AM";
    }

    @Override
    public void cambiarFM() {
        System.out.println("La frecuencia ha cambiado a FM");
        frecuencia="FM";
    }

}