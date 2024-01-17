/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author administrador
 */
public class Pelicula {
    private String nombre;
    private String nota;
    private boolean disponible;
    private Usuario usuario;


    public Pelicula (String nombre, String nota, boolean disponible){
        this.nombre = nombre;
        this.nota = nota;
        this.disponible = disponible;   
    }

    public Pelicula (String nombre, String nota, boolean disponible, Usuario usuario){
        this.nombre = nombre;
        this.nota = nota;
        this.disponible = disponible;
        this.usuario = usuario; 
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
        return "Pelicula con" + " nombre='" + nombre + '\'' +", nota='" + nota + '\'';
    }
    
}
