/**
 * @author Allysón Dulce Abigail Escobar Sandoval
 * Fecha: 02/04/2026
 * Propósito clase: Clase Paciente, que representa a un paciente con su nombre, descripcion de sintomas y codigo de emergencia.
 *                 
 */
public class Paciente implements Comparable<Paciente> {
    //atributos
    private String nombre;
    private String desSintomas;
    //A-E indica prioridad de atencion, siendo A la mas alta
    private String codigoEmergencia;

    //constructor
    public Paciente(String nombre, String desSintomas, String codigoEmergencia) {
        this.nombre = nombre;
        this.desSintomas = desSintomas;
        this.codigoEmergencia = codigoEmergencia;
    }

    //getters y setters
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDesSintomas() {
        return desSintomas;
    }
    public void setDesSintomas(String desSintomas) {
        this.desSintomas = desSintomas;
    }
    public String getCodigoEmergencia() {
        return codigoEmergencia;
    }
    public void setCodigoEmergencia(String codigoEmergencia) {
        this.codigoEmergencia = codigoEmergencia;
    }
    //toString para mostrar la informacion del paciente de manera legible
    @Override
    public String toString() {
        return "Paciente{" +
                "nombre='" + nombre + '\'' +
                ", desSintomas='" + desSintomas + '\'' +
                ", codigoEmergencia='" + codigoEmergencia + '\'' +
                '}';
    }

    @Override
    public int compareTo(Paciente paciente) {
        //se compara el codigo de emergencia de los pacientes para determinar su prioridad de atencion
        //A tiene mayor prioridad que B, B tiene mayor prioridad que C, y asi sucesivamente
        return this.codigoEmergencia.compareTo(paciente.codigoEmergencia);
    }


}
