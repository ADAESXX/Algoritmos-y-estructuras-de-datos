import java.util.Scanner;
public class Principalconsola {
    public static void main(String[] args) {

        Scanner teclado=new Scanner(System.in);

        Radio radio=new Funciones();
        String menu="Por favor seleccione alguna de las opciones del menu\n1.Prender el radio\n2.Cambia de AM a FM a AM\n3.Avanzae en el dial de las emisoras (cuando llegue al final vuelve al inicio)\n4.Guardar emisora\n5.Seleccionar emisora\n6.Apagar radio\n7.Salir del menu";
        
        String frecuencia= "AM";
        
        System.out.println(menu);
        int opcion=teclado.nextInt();
        while ((opcion>0)&& (opcion<7)){
            if (opcion==1){
                radio.prenderRadio();
            }
            if (opcion==2){
        
                if(frecuencia.equals("AM")){
                    radio.cambiarFM();
                    frecuencia="FM";
                }
                else{
                    radio.cambiarAM();
                    frecuencia="AM";
                }
                }
            
            if (opcion==3){
                radio.avanzarEstacion();
            }
            if (opcion==4){
                System.out.println("¿En qué boton desea guardar la emisora? (1-12)");
                int numboton=teclado.nextInt();
                if ((numboton<13)&&(numboton>0)){
                    radio.guardarEstacion(numboton);
                }
            }
            if (opcion==5){
                System.out.println("¿Qué boton desea seleccionar? (1-12)");
                int numboton=teclado.nextInt();
                if ((numboton<13)&&(numboton>0)){
                    radio.cargarEstacion(numboton);
                }
            }
            if (opcion==6){
                radio.apagarRadio();
            }

        }
        System.out.println("Usted ha salido del menú, ¡que tenga feliz día!");

    }
}
