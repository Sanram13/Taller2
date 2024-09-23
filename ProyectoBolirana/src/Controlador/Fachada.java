package Controlador;

import Vista.Ventana;

public class Fachada {
    private Ventana ventana;
    private ControlJuego cjuego;
    private ControlEquipo cequipo;
    private ControlJugador cjugador;
    public Fachada() {
        this.ventana = new Ventana(this);
        this.cjugador = new ControlJugador(this);
        this.cequipo = new ControlEquipo(this);
        this.cjuego = new ControlJuego(this);

    }

    public Ventana getVentana() {
        return ventana;
    }

    public void setVentana(Ventana ventana) {
        this.ventana = ventana;
    }

    public ControlJuego getCjuego() {
        return cjuego;
    }

    public void setCjuego(ControlJuego cjuego) {
        this.cjuego = cjuego;
    }

    public ControlEquipo getCequipo() {
        return cequipo;
    }

    public void setCequipo(ControlEquipo cequipo) {
        this.cequipo = cequipo;
    }

    public ControlJugador getCjugador() {
        return cjugador;
    }

    public void setCjugador(ControlJugador cjugador) {
        this.cjugador = cjugador;
    }
}
