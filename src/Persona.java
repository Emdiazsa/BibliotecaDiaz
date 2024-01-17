
public class Persona {
    private String nombre;
    private int edad;

    // Constructor de Persona
    public Persona(String nombre, int edad) {
        this.nombre = nombre;
        this.edad = edad;
    }
    
    public Persona(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    public void mostrarInformacionUsuario() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        // No mostramos la contraseña por razones de seguridad
    }
}