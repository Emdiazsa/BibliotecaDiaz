
public class Libro {
    private String nombre;
    private String pasillo;
    private String estanteria;
    private String nota;
    private boolean disponible;
    private Usuario usuario;


    public Libro(String nombre, String pasillo, String estanteria, String nota, boolean disponible) {
        this.nombre = nombre;
        this.pasillo = pasillo;
        this.estanteria = estanteria;
        this.nota = nota;
        this.disponible = disponible;
    }
    
    public Libro(String nombre, String pasillo, String estanteria, String nota, boolean disponible, Usuario usuario) {
        this.nombre = nombre;
        this.pasillo = pasillo;
        this.estanteria = estanteria;
        this.nota = nota;
        this.disponible = disponible;
        this.usuario=usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasillo() {
        return pasillo;
    }

    public void setPasillo(String pasillo) {
        this.pasillo = pasillo;
    }

    public String getEstanteria() {
        return estanteria;
    }

    public void setEstanteria(String estanteria) {
        this.estanteria = estanteria;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }
    
    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }   
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    @Override
    public String toString() {
        return "Libro con " + " nombre='" + nombre + '\'' + ", pasillo='" + pasillo + '\'' + 
                ", estanteria='" + estanteria + '\'' +", nota='" + nota + '\'';
    }
    
    public String libroYDueño() {
        return "El libro: " + nombre + " lo tiene " + usuario.getNombreUsuario() +".";
    }
}