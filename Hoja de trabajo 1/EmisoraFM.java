/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 */
public class EmisoraFM {
    private float emisoraActual=87.9f;

    public float cambiarEstacion(){

        if ((emisoraActual>=87.9)&&(emisoraActual<=107.9)){
            emisoraActual+=0.2;
        }
        else{
            emisoraActual=(float) 87.9;
        }
        return emisoraActual;
    }
    public float estacionActual(){
        return emisoraActual;
    }
    public float valInicial(){
        return 87.9f;
    }
}
