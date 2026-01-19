/**
 * @author Abigail Escobar (25862)
 * @author Paola Merida (251613)
 * @date 16/1/2026
 * 
 * Parte visual de MVC (vista), la cual permite interactuar con el usuario
 */
import java.util.Scanner;
public class Principalconsola {
    public static void main(String[] args) {
        //permite interactuar con el usuario en la consola
        Scanner teclado=new Scanner(System.in);

        //instancia de radio, especificamente Funciones
        Radio radio=new Funciones();
        String menu="*******************************************************************************\nPor favor seleccione alguna de las opciones del menu\n1.Prender el radio\n2.Cambia de AM a FM a AM\n3.Avanzar en el dial de las emisoras (cuando llegue al final vuelve al inicio)\n4.Guardar emisora\n5.Seleccionar emisora\n6.Apagar radio\n*******************************************************************************";
        String frecuencia= "AM";
        //opcion que ek usuario escogerá
        int opcion=0;
        while (opcion!=6){
            System.out.println(menu);
            opcion=teclado.nextInt();

            //casos, es decir, se realizará la acción correspondiente a la opcion numerica que el usuario escogio
            switch (opcion) {
                case 1 -> {
                    radio.prenderRadio();
                    frecuencia="AM";
                }
                case 2 -> {
                    if(frecuencia.equals("AM")){
                        radio.cambiarFM();
                        frecuencia="FM";
                    }
                    else{
                        radio.cambiarAM();
                        frecuencia="AM";
                    }
                }
                case 3 -> radio.avanzarEstacion();
                case 4 -> {
                    System.out.println("¿En qué boton desea guardar la emisora? (1-12)");
                    int numbotong=teclado.nextInt();
                    if ((numbotong<13)&&(numbotong>0)){
                        radio.guardarEstacion(numbotong);
                    }
                    else{
                        System.out.println("Ese boton no existe, por lo que no se guardo");
                    }
                }
                case 5 -> {
                    System.out.println("¿Qué boton desea seleccionar? (1-12)");
                    int numbotonc=teclado.nextInt();
                    if ((numbotonc<13)&&(numbotonc>0)){
                        radio.cargarEstacion(numbotonc);
                    }
                    else{
                        System.out.println("Ese boton no existe, por lo que no se puede cargar nada");
                    }
                }
                case 6 -> radio.apagarRadio();
                default -> System.out.println("Usted escogio una opcion invalida, pruebe de nuevo");
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