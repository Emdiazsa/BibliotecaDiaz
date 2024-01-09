/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author administrador
 */


// Clase Usuario que hereda de Persona e incluye atributos específicos para la gestión de inicio de sesión
public class Usuario extends Persona {
    private String nombreUsuario;
    private String password;
    private char tipo_usuario;

    // Constructor de Usuario que llama al constructor de Persona
    public Usuario(String nombre, int edad, String nombreUsuario, String password, char tipo_usuario) {
        super(nombre, edad);
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
    }
    public Usuario(String nombre, String nombreUsuario, String password, char tipo_usuario) {
        super(nombre);
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.tipo_usuario = tipo_usuario;
    }
        public Usuario(String nombre, int edad) {
        super(nombre, edad);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public char getTipoUsuario() {
        return tipo_usuario;
    }
    
    public void setTipo_Usuario(char tipo_usuario) {
        this.tipo_usuario = tipo_usuario;
    } 
    @Override
    public void setNombre(String nombre) {
        super.setNombre(nombre);
    }

    @Override
    public void setEdad(int edad) {
        super.setEdad(edad);
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void mostrarInformacionUsuario() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Nombre de Usuario: " + nombreUsuario);
        // No mostramos la contraseña por razones de seguridad
    }
}