/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 */
public class Funciones implements Radio{
    private String frecuencia="AM";
    private String[] estacion= new String[12];
    @Override
    public void prenderRadio() {
        System.out.println("Radio encendida");
        System.out.println("Emisora actual: 530 AM ");
    }

    @Override
    public void apagarRadio() {
        System.out.println("Radio apagada");
    }

    @Override
    public void avanzarEstacion() {
        if (frecuencia.equals("AM")){
            EmisoraAM e1= new EmisoraAM();
            e1.cambiarEstacion();
        }
        else{
            EmisoraPM e2= new EmisoraPM();
            e2.cambiarEstacion();
        }
    }

    @Override
    public void guardarEstacion(int numeroBoton) {
        

        
        
    }

    @Override
    public void cargarEstacion(int numeroBoton) {
        // TODO Auto-generated method stub
        
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