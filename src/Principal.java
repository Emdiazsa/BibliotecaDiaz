

import java.util.ArrayList;
import java.util.Scanner;

public class Principal {
    private static final ArrayList<Usuario> usuarios = new ArrayList<>();
    private static final ArrayList<Libro> listadoLibrosDisponible  = new ArrayList<>();
    private static final ArrayList<Libro> listadoLibrosOcupados  = new ArrayList<>();
    private static final ArrayList<Pelicula> listadoPeliculasDisponible  = new ArrayList<>();
    private static final ArrayList<Pelicula> listadoPeliculasOcupadas  = new ArrayList<>();
    private static Usuario usuarioActual;
    private static final Scanner scanner = new Scanner(System.in);

    
    public static void crearUsuariosYLibrosYPeliculasAlIniciaApp(){
        //CREO USUARIOS
        Usuario usuario1 = new Usuario("Eva", 18 ,"Eva", "clave1", 'U');
        usuarios.add(usuario1);
        
        Usuario usuario2 = new Usuario("David", 23 ,"David", "clave2", 'U');
        usuarios.add(usuario2);
        
        Usuario usuario3 = new Usuario("Julia", 15 ,"Julia", "clave3", 'U');
        usuarios.add(usuario3);
        
        Usuario usuario4 = new Usuario("Jose", 70 ,"Jose", "clave4", 'U');
        usuarios.add(usuario4);
        
        Usuario usuario5 = new Usuario("admin" ,"admin", "admin", 'A');
        usuarios.add(usuario5);
        
        
       // Creación de 10 libros con nombres
        Libro libro1 = new Libro( "Don Quijote de la Mancha", "Ficción", "Estantería 1", "8", true);
        listadoLibrosDisponible.add(libro1);
        Libro libro2 = new Libro( "Cien años de soledad", "Ficción", "Estantería 2", "10", false, usuario1);
        listadoLibrosOcupados.add(libro2);
        Libro libro3 = new Libro( "La sombra del viento", "Ficción", "Estantería 3", "7", true);
        listadoLibrosDisponible.add(libro3);
        Libro libro4 = new Libro( "Don Juan Tenorio", "Drama", "Estantería 4", "5", false, usuario2);
        listadoLibrosOcupados.add(libro4);
        Libro libro5 = new Libro("La Regenta", "Ficción", "Estantería 5", "4", true);
        listadoLibrosDisponible.add(libro5);
        Libro libro6 = new Libro ("Fortunata y Jacinta", "Ficción", "Estantería 6", "10", false,usuario3);
        listadoLibrosOcupados.add(libro6);
        Libro libro7 = new Libro( "El Lazarillo de Tormes", "Novela picaresca", "Estantería 7", "6", true);
        listadoLibrosDisponible.add(libro7);
        Libro libro8 = new Libro( "Rimas y Leyendas", "Poesía", "Estantería 8", "8", false, usuario4);
        listadoLibrosOcupados.add(libro8);
        Libro libro9 = new Libro("La Celestina", "Teatro", "Estantería 9", "10", true);
        listadoLibrosDisponible.add(libro9);
        Libro libro10 = new Libro("Rayuela", "Ficción", "Estantería 10", "0", false, usuario4);
        listadoLibrosOcupados.add(libro10);
        
        // Creación de 3 peliculas con nombres
        Pelicula pelicula1 = new Pelicula( "Titanic", "9", true);
        listadoPeliculasDisponible.add(pelicula1);
        Pelicula pelicula2 = new Pelicula( "Avatar", "8", false);
        listadoPeliculasOcupadas.add(pelicula2);
        Pelicula pelicula3 = new Pelicula( "Los Increibles", "10", true);
        listadoPeliculasDisponible.add(pelicula3);

    }
    
    public static void main(String[] args) {
        // Crear algunos usuarios y libros predefinidos para pruebas
        crearUsuariosYLibrosYPeliculasAlIniciaApp();

        int opcion;
        do {
            System.out.println("BIENVENIDO A LA BIBLIOTECA DIAZ!!!");
            
            System.out.println("\t1. Iniciar Sesión");
            System.out.println("\t2. Registrarse");
            System.out.println("\t0. Cerrar Aplicación");
            
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarUsuario();
                    break;
                case 0:
                    System.out.println("Cerrando la aplicación. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 0);
        
        scanner.close();
    }

    // METODO PARA CREAR USUARIO
    private static void registrarUsuario() {
        
        System.out.print("Ingrese tu nombre personal: ");
        String nombre = scanner.next();
        System.out.print("Ingrese tu edad: ");
        int edad = scanner.nextInt();
        System.out.print("Ingrese un nombre de usuario para ingresar en la app: ");
        String nuevoUsuario = scanner.next();
        System.out.print("Ingrese una contraseña: ");
        String nuevaClave = scanner.next();

        // Crear un nuevo usuario y agregarlo a la lista de usuarios
        usuarios.add(new Usuario(nombre, edad,nuevoUsuario, nuevaClave, 'U'));

        System.out.println("Usuario registrado exitosamente. ¡Ahora puedes iniciar sesión!");
    }

    // METODO PARA INICIAR SESION
    private static void iniciarSesion() {
        System.out.print("Ingrese su nombre de usuario: ");
        String nombreUsuario = scanner.next();
        System.out.print("Ingrese su contraseña: ");
        String clave = scanner.next();

        // Verificar si el usuario y la contraseña coinciden con algún usuario registrado
        boolean inicioSesionExitoso = false;
        
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equals(nombreUsuario) && usuario.getPassword().equals(clave)) {
                inicioSesionExitoso = true;
                usuarioActual = usuario;
                System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuarioActual.getNombre() + "!");
                if (usuarioActual.getTipoUsuario() == 'A') {
                    System.out.println("¡Eres administrador!");
                    mostrarSubMenuAdmin();
                    break;
                    
                } else if (usuarioActual.getTipoUsuario() == 'U') {
                    mostrarSubMenuUsuario(usuario.getNombre());
                    break;
                }
            }
        }

        if (!inicioSesionExitoso) {
            System.out.println("Nombre de usuario o contraseña incorrectos. Inténtalo de nuevo.");
        }
    }

    //SI EL USUARIO INICIA SESION SE INICIA COMO USUARIO SE MUESTRA ESTE MENÚ
    public static void mostrarSubMenuAdmin() {
        int opcion;
        do {
            System.out.println("MENÚ DE ADMINISTRADOR");
            System.out.println("\t1. Añadir libro.");
            System.out.println("\t2. Modificar libro.");
            System.out.println("\t3. Eliminar libro.");
            System.out.println("\t4. Ver usuarios registrados.");
            System.out.println("\t5. Modificar usuario.");
            System.out.println("\t6. Listado de libros con su dueño.");
            System.out.println("\t7. Añadir pelicula.");
            System.out.println("\t8. Modificar pelicula.");
            System.out.println("\t9. Eliminar pelicula.");
            System.out.println("\t0. Volver al Menú Principal");

            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    agregarLibro();
                    break;
                case 2:
                    modificarLibro();
                    break;
                case 3:
                    eliminarLibro();
                    break;
                case 4:
                    mostrarUsuariosRegistrados();
                    break;
                case 5:
                    modificarUsuario();
                    break;
                case 6:
                    mostrarLibrosConDueño();
                    break;
                case 7:
                    agregarPelicula();
                    break;
                case 8:
                    modificarPelicula();
                    break;
                case 9:
                    eliminarPelicula();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }
        } while (opcion != 0);
    }
    
    // SI EL USUARIO INICIA SESION SE INICIA COMO USUARIO SE MUESTRA ESTE MENÚ
    public static void mostrarSubMenuUsuario(String nombre){

        int opcion;
        do {
            System.out.println("BIENVENIDO " + nombre);
            
            System.out.println("\t1. Recoger un libro.");
            System.out.println("\t2. Devolver un libro.");
            System.out.println("\t3. Ver listado de libros");
            System.out.println("\t4. Recoger una pelicula.");
            System.out.println("\t5. Devolver una pelicula.");
            System.out.println("\t6. Ver listado de peliculas.");
            System.out.println("\t0. Volver al Menú Principal");
            
            System.out.print("Ingrese la opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    recogerLibro();
                    break;
                case 2:
                    devolverLibro();
                    break;
                case 3:
                    mostrarListadoLibros();
                    break;
                case 4:
                    recogerPelicula();
                    break;
                case 5:
                    devolverPelicula();
                    break;
                case 6:
                    mostrarListadoPeliculas();
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
                    break;
            }

        } while (opcion != 0);
    }
    
    // METODO PARA RECOGER UN LIBRO
    private static void recogerLibro() {
        System.out.print("Ingrese el nombre del libro que desea recoger: ");
        scanner.nextLine();
        String nombreLibro = scanner.nextLine();

        Libro libro = buscarLibroPorNombre(nombreLibro);

        if (libro != null && libro.isDisponible()) {
            libro.setDisponible(false); // Cambiamos el estado a no disponible
            libro.setUsuario(usuarioActual);
            listadoLibrosOcupados.add(libro);
            listadoLibrosDisponible.remove(libro);
            System.out.println("Libro recogido con éxito.");
        } else if (libro == null) {
            System.out.println("Libro no encontrado.");
        } else {
            System.out.println("El libro no está disponible para recoger.");
        }
    }
    
    // METODO PARA DEVOLVER UN LIBRO
    private static void devolverLibro() {
        System.out.print("Ingrese el nombre del libro que desea devolver: ");
        scanner.nextLine();
        String nombreLibro = scanner.nextLine();

        Libro libro = buscarLibroPrestadoPorNombre(nombreLibro);

        if (libro != null && libro.getUsuario() != null && libro.getUsuario().equals(usuarioActual)) {
            libro.setDisponible(true);
            libro.setUsuario(null);
            listadoLibrosDisponible.add(libro);
            listadoLibrosOcupados.remove(libro);
            System.out.println("Libro devuelto con éxito.");
        } else if (libro == null) {
            System.out.println("Libro no encontrado.");
        } else {
            System.out.println("No puedes devolver este libro, ya que no está asociado a tu cuenta.");
        }
    }

    // METODO PARA BUSCAR LIBRO POR NOMBRE
    private static Libro buscarLibroPrestadoPorNombre(String nombreLibro) {
        for (Libro libro : listadoLibrosOcupados) {
            if (libro.getNombre().equalsIgnoreCase(nombreLibro)) {
                return libro;
            }
        }
        return null; // El libro no se encontró en la lista de prestados
    }

    // METODO PARA MOSTRAR LIBROS (TODOS O SOLO DISPONIBLES)
    private static void mostrarListadoLibros() {
        System.out.println("¿Quieres ver todos los libros o solo los disponibles?");
        System.out.println("\t1. Todos los libros");
        System.out.println("\t2. Solo los disponibles");
        System.out.print("Ingrese la opción: ");
        int opcionListado = scanner.nextInt();

        switch (opcionListado) {
            case 1:
                mostrarTodosLosLibros();
                break;
            case 2:
                mostrarLibrosDisponibles();
                break;
            default:
                System.out.println("Opción no válida. Volviendo al menú principal.");
                break;
        }
    }
    
    // METODO PARA MOSTRAR TODOS LOS LIBROS
    private static void mostrarTodosLosLibros() {
        System.out.println("Listado de Todos los Libros:");
        for (Libro libro : listadoLibrosDisponible) {
            System.out.println(libro);
        }
        for (Libro libro : listadoLibrosOcupados) {
            System.out.println(libro);
        }
    }
    
    //METODO PARA MOSTRAR SOLO LIBROS DISPONIBLES
    private static void mostrarLibrosDisponibles() {
        System.out.println("Listado de Libros Disponibles:");
        for (Libro libro : listadoLibrosDisponible) {
            System.out.println(libro);
        }
    }
    
    
    // METODO PARA BUSCAR LIBRO ENTRE LOS DISPONIBLES Y LOS QUE NO
    private static Libro buscarLibroPorNombre(String nombreLibro) {
        for (Libro libro : listadoLibrosDisponible) {
            if (libro.getNombre().equals(nombreLibro)) {
                return libro;
            }
        }
        
        for (Libro libro : listadoLibrosOcupados) {
            if (libro.getNombre().equals(nombreLibro)) {
                return libro;
            }
        }
        return null; // El libro no se encontró en la lista de disponibles
    }
    
   // METODO PARA RECOGER UNA PELICULA
    private static void recogerPelicula() {
        System.out.print("Ingrese el nombre de la pelicula que desea recoger: ");
        scanner.nextLine();
        String nombrePelicula = scanner.nextLine();

        Pelicula pelicula = buscarPeliculaPorNombre(nombrePelicula);

        if (pelicula != null && pelicula.isDisponible()) {
            pelicula.setDisponible(false); // Cambiamos el estado a no disponible
            pelicula.setUsuario(usuarioActual);
            listadoPeliculasOcupadas.add(pelicula);
            listadoPeliculasDisponible.remove(pelicula);
            System.out.println("Pelicula recogida con éxito.");
        } else if (pelicula == null) {
            System.out.println("Pelicula no encontrada.");
        } else {
            System.out.println("La pelicula no está disponible para recoger.");
        }
    }
    
    // METODO PARA DEVOLVER UNA PELICULA
    private static void devolverPelicula() {
        System.out.print("Ingrese el nombre de la pelicula que desea devolver: ");
        scanner.nextLine();
        String nombrePelicula = scanner.nextLine();

        Pelicula pelicula = buscarPeliculaPrestadaPorNombre(nombrePelicula);

        if (pelicula != null && pelicula.getUsuario() != null && pelicula.getUsuario().equals(usuarioActual)) {
            pelicula.setDisponible(true);
            pelicula.setUsuario(null);
            listadoPeliculasDisponible.add(pelicula);
            listadoPeliculasOcupadas.remove(pelicula);
            System.out.println("Pelicula devuelta con éxito.");
        } else if (pelicula == null) {
            System.out.println("Pelicula no encontrada.");
        } else {
            System.out.println("No puedes devolver esta pelicula, ya que no está asociada a tu cuenta.");
        }
    }
    
     // METODO PARA BUSCAR PELICULA POR NOMBRE
    private static Pelicula buscarPeliculaPrestadaPorNombre(String nombrePelicula) {
        for (Pelicula pelicula : listadoPeliculasOcupadas) {
            if (pelicula.getNombre().equalsIgnoreCase(nombrePelicula)) {
                return pelicula;
            }
        }
        return null; // La pelicula no se encontró en la lista de prestados
    }
    
    // METODO PARA MOSTRAR PELICULAS (TODAS O SOLO DISPONIBLES)
    private static void mostrarListadoPeliculas() {
        System.out.println("¿Quieres ver todas las peliculas o solo las disponibles?");
        System.out.println("\t1. Todas las peliculas");
        System.out.println("\t2. Solo las disponibles");
        System.out.print("Ingrese la opción: ");
        int opcionListado = scanner.nextInt();

        switch (opcionListado) {
            case 1:
                mostrarTodasLasPeliculas();
                break;
            case 2:
                mostrarPeliculasDisponibles();
                break;
            default:
                System.out.println("Opción no válida. Volviendo al menú principal.");
                break;
        }
    }
    
     // METODO PARA MOSTRAR TODAS LAS PELICULAS
    private static void mostrarTodasLasPeliculas() {
        System.out.println("Listado de Todas las Peliculas:");
        for (Pelicula pelicula : listadoPeliculasDisponible) {
            System.out.println(pelicula);
        }
        for (Pelicula pelicula : listadoPeliculasOcupadas) {
            System.out.println(pelicula);
        }
    }
    
     //METODO PARA MOSTRAR SOLO PELICULAS DISPONIBLES
    private static void mostrarPeliculasDisponibles() {
        System.out.println("Listado de Peliculas Disponibles:");
        for (Pelicula pelicula : listadoPeliculasDisponible) {
            System.out.println(pelicula);
        }
    }
    
    
    // METODO PARA BUSCAR PELICULA ENTRE LAS DISPONIBLES Y LAS QUE NO
    private static Pelicula buscarPeliculaPorNombre(String nombrePelicula) {
        for (Pelicula pelicula : listadoPeliculasDisponible) {
            if (pelicula.getNombre().equals(nombrePelicula)) {
                return pelicula;
            }
        }
        
        for (Pelicula pelicula : listadoPeliculasOcupadas) {
            if (pelicula.getNombre().equals(nombrePelicula)) {
                return pelicula;
            }
        }
        return null; // La pelicula no se encontró en la lista de disponibles
    }
    
    
    //METODOS MENU ADMINISTRADOR 
    
    //AÑADIR LIBRO
    private static void agregarLibro() {
    System.out.print("Ingrese el nombre del nuevo libro: ");
    scanner.nextLine();
    String nombreLibro = scanner.nextLine();
    System.out.print("Ingrese el pasillo del nuevo libro: ");
    String pasillo = scanner.next();
    System.out.print("Ingrese la estantería del nuevo libro: ");
    String estanteria = scanner.next();
    System.out.print("Ingrese la nota del nuevo libro: ");
    String nota = scanner.next();

    // Puedes establecer disponible como true al agregar un nuevo libro
    Libro nuevoLibro = new Libro(nombreLibro, pasillo, estanteria, nota, true);
    listadoLibrosDisponible.add(nuevoLibro);

    System.out.println("Libro añadido con éxito.");
}
    
    //MODIFICAR LIBRO
    private static void modificarLibro() {
    System.out.print("Ingrese el nombre del libro que desea modificar: ");
    scanner.nextLine();
    String nombreLibro = scanner.nextLine();

    Libro libro = buscarLibroPorNombre(nombreLibro);

    if (libro != null) {
        System.out.println("Ingrese los nuevos datos para el libro:");
        System.out.print("Nuevo nombre del libro: ");
        libro.setNombre(scanner.next());
        System.out.print("Nuevo pasillo: ");
        libro.setPasillo(scanner.next());
        System.out.print("Nueva estantería: ");
        libro.setEstanteria(scanner.next());
        System.out.print("Nueva nota: ");
        libro.setNota(scanner.next());

        System.out.println("Libro modificado con éxito.");
    } else {
        System.out.println("Libro no encontrado.");
    }
}

    //BORRAR LIBRO
    private static void eliminarLibro() {
    System.out.print("Ingrese el nombre del libro que desea eliminar: ");
    scanner.nextLine();
    String nombreLibro = scanner.nextLine();

    Libro libro = buscarLibroPorNombre(nombreLibro);
    //ELIMINA LIBRO SOLO SI NO LO TIENE NADIE
    if (libro != null) {
        listadoLibrosDisponible.remove(libro);
        System.out.println("Libro eliminado con éxito.");
    } else {
        System.out.println("Libro no encontrado.");
    }
}

     // MUESTRA USUARIOS REGISTRADOS
    private static void mostrarUsuariosRegistrados() {
        System.out.println("Usuarios Registrados:");
        for (Usuario usuario : usuarios) {
            System.out.println(" - " + usuario.getNombreUsuario());
        }
    }
    
    // MODIFICAR USUARIO
    private static void modificarUsuario() {
        System.out.println("Ingrese el nombre de usuario que desea modificar: ");
        String nombreUsuario = scanner.next();

        Usuario usuario = buscarUsuarioPorNombre(nombreUsuario);

        if (usuario != null) {
            System.out.println("Ingrese los nuevos datos para el usuario:");
            System.out.print("Nuevo nombre del usuario: ");
            scanner.nextLine();
            usuario.setNombre(scanner.nextLine());
            System.out.print("Nueva edad del usuario: ");
            usuario.setEdad(scanner.nextInt());
            System.out.print("Nuevo nombre de usuario: ");
            usuario.setNombreUsuario(scanner.next());
            System.out.print("Nueva contraseña: ");
            usuario.setPassword(scanner.next());
            
            System.out.print("Nuevo tipo de usuario (A/U): ");
            char nuevoTipoUsuario;
            do {
                nuevoTipoUsuario = scanner.next().toUpperCase().charAt(0);
                if (nuevoTipoUsuario != 'A' && nuevoTipoUsuario != 'U') {
                    System.out.println("Opción no válida. Inténtalo de nuevo (A/U): ");
                }
            } while (nuevoTipoUsuario != 'A' && nuevoTipoUsuario != 'U');

        System.out.println("Usuario modificado con éxito.");
        } else {
            System.out.println("Usuario no encontrado.");
        }
    }

    // METODO PARA BUSCAR USUARIO POR NOMBRE
    private static Usuario buscarUsuarioPorNombre(String nombreUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)) {
                return usuario;
            }
        }
        return null; // El usuario no se encontró en la lista
    }

    // METODO PARA MOSTRAR LIBROS CON SU DUEÑO ACTUAL(SOLO DESDE EL MENU DE ADMIN)
    private static void mostrarLibrosConDueño() {
        System.out.println("Listado de libros ocupados y su dueño:");
        for (Libro libro : listadoLibrosOcupados) {
            System.out.println(libro.libroYDueño());
        }
    }
   
    //AÑADIR PELICULA
    private static void agregarPelicula() {
    System.out.print("Ingrese el nombre de la nueva pelicula: ");
    scanner.nextLine();
    String nombrePelicula = scanner.nextLine();
    System.out.print("Ingrese la nota de la nueva pelicula: ");
    String nota = scanner.next();

    // Puedes establecer disponible como true al agregar un nuevo libro
    Pelicula nuevaPelicula = new Pelicula(nombrePelicula, nota, true);
    listadoPeliculasDisponible.add(nuevaPelicula);

    System.out.println("Pelicula añadida con éxito.");
}
    
//MODIFICAR PELICULA
    private static void modificarPelicula() {
    System.out.print("Ingrese el nombre de la pelicula que desea modificar: ");
    scanner.nextLine();
    String nombrePelicula = scanner.nextLine();

    Pelicula pelicula = buscarPeliculaPorNombre(nombrePelicula);

    if (pelicula != null) {
        System.out.println("Ingrese los nuevos datos para el libro:");
        System.out.print("Nuevo nombre de la pelicula: ");
        pelicula.setNombre(scanner.next());
        System.out.print("Nueva nota: ");
        pelicula.setNota(scanner.next());

        System.out.println("Pelicula modificada con éxito.");
    } else {
        System.out.println("Pelicula no encontrada.");
    }
}
    
  
    //BORRAR PELICULA
    private static void eliminarPelicula() {
    System.out.print("Ingrese el nombre de la pelicula que desea eliminar: ");
    scanner.nextLine();
    String nombrePelicula = scanner.nextLine();

    Pelicula pelicula = buscarPeliculaPorNombre(nombrePelicula);
    //ELIMINA PELICULA SOLO SI NO LA TIENE NADIE
    if (pelicula != null) {
        listadoPeliculasDisponible.remove(pelicula);
        System.out.println("Pelicula eliminada con éxito.");
    } else {
        System.out.println("Pelicula no encontrada.");
    }
}


}