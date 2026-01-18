import java.util.Scanner;
public class Principalconsola {
    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        Radio radio=new Funciones();
        String menu="Por favor seleccione alguna de las opciones del menu\n1.Prender el radio\n2.Cambia de AM a FM a AM\n3.Avanzae en el dial de las emisoras (cuando llegue al final vuelve al inicio)\n4.Guardar emisora\n5.Seleccionar emisora\n6.Apagar radio";
        String frecuencia= "AM";
    
        int opcion=0;
        while (opcion!=6){
            System.out.println(menu);
            opcion=teclado.nextInt();

            switch (opcion) {
                case 1:
                    radio.prenderRadio();
                    frecuencia="AM";
                    break;
                case 2:
                    if(frecuencia.equals("AM")){
                        radio.cambiarFM();
                        frecuencia="FM";
                    }
                    else{
                        radio.cambiarAM();
                        frecuencia="AM";
                    }
                    break;
                case 3:
                    radio.avanzarEstacion();
                    break;
                case 4:
                    System.out.println("¿En qué boton desea guardar la emisora? (1-12)");
                    int numbotong=teclado.nextInt();
                    if ((numbotong<13)&&(numbotong>0)){
                        radio.guardarEstacion(numbotong);
                    }
                    break;
                case 5:
                    System.out.println("¿Qué boton desea seleccionar? (1-12)");
                    int numbotonc=teclado.nextInt();
                    if ((numbotonc<13)&&(numbotonc>0)){
                        radio.cargarEstacion(numbotonc);
                    }
                    break;
                case 6:
                    radio.apagarRadio();
                    break;
                default:
                    System.out.println("Usted escogio una opcion invalida, pruebe de nuevo");
                    break;
            }


        }
        if (opcion==6) {
            System.out.println("Usted ha salido del menú, ¡que tenga feliz día!");
        }
        else{
            throw new AssertionError();
        }
        

    }
}