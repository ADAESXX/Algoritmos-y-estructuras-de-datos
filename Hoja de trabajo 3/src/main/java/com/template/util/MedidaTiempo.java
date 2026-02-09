package com.template.util;

public class MedidaTiempo {
    //Runnable sirve para representar cualquier algoritmo que queramos medir, ya que tiene un método run() que se puede implementar con el código del algoritmo (ayuda de chatGPT sobre cómo usarlo))
    public static long medir(Runnable algoritmo) {
        //se obtiene el tiempo inicial mientras se ejecuta el algoritmo
        long inicio = System.nanoTime();
        //se ejecuta el algoritmo que se le pasó como parámetro
        algoritmo.run();
        //se obtiene el tiempo final después de que el algoritmo ha terminado de ejecutarse
        long fin = System.nanoTime();
        //Tiempo en el que se ejecuto el algoritmo
        return fin - inicio;
    }
}
