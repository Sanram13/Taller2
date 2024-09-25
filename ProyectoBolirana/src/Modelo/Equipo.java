package Modelo;


public class Equipo {
    private Jugador[] jugadores;
    private Capitan capitan;
    private String nombre;
    private int numero;
    public Equipo(Capitan capitan) {
        this.jugadores = new Jugador[5];
        this.capitan = capitan;
    }
    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador[] jugadores) {
        this.jugadores = jugadores;
    }

    public Capitan getCapitan() {
        return capitan;
    }

    public void setCapitan(Capitan capitan) {
        this.capitan = capitan;
    }
//Hasta acá, abajo si es cosas que sabemos botsote
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
