/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 */
public class EmisoraAM {
    private int emisoraActual=530;
    public int cambiarEstacion(){

        if ((emisoraActual>=530)&&(emisoraActual<=1610)){
            emisoraActual+=10;
        }
        else{
            emisoraActual=530;
        }
        return emisoraActual;
    }
    public int estacionActual(){
        return emisoraActual;
    }
    public int valInicial(){
        return 530;
    }
}
