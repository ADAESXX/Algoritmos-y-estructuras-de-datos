#Nombre del programador: Allyson Dulce Abigail Escobar Sandoval
#Nombre del programa: SimulacionProcesos.py
#Fecha de creacion: 3/3/2026
#Lenguaje: Python
#Version de python: 3.11.9
#Version SimPy: 4.1.1
#Objetivos: simulacion DES (Discrete Event Simulation) y uso de colas con Resources y Container, todo ello con el modulo SimPy
#-----------------------------------------------------------------------------------------------------------------------------------------
#Descripcion del programa: 
    #Elemetos clave:
        #CPU
        #RAM
        #Colas
        #Procesos
    #Flujo:
        #Llega el proceso (new)
        #Pide Ram suficiente en el sistema operativo
        #En caso positivo obtiene el espacio de memoria solicitado (RAM), de lo contrario espera en la cola hasta que este el espacio
        #Espera a ser "atendido" por el CPU y define el número de instrucciones que debe de hacer(ready)
        #El CPU ejecuta 3 instrucciones (running)
            #si termina se libera RAM y sale del sistema operativo
            #Si no puede tomar dos caminos: si necesita ir al I/O va a waiting y luego a ready, si no necesita ir pasa de una vez a ready
        #Vuelve a esperar CPU
    #Para ello necesito:
        #Generar procesos (en intervalos exponenciales)
        #Evaluar procesos individuales
            #new
                #Tiempo de llegada
                #Genera memoria (1-10)
                #obtiene la cantidad de memoria
            #ready
                #solicita CPU
            #Running
                #ejecuta 3 instrucciones
            #---Decision clave---
                #si todavía faltan instrucciones (1= waiting, 2=ready, esto se hace de manera aleatoria entre el 1-21)
            #Terminated
                #Guarda el tiempo de ejecución (el que se creo en new con el proceso individual)
                
#-----------------------------------------------------------------------------------------------------------------------------------------        
        

import simpy
import random
import statistics
import matplotlib.pyplot as plt
#Generar procesos
def generar_procesos(env, numeroProcesos, intervalo, RAM, CPU, velocidadCPU, tiempos):
    for i in range(numeroProcesos):
        # esto es para simular la llegada de procesos
        yield env.timeout(random.expovariate(1.0 / intervalo))
        #basicamente inicia el proceso individual con la ayuda de simpy
        env.process(proceso(env,RAM, CPU,velocidadCPU, tiempos))

#creacion de procesos individuales (new - ready - running - waiting - terminated)
#la función que basicamente integra toda la logica de la simulacion
def proceso(env, RAM, CPU, velocidadCPU, tiempos):
    #---------NEW----------
    tiempoLlegada=env.now
    memoria= random.randint(1,10)
    #yield se usa en vez de return en simpy (pausa el proceso y continua tras cierto evento)
    yield RAM.get(memoria)
    #--------READY----------
    contIntrucciones=random.randint(1,10)
    #si tiene ejecuciones pendientes no puede salir del sistema
    while contIntrucciones>0:
        #esta pidiendo usar el CPU
        with CPU.request() as req:
            #es como la cola, espera hasta que hay espacio disponible
            #Simpy maneja la cola automaticamente
            yield req
            #basicamente ejecuta las instrucciones 
            ejecutar=min(velocidadCPU, contIntrucciones)
            #el proceso usa el CPU durante 1 unidad de tiempo
            yield env.timeout(1)
            #solo actualiza el contador (como ya se realizaron algunas (3 o menos) instrucciones)
            contIntrucciones-=ejecutar
            
            #------Decision clave-------
            if contIntrucciones>0:
                #aqui decide si va a ir a waiting o sigue a ready
                decision=random.randint(1,21)
                if decision==1:
                    #----Waiting-----
                    yield env.timeout(1)
    #devuelve la memoria porque ya no la va a usar    
    yield RAM.put(memoria)
    #se calcula el tiempo del proceso
    tiempoTotal=env.now - tiempoLlegada
    #se registra ese tiempo
    tiempos.append(tiempoTotal)
            

#Corre las instrucciones
def correr_simulacion(numeroProcesos, intervalo, capacidadRAM, velocidadCPU, numeroCPUs):
    #ambiente simpy es como el mundo donde ocurre la simulacion
    env=simpy.Environment()
    #creacion del container para simular la memoria
    RAM=simpy.Container(env,init=capacidadRAM, capacity=capacidadRAM)
    #modelado para el CPU con cola tipo Resource
    CPU=simpy.Resource(env, capacity=numeroCPUs)
    #lista vacía para registrar los tiempos de los procesos
    tiempos=[]
    
    env.process(generar_procesos(env,numeroProcesos,intervalo,RAM, CPU,velocidadCPU, tiempos))
    env.run()
    
    #con los tiempos de registrados se sacan los datos necesarios
    promedio=statistics.mean(tiempos)
    desviacion=statistics.stdev(tiempos)
    return promedio, desviacion

def graficarResultados(procesos, promedios, titulo):
    plt.figure()
    plt.plot(procesos, promedios, marker='o')
    plt.xlabel("Número de procesos")
    plt.ylabel("Tiempo promedio en el sistema")
    plt.title(titulo)
    plt.grid(True)
    plt.show()
    

#basicamente va a ser el "cerebro" del programa, ya que va a llamar a las funciones correspondientes
def main():
    #Creacion de la semilla para la secuencia en los números "aleatorios"
    random.seed(42)
    #Simulacion por numero de procesos e intervalos (solicitadas en la guía)
    procesosLista=[25,50,100,150,200]
    intervalos=[10,5,1]
    #se prueban todos los procesos (las cantidades especificadas en la lista) con las 3 intervalos de prueba
    for intervalo in intervalos:
        #promedios de tiempos
        promedios=[]
        #se recorre la lista para ejecutar cada simulacion con la cantidad i de procesos
        for cantproceso in procesosLista:
            #en parametros manda: la cantidad de procesos a realizar (i en la lista), el intervalo para la distribucion exponencial, la capacidad mazima de la memoria (especificada en la guia), la cantidad de instrucciones que se ejecutarán y el número de cpus a usar
            promedio, desviacion= correr_simulacion(cantproceso, 10, 100, 3, 2)
            print("Cantidad procesos " + str(cantproceso) + "\nPromedio: " + str(promedio) + "\nDesviacion: " + str(desviacion))

            promedios.append(promedio)
        
        graficarResultados(procesosLista,promedios,f"Intervalo {intervalo}")
        print("\n")

#NO es obligatorio usarlo, pero si lo uso en otro programa me sirve
if __name__=="__main__":
    #llama al main (empieza la ejecucion del programa)
    main()