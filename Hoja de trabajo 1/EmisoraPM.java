/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 */
public class EmisoraPM {
    private float emisoraActual=530;
    public float cambiarEstacion(){

        if ((emisoraActual>=87.9)&&(emisoraActual<=107.9)){
            emisoraActual+=0.2;
        }
        else{
            emisoraActual=(float) 87.2;
        }
        return emisoraActual;
    }
}
