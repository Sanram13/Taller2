package Controlador;

import Modelo.Capitan;
import Modelo.Jugador;


public class ControlJugador {
    private Capitan capitan;
    private Jugador jugador;
    private Fachada fachada;

    public Capitan crearCapitan(String ced, String exp) {
        return this.capitan = new Capitan(ced, exp);
    }

    public Capitan crearCapitan(String ced, String exp, String nombre) {
        return this.capitan = new Capitan(ced, exp, nombre);
    }

    public Capitan crearCapitan(String ced, String exp, String nom, String edad) {
        return this.capitan = new Capitan(ced, edad, nom, exp);
    }

    public Jugador crearJugador(String ced) {
        return this.jugador = new Jugador(ced);
    }

    public Jugador crearJugador(String ced, String nom) {
        return this.jugador = new Jugador(ced, nom);
    }

    public Jugador crearJugador(String ced, String nom, String edad) {
        return this.jugador = new Jugador(ced, nom, edad);
    }

    public Capitan agregarCapitan() {
        String cedulaCapitan;
        String anosExperienciaCapitan;
        String nombreCapitan;
        String edadCapitan;
        switch (this.fachada.getVentana().mostrarMenuCrearCapitan()) {
            case 1:
                this.fachada.getVentana().mostrarMensaje("Pon el numero de cedula");
                cedulaCapitan = this.fachada.getVentana().leerDato();
                this.fachada.getVentana().limpiarBuff();
                this.fachada.getVentana().mostrarMensaje("Pon los años de experiencia");
                anosExperienciaCapitan = this.fachada.getVentana().leerDato();
                return this.fachada.getCjugador().crearCapitan(cedulaCapitan, anosExperienciaCapitan);
            case 2:
                this.fachada.getVentana().mostrarMensaje("Pon el numero de cedula");
                cedulaCapitan = this.fachada.getVentana().leerDato();
                this.fachada.getVentana().limpiarBuff();
                this.fachada.getVentana().mostrarMensaje("Pon los años de experiencia");
                anosExperienciaCapitan = this.fachada.getVentana().leerDato();
                this.fachada.getVentana().mostrarMensaje("Pon el nombre");
                nombreCapitan = this.fachada.getVentana().leerDato();
                return this.fachada.getCjugador().crearCapitan(cedulaCapitan, anosExperienciaCapitan, nombreCapitan);
            case 3:
                this.fachada.getVentana().mostrarMensaje("Pon el numero de cedula");
                cedulaCapitan = this.fachada.getVentana().leerDato();
                this.fachada.getVentana().limpiarBuff();
                this.fachada.getVentana().mostrarMensaje("Pon los años de experiencia");
                anosExperienciaCapitan = this.fachada.getVentana().leerDato();
                this.fachada.getVentana().mostrarMensaje("Pon el nombre");
                nombreCapitan = this.fachada.getVentana().leerDato();
                this.fachada.getVentana().mostrarMensaje("Pon la edad");
                edadCapitan = this.fachada.getVentana().leerDato();
                return this.fachada.getCjugador().crearCapitan(cedulaCapitan, anosExperienciaCapitan, nombreCapitan, edadCapitan);
            default:
                this.fachada.getVentana().mostrarMensaje("ERROR: NO HAS ELEGIDO UNA OPCION DISPONIBLE");
                return null;
        }
    }

    public Jugador[] agregarJugadores() {
        Jugador[] aux = new Jugador[5];
        int limite = 0;
        int indiceCorrido = 0;
        boolean corrio = false;
            while (!corrio) {
                if (limite < 5) {
                    this.fachada.getVentana().mostrarMensaje("Presiona 1 para Agregar jugador");
                    String cedulaJugador;
                    String nombreJugador;
                    String edadJugador;
                    switch (this.fachada.getVentana().leerDato()) {
                        case "1":
                            try {
                                switch (this.fachada.getVentana().mostrarMenuCrearJugador()) {
                                    case 1:
                                        this.fachada.getVentana().mostrarMensaje("Pon la cedula de tu jugador");
                                        this.fachada.getVentana().limpiarBuff();
                                        cedulaJugador = this.fachada.getVentana().leerDato();
                                        aux[indiceCorrido] = crearJugador(cedulaJugador);
                                        limite++;
                                        break;
                                    case 2:
                                        this.fachada.getVentana().mostrarMensaje("Pon la cedula de tu jugador");
                                        this.fachada.getVentana().limpiarBuff();
                                        cedulaJugador = this.fachada.getVentana().leerDato();
                                        this.fachada.getVentana().mostrarMensaje("Pon la nombre de tu jugador");
                                        nombreJugador = this.fachada.getVentana().leerDato();
                                        aux[indiceCorrido] = crearJugador(cedulaJugador, nombreJugador);
                                        limite++;
                                        break;
                                    case 3:
                                        this.fachada.getVentana().mostrarMensaje("Pon la cedula de tu jugador");
                                        this.fachada.getVentana().limpiarBuff();
                                        cedulaJugador = this.fachada.getVentana().leerDato();
                                        this.fachada.getVentana().mostrarMensaje("Pon la nombre de tu jugador");
                                        nombreJugador = this.fachada.getVentana().leerDato();
                                        this.fachada.getVentana().mostrarMensaje("Pon la edad de tu jugador");
                                        edadJugador = this.fachada.getVentana().leerDato();
                                        aux[indiceCorrido] = crearJugador(cedulaJugador, nombreJugador, edadJugador);
                                        limite++;
                                        break;
                                }
                            } catch (Exception e) {
                                this.fachada.getVentana().mostrarMensaje("ERROR: Has elegido una opción no disponible");
                            }

                            indiceCorrido++;
                            break;
                        default:
                            corrio = true;
                            break;

                    }
                }
                else {
                    corrio = true;
                }
            }

        return aux;
    }
    public Jugador[] sorteoJugadores(Jugador[] jugadores) {
        for (int i = 0; i < jugadores.length; i++) {
            int indiceAleatorio = (int) (Math.random()*(jugadores.length - i) + i);
            Jugador temp = jugadores[i];
            jugadores[i] = jugadores[indiceAleatorio];
            jugadores[indiceAleatorio] = temp;
        }
        return jugadores;
    }
    public void mostrarJugadoresGanadores(Jugador[] jugadores) {
        this.fachada.getVentana().mostrarMensaje("Estos son los jugadores del equipo ganador");
        for (int i = 0; i < 5; i++) {
            this.fachada.getVentana().mostrarMensaje("Este es el jugador: " + i+1);
            this.fachada.getVentana().mostrarMensaje("Su cedula es: " + jugadores[i].getCedula());
            if(jugadores[i].getNombre() != null) {
                this.fachada.getVentana().mostrarMensaje("Su nombre es: " + jugadores[i].getNombre());
            }
            if(jugadores[i].getEdad() != null) {
                this.fachada.getVentana().mostrarMensaje("Su edad es: " + jugadores[i].getEdad());
            }
        }
    }
    public void mostrarCapitanGanador(Capitan capitan) {
        this.fachada.getVentana().mostrarMensaje("Su cedula es: " + capitan.getCedula());
        if(this.capitan.getNombre() != null) {
            this.fachada.getVentana().mostrarMensaje("Su nombre es: " + capitan.getNombre());
        }
        if(this.capitan.getEdad() != null) {
            this.fachada.getVentana().mostrarMensaje("Su edad es: " + this.capitan.getEdad());
        }
    }
    public int estanCompletos(Jugador[] jugadores){
        int contador = 0;
        for (int i = 0; i < 5; i++) {
            if(jugadores[i] != null) {
                contador++;
            }
        }
        return contador;
    }
    public ControlJugador(Fachada fachada) {
        this.fachada = fachada;
    }


}
