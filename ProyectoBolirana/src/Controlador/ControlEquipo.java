package Controlador;


import Modelo.Capitan;
import Modelo.Equipo;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ControlEquipo {
    private Equipo equipo;
    private ArrayList<Equipo> equipos;
    private Fachada fachada;
    private int indice = 0;

    public ControlEquipo(Fachada fachada) {
        this.equipos = new ArrayList<Equipo>();
        this.fachada = fachada;
    }

    public void crearEquipo(Capitan capitan) {
        this.equipo = new Equipo(capitan);
    }

    public void agregarEquipo() {
        crearEquipo(this.fachada.getCjugador().agregarCapitan());
        this.equipo.setJugadores(this.fachada.getCjugador().agregarJugadores());
        this.fachada.getVentana().mostrarMensaje("Pon el nombre del equipo");
        this.equipo.setNombre(this.fachada.getVentana().leerDato());
        this.indice++;
        this.equipo.setNumero(indice);
        equipos.add(equipo);
    }

    public void sorteoDeJugadoresEquipo(int numeroEquipo) {
        Iterator iterator = equipos.iterator();
        while (iterator.hasNext()) {
            Equipo equipo4 = (Equipo) iterator.next();
            if (equipo4.getNumero() == numeroEquipo) {
                equipo4.setJugadores(this.fachada.getCjugador().sorteoJugadores(equipo4.getJugadores()));
            }
        }
    }

    public void mostrarEquipoGanador(int num) {
        Iterator iterator = equipos.iterator();
        boolean flag = false;
        while (iterator.hasNext()) {
            Equipo equipo2 = (Equipo) iterator.next();
            if (equipo2.getNumero() == num) {
                flag = true;
                this.fachada.getVentana().mostrarMensaje("El equipo: " + equipo2.getNombre() + " Ha ganado");
                this.fachada.getCjugador().mostrarCapitanGanador(equipo2.getCapitan());
                this.fachada.getCjugador().mostrarJugadoresGanadores(equipo2.getJugadores());
            }
        }
        if (!flag) {
            this.fachada.getVentana().mostrarMensaje("NO EXISTE EL EQUIPO");
        }
    }

    public int escogerEquipoAleatoriamente(int equipoAnterior) {
        Iterator iterator = equipos.iterator();
        while (iterator.hasNext()) {
            Equipo equipo3 = (Equipo) iterator.next();
            if (equipo3.getNumero() != equipoAnterior) {
                return equipo3.getNumero();
            }
        }
        return 0;
    }

    public boolean estanCompletos(int num1) {
        for (int i = 0; i < 5; i++) {
            Iterator iterator = equipos.iterator();
            while (iterator.hasNext()) {
                Equipo equipo4 = (Equipo) iterator.next();
                if (equipo4.getNumero() == num1) {
                    this.fachada.getCjugador().estanCompletos(equipo4.getJugadores());
                    return true;
                }
            }
        }
        return false;
    }
}


