
package Controlador;
import java.io.InputStream;
import java.util.Properties;

public class ControlJuego {

    private int[] vectorPuntaje;
    private int puntajeMaximo;
    private int equiposCreados = 0;
    private Fachada fachada;
    private int puntajeEquipo1 = 0;
    private int puntajeEquipo2 = 0;
    private int numeroEquipo1 = 0;
    private int numeroEquipo2 = 0;

    public ControlJuego(Fachada fachada) {
        vectorPuntaje = new int[13];
        cargarPuntajesDesdeProperties();
        this.fachada = fachada;
        this.controlMenu();
    }

    public void controlMenu() {
        int opc;
        do {
            opc = this.fachada.getVentana().mostrarMenu();
            switch (opc) {
                case 1:
                    try {
                        this.fachada.getCequipo().agregarEquipo();
                        this.equiposCreados++;
                    } catch (Exception e) {
                        this.fachada.getVentana().mostrarMensaje("Lo siento, tienes que elegir una opcion disponible");
                    }
                    break;
                case 2:
                    if (equiposCreados >= 2) {
                        this.iniciarPartida();
                    } else {
                        this.fachada.getVentana().mostrarMensaje("ERROR: Debes tener almenos 2 equipos para poder jugar");
                    }

                    break;
                case 0:

                    break;
                default:

                    break;
            }
        } while (opc != 0);
    }

    private void cargarPuntajesDesdeProperties() {
        Properties propiedades = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("resources/Propiedades.properties")) {
            if (input == null) {
                System.out.println("No se pudo encontrar el archivo bolirrana.properties");
                return;
            }
            propiedades.load(input);

            //añadir los puntajes en el vector desde el archivo properties
            for (int i = 0; i < vectorPuntaje.length; i++) {
                String valor = propiedades.getProperty("puntaje" + (i + 1));  //ciclo puntaje
                vectorPuntaje[i] = (valor != null) ? Integer.parseInt(valor) : 0;  //si no hay valor se asigna 0
            }
            String puntajeMaxStr = propiedades.getProperty("puntajeMaximo");
            puntajeMaximo = (puntajeMaxStr != null) ? Integer.parseInt(puntajeMaxStr) : 5000;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public int lanzar() {
        int numAleatorio = (int) (Math.random() * (vectorPuntaje.length));
        int piso = pisoRaya();
        System.out.println("pisoRaya: " + piso);
        if (piso == 1) {
            return 0;
        } else {
            System.out.println("Puntaje lanzado: " + vectorPuntaje[numAleatorio]);
            return vectorPuntaje[numAleatorio];
        }
    }

    public int lanzoMasDeUna(int limite) {

        int randomNum = (int) ((Math.random() * 5) + 1);
        int segundoRandomNum = (int) ((Math.random() * (limite)));
        if (randomNum < 2 && segundoRandomNum > 1) {
            return segundoRandomNum;
        } else {
            return 0;
        }
    }

    public int pisoRaya() {
        int numAleatorio = (int) (Math.random() * 10);
        if (numAleatorio < 3) {
            return 1;
        } else {
            return 0;
        }
    }

    public int llegaronTemprano(int numero1, int numero2) {
        int numAleatorio = (int) (Math.random() * 10);
        if (numAleatorio < 2) {
            int segundoNumAleatorio = (int) (Math.random() * 10);
            if (segundoNumAleatorio < 5) {
                this.fachada.getVentana().mostrarMensaje("El equipo 1 no se presentó");
                this.fachada.getCequipo().mostrarEquipoGanador(numero2); //Aca debe haber el equipo ganador
                return 0;
                //ElEquipo1LlegaTarde, Equipo2Ganador
            } else {
                this.fachada.getVentana().mostrarMensaje("El equipo 2 no se presentó");
                this.fachada.getCequipo().mostrarEquipoGanador(numero1);
                return 0;
                //ElEquipo2LlegaTarde, Equipo1Ganador;
            }
        } else {
            return 1;
        }
    }

    public void sorteoEquipoInicio() {
        int randomNum = (int) (Math.random() * 10);
        if (randomNum < 5) {
            this.fachada.getVentana().mostrarMensaje("El equipo numero: " + this.numeroEquipo1 + " inicia");
        } else {
            int aux = this.numeroEquipo1;
            this.numeroEquipo1 = this.numeroEquipo2;
            this.numeroEquipo2 = aux;
            this.fachada.getVentana().mostrarMensaje("El equipo numero: " + this.numeroEquipo1 + " inicia");
        }
    }

    public void iniciarPartida() {
        boolean flagFor2 = false;
        this.numeroEquipo1 = this.fachada.getCequipo().escogerEquipoAleatoriamente(0);
        this.numeroEquipo2 = this.fachada.getCequipo().escogerEquipoAleatoriamente(numeroEquipo1);
        if (this.fachada.getCequipo().estanCompletos(this.numeroEquipo1) && !this.fachada.getCequipo().estanCompletos(this.numeroEquipo2)) {
            this.fachada.getCequipo().sorteoDeJugadoresEquipo(this.numeroEquipo1);
        } else if (!this.fachada.getCequipo().estanCompletos(this.numeroEquipo1) && this.fachada.getCequipo().estanCompletos(this.numeroEquipo2)) {
            this.fachada.getCequipo().sorteoDeJugadoresEquipo(this.numeroEquipo2);
        } else if (!this.fachada.getCequipo().estanCompletos(this.numeroEquipo1) && !this.fachada.getCequipo().estanCompletos(this.numeroEquipo2)) {
            this.fachada.getVentana().mostrarMensaje("HAY EMPATE");
        } else if (llegaronTemprano(this.numeroEquipo1, this.numeroEquipo2) == 1) {
            if (this.fachada.getCequipo().estanCompletos(this.numeroEquipo1) && this.fachada.getCequipo().estanCompletos(this.numeroEquipo2)) {
                sorteoEquipoInicio();
                this.fachada.getCequipo().sorteoDeJugadoresEquipo(this.numeroEquipo1);
                this.fachada.getCequipo().sorteoDeJugadoresEquipo(this.numeroEquipo2);
                while (puntajeEquipo1 < puntajeMaximo && puntajeEquipo2 < puntajeMaximo) {
                    for (int i = 0; i < 5; i++) {
                        for (int j = 0; j < 5; j++) {
                            int auxNumBalinesLanzados = lanzoMasDeUna(5 - j);
                            if (auxNumBalinesLanzados > 1) {
                                j += auxNumBalinesLanzados - 1;
                            } else {
                                int auxLanzar = lanzar();
                                puntajeEquipo1 += auxLanzar;
                                this.fachada.getVentana().mostrarMensaje("El Jugador: " + (i + 1) + " del equipo 1 anotó " + auxLanzar);
                                if (puntajeEquipo1 >= 5000) {
                                    this.fachada.getCequipo().mostrarEquipoGanador(this.numeroEquipo1);
                                    flagFor2 = true;
                                    break;

                                }
                            }
                        }
                        if (flagFor2) {
                            break;
                        }
                        for (int k = 0; k < 5; k++) {
                            int auxNumBalinesLanzados = lanzoMasDeUna(5 - k);
                            if (auxNumBalinesLanzados > 1) {
                                k += auxNumBalinesLanzados - 1;
                            } else {
                                int auxLanzar = lanzar();
                                puntajeEquipo1 += auxLanzar;
                                this.fachada.getVentana().mostrarMensaje("El Jugador: " + (i + 1) + " del equipo 2 anotó " + auxLanzar);
                                if (puntajeEquipo2 >= 5000) {
                                    this.fachada.getCequipo().mostrarEquipoGanador(this.numeroEquipo2);
                                    flagFor2 = true;
                                    break;

                                }
                            }
                        }
                        if (flagFor2) {
                            break;
                        }
                    }
                }
            }
        }
    }
}
