package Controlador;

import Modelo.Capitan;
import Modelo.Equipo;
import Modelo.Jugador;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.io.FileReader;
import java.io.IOException;

public class ControlEquipo {

    private Equipo equipo;
    private ArrayList<Equipo> equipos;
    private Fachada fachada;
    private int indice = 0;

    public ControlEquipo(Fachada fachada) {
        this.equipos = new ArrayList<Equipo>();
        this.fachada = fachada;
        cargarEquiposDesdeArchivo("C:\\Users\\asfak\\Documents\\NetBeansProjects\\ProyectoBolirana\\src\\Specs/Directo");
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
        guardarEquiposArchivo("C:\\Users\\asfak\\Documents\\NetBeansProjects\\ProyectoBolirana\\src\\Specs/Directo");
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

    public void guardarEquiposArchivo(String rutaArchivo) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo))) {
            for (Equipo equipo : equipos) {
                writer.write("Equipo: " + equipo.getNombre() + "\n");
                writer.write("Número del equipo: " + equipo.getNumero() + "\n");

                //datos Capitan
                Capitan capitan = equipo.getCapitan();
                writer.write("Capitán: " + capitan.getNombre() + ", Cédula: " + capitan.getCedula() + ", Edad: " + capitan.getEdad()
                        + ", Años de experiencia: " + capitan.getTiempoExperiencia() + "\n");

                //datos Jugadores
                writer.write("Jugadores:\n");
                for (Jugador jugador : equipo.getJugadores()) {
                    writer.write("- " + jugador.getNombre() + ", Cédula: " + jugador.getCedula() + ", Edad: " + jugador.getEdad()
                            + ", Número: " + jugador.getNumero() + "\n");
                }
                writer.write("\n");
            }
            writer.flush();
            this.fachada.getVentana().mostrarMensaje("Los equipos se han guardado correctamente en el archivo: " + rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
            this.fachada.getVentana().mostrarMensaje("Error al guardar los equipos en el archivo");
        }
    }

    public void cargarEquiposDesdeArchivo(String rutaArchivo) {
    try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
        String linea;
        Equipo equipo = null;
        while ((linea = reader.readLine()) != null) {
            if (linea.startsWith("Equipo:")) {
                String nombreEquipo = linea.split(":")[1].trim();
                linea = reader.readLine();
                int numeroEquipo = Integer.parseInt(linea.split(":")[1].trim());
                linea = reader.readLine();
                String[] datosCapitan = linea.split(",");
                
                // Capitan: sin convertir edad y años de experiencia a int si ya son String
                Capitan capitan = new Capitan(
                        datosCapitan[0].split(":")[1].trim(), // Nombre
                        datosCapitan[1].split(":")[1].trim(), // Cédula
                        datosCapitan[2].split(":")[1].trim(), // Edad (mantener como String)
                        datosCapitan[3].split(":")[1].trim()  // Años de experiencia (mantener como String)
                );
                
                equipo = new Equipo(capitan);
                equipo.setNombre(nombreEquipo);
                equipo.setNumero(numeroEquipo);
                equipos.add(equipo);
            } else if (linea.startsWith("Jugadores:")) {
                while ((linea = reader.readLine()) != null && linea.startsWith("-")) {
                    String[] datosJugador = linea.split(",");
                    Jugador jugador = new Jugador(
                            datosJugador[0].split("- ")[1].trim(), // Nombre
                            datosJugador[1].split(":")[1].trim(),  // Cédula
                            datosJugador[2].split(":")[1].trim(),  // Edad (mantener como String)
                            datosJugador[3].split(":")[1].trim()   // Número (mantener como String)
                    );
                    equipo.agregarJugador(jugador); // Asegúrate de que exista este método en la clase Equipo
                }
            }
        }
        this.fachada.getVentana().mostrarMensaje("Equipos cargados correctamente desde el archivo.");
    } catch (IOException e) {
        this.fachada.getVentana().mostrarMensaje("Error al cargar los equipos desde el archivo.");
        e.printStackTrace();
    }
}
}