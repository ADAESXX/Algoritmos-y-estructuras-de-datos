/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 * 
 * Controla las acciones de la emisoraFM (modelo)
 */
public class EmisoraFM {
    //valor inicial en el dial de FM
    private float emisoraActual=87.9f;

    public float avanzar(){
        emisoraActual+=0.2f;
        if (emisoraActual>107.9f){
            emisoraActual=87.9f;
        }
        return emisoraActual;
    }
    public float estacionActual(){
        return emisoraActual;
    }
    public void setActual(int valor){
        emisoraActual=valor;
    }
}
