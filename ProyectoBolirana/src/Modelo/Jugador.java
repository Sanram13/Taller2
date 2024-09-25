package Modelo;


public class Jugador {
    private String cedula;
    private String edad;
    private String nombre;
    private String numero;
    
    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
    public String getNumero() {
        return cedula;
    }
    public void setNumero(String cedula) {
        this.cedula = cedula;
    }

    public String getEdad() {
        return edad;
    }
    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Jugador(String cedula) {
        this.cedula = cedula;
    }

    public Jugador(String cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public Jugador(String cedula, String edad, String nombre) {
        this.cedula = cedula;
        this.edad = edad;
        this.nombre = nombre;
    }
    public Jugador(String nombre, String cedula, String edad, String numero) {
    this.nombre = nombre;
    this.cedula = cedula;
    this.edad = edad;
    this.numero = numero;
    }
}
