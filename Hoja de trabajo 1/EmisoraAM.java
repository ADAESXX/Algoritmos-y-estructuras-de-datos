/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 * 
 * Controla las actividades especificas de la emidora AM (modelo)
 */
public class EmisoraAM {
    private int emisoraActual=530;

    public int avanzar(){
        emisoraActual+=10;
        if (emisoraActual>1610){
            emisoraActual=530;
        }
        return emisoraActual;
    }
    public int estacionActual(){
        return emisoraActual;
    }
    public void setActual(int valor){
        emisoraActual=valor;
    }
}
