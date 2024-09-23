package Vista;

import Controlador.Fachada;

import java.util.Scanner;


public class Ventana {
    
    private Fachada control;
    private Scanner lector;

    public Ventana(Fachada controlador){
        this.control = controlador;
        lector = new Scanner(System.in);
    }
    public String leerDato() {
        return lector.nextLine();
    }
    public int mostrarMenu() {
        System.out.println("Bienvenido a la BOLIRANA");
        System.out.println("Menú");
        System.out.println("1. Crear Equipo");
        System.out.println("2. Iniciar Partido");
        System.out.println("0. Salir");
        return lector.nextInt();
    }
    public void mostrarMensaje(String msj) {
        System.out.println(msj);
    }
    public void limpiarBuff() {
        if (lector.hasNextLine()) {
            lector.nextLine();
        }

    }
    public int mostrarMenuCrearCapitan() {
        System.out.println("Como quieres crear a tu capitan?");
        System.out.println("1. Solo con la cedula y años de experiencia");
        System.out.println("2. Con cedula, años de experiencia y nombre");
        System.out.println("3. Con cedula, años de experiencia, nombre y edad");
        System.out.println("Presiona cualquier otra tecla para dejar de crear Jugadores");
        return lector.nextInt();
    }
    public int mostrarMenuCrearJugador() {
        System.out.println("Como quieres crear a tu jugador?");
        System.out.println("1. Solo con la cedula");
        System.out.println("2. Con cedula y nombre");
        System.out.println("3. Con cedula, nombre y edad");
        return lector.nextInt();
    }
}
