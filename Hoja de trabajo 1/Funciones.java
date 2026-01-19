
import java.util.Arrays;

/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 * 
 * Implementación del radio
 */
public class Funciones implements Radio{
    //permite comprobar si la radio esta encendida o no
    private boolean encendido=false;
    //la frecuencia cambiará a la largo del programa, pero se inicializa como AM
    private String frecuencia="AM";

    //instancia de la emisora AM y FM
    private EmisoraFM fm= new EmisoraFM();
    private EmisoraAM am= new EmisoraAM();

    //Array donde se guardarán las emisoras que el usuario desee
    private String[] botones= new String[12];

    @Override
    public void prenderRadio() {
        encendido=true;
        frecuencia="AM";
        System.out.println("Radio encendida en 530 AM");
        
    }

    @Override
    public void apagarRadio() {
        //comprueba si esta prendido o no (lo mismo sucede con el resto de metodos)
        if (!encendido){
            System.out.println("Usted no ha encendido el Radio, por lo que ya esta apagado");
            return;
        }
        encendido=false;
        System.out.println("Radio apagada");
    }

    @Override
    public void avanzarEstacion() {
        if (!encendido){
            System.out.println("Usted no ha encendido el Radio");
            return;
        }
        
        if (frecuencia.equals("AM")){
            System.out.println(am.avanzar()+ " AM");
        }
        else{
            System.out.println(fm.avanzar()+ " FM");
        }
    }

    @Override
    public void guardarEstacion(int numeroBoton) {
        if (!encendido){
            System.out.println("Usted no ha encendido el Radio");
            return;
        }

        if (frecuencia.equals("AM")){
            //almacena la emisora en el boton que el usuario selecciono
            botones[numeroBoton-1]=am.estacionActual() + " AM";
        }
        else{
            botones[numeroBoton-1]=am.estacionActual() + " FM";
        }
        System.out.println("Se guardo la estacion en el boton " + numeroBoton + ": " + botones[numeroBoton-1]);
        System.out.println(Arrays.toString(botones));

        
    }

    @Override
    public void cargarEstacion(int numeroBoton) {
        if (!encendido){
            System.out.println("Usted no ha encendido el Radio");
            return;
        }
        //unicamente carga si el usuario si guardo una emisora en el boton que desea cargar
        if (botones[numeroBoton-1]!=null){
            System.out.println("Se esta cargando la estacion " + botones[numeroBoton-1]);
        }
        else{
            System.out.println("Boton vacio");
        }
        
    }

    @Override
    public void cambiarAM() {
        if (!encendido){
            System.out.println("Usted no ha encendido el Radio");
            return;
        }
        System.out.println("La frecuencia ha cambiado a AM");
        frecuencia= "AM";
    }

    @Override
    public void cambiarFM() {if (!encendido){
            System.out.println("Usted no ha encendido el Radio");
            return;
        }
        System.out.println("La frecuencia ha cambiado a FM");
        frecuencia="FM";
    }

}