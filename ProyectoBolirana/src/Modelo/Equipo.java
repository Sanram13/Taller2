package Modelo;



public class Equipo {
    private Jugador[] jugadores;
    private Capitan capitan;
    private String nombre;
    private int numero;
    private int indiceJugador = 0;
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
    public void agregarJugador(Jugador jugador) {
        if (indiceJugador < 5) {  // Asegúrate de no exceder los 5 jugadores
            this.jugadores[indiceJugador] = jugador;
            indiceJugador++;
        } else {
            System.out.println("El equipo ya tiene 5 jugadores");
        }
    }
}