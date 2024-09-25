


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package Controlador;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import Vista.Ventana;

public class FachadaTest {

    private Fachada fachada;

    @BeforeEach
    public void setUp() {
        fachada = new Fachada();
    }

    @Test
    public void testFachadaInicializacion() {
        // Verifica que los componentes de Fachada sean inicializados correctamente
        assertNotNull(fachada.getVentana(), "La ventana debe estar inicializada");
        assertNotNull(fachada.getCjuego(), "El control de juego debe estar inicializado");
        assertNotNull(fachada.getCequipo(), "El control de equipo debe estar inicializado");
        assertNotNull(fachada.getCjugador(), "El control de jugador debe estar inicializado");
    }

    @Test
    public void testGetVentana() {
        Ventana ventana = fachada.getVentana();
        assertNotNull(ventana, "El objeto Ventana no debe ser nulo");
    }

    @Test
    public void testSetVentana() {
        Ventana nuevaVentana = new Ventana(fachada);
        fachada.setVentana(nuevaVentana);
        assertEquals(nuevaVentana, fachada.getVentana(), "El objeto Ventana debe ser el mismo que el asignado");
    }

    @Test
    public void testGetCjuego() {
        ControlJuego cjuego = fachada.getCjuego();
        assertNotNull(cjuego, "El objeto ControlJuego no debe ser nulo");
    }

    @Test
    public void testSetCjuego() {
        ControlJuego nuevoCjuego = new ControlJuego(fachada);
        fachada.setCjuego(nuevoCjuego);
        assertEquals(nuevoCjuego, fachada.getCjuego(), "El objeto ControlJuego debe ser el mismo que el asignado");
    }

    @Test
    public void testGetCequipo() {
        ControlEquipo cequipo = fachada.getCequipo();
        assertNotNull(cequipo, "El objeto ControlEquipo no debe ser nulo");
    }

    @Test
    public void testSetCequipo() {
        ControlEquipo nuevoCequipo = new ControlEquipo(fachada);
        fachada.setCequipo(nuevoCequipo);
        assertEquals(nuevoCequipo, fachada.getCequipo(), "El objeto ControlEquipo debe ser el mismo que el asignado");
    }

    @Test
    public void testGetCjugador() {
        ControlJugador cjugador = fachada.getCjugador();
        assertNotNull(cjugador, "El objeto ControlJugador no debe ser nulo");
    }

    @Test
    public void testSetCjugador() {
        ControlJugador nuevoCjugador = new ControlJugador(fachada);
        fachada.setCjugador(nuevoCjugador);
        assertEquals(nuevoCjugador, fachada.getCjugador(), "El objeto ControlJugador debe ser el mismo que el asignado");
    }
}
