package Modelo;


public class Capitan {
    private String cedula;
    private String edad;
    private String nombre;
    private String tiempoExperiencia;

    public String getCedula() {
        return cedula;
    }
    public void setCedula(String cedula) {
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

    public String getTiempoExperiencia() {
        return tiempoExperiencia;
    }
    public void setTiempoExperiencia(String tiempoExperiencia) {
        this.tiempoExperiencia = tiempoExperiencia;
    }

    public Capitan(String cedula, String tiempoExperiencia) {
        this.cedula = cedula;
        this.tiempoExperiencia = tiempoExperiencia;
    }

    public Capitan(String cedula, String nombre, String tiempoExperiencia) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tiempoExperiencia = tiempoExperiencia;
    }

    public Capitan(String cedula, String edad, String nombre, String tiempoExperiencia) {
        this.cedula = cedula;
        this.edad = edad;
        this.nombre = nombre;
        this.tiempoExperiencia = tiempoExperiencia;
    }

    
    
    
    
}
