/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package administradordebiblioteca;

import java.util.Scanner;

public class AdministradorDeBiblioteca {
    private Libros libros; // Almacena la colección de libros

    public AdministradorDeBiblioteca() {
        this.libros = new Libros(); // Inicializa la colección de libros
    }

    public boolean iniciarSesion(String id) {
        id = id.trim(); // Elimina espacios en blanco alrededor del ID
        return id.matches("\\d{10}"); // Verifica si el ID contiene exactamente 10 dígitos
    }

    public static void main(String[] args) {
        AdministradorDeBiblioteca admin = new AdministradorDeBiblioteca(); // Crea una instancia del administrador
        Scanner scanner = new Scanner(System.in); // Crea un scanner para leer entradas del usuario
        String id;
        boolean sesionIniciada = false;

        do {
            // Muestra mensajes de bienvenida y condiciones para ingresar el ID
            System.out.println("\nBIENVENID@ AL ADMINISTRADOR DE BIBLIOTECA DE LA AUTONOMA: ");
            System.out.println("\nPara ingresar debe digitar su ID con las siguientes condiciones:");
            System.out.println("- Debe de tener 10 caracteres numericos.");
            System.out.println("- No debe de tener ni espacios en blanco ni saltos de linea.");
            System.out.print("\nDigite su ID: ");
            id = scanner.nextLine();// Lee el ID ingresado por el usuario

            if (admin.iniciarSesion(id)) {
                sesionIniciada = true; // Inicia sesión si el ID es válido
            } else {
                // Muestra mensaje de error si el ID es inválido
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.println("\nID invalido. Debe tener 10 caracteres numericos y no contener espacios en blanco ni saltos de linea.");
            }
        } while (!sesionIniciada); // Repite hasta que se inicie sesión correctamente

        int opcion;
        String input;
        do {
            // Muestra el menú de opciones
            System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
            System.out.println("\nOpciones:");
            System.out.println("1. Agregar libro al inicio");
            System.out.println("2. Agregar libro al final");
            System.out.println("3. Eliminar libro por ISBN");
            System.out.println("4. Mostrar lista de libros");
            System.out.println("5. Actualizar libro");
            System.out.println("6. Salir");
            System.out.print("\nDigite una opcion: ");

            input = scanner.nextLine().trim(); // Lee la opción ingresada por el usuario

            if (input.matches("[1-6]")) {
                opcion = Integer.parseInt(input); // Convierte la opción a un entero
                switch (opcion) {
                    case 1:
                        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                        System.out.println("\nVALIDANDO DATOS: ");
                        System.out.println("\nPara ingresar un libro debe de tener presente: ");
                        System.out.println("\n- Los titulos deben de tener mas de tres caracteres, sin saltos de linea.");
                        System.out.println("\n- El ISBN debe de contener 5 numeros, nada de espacios ni saltos de linea.");
                        System.out.println("\n- El genero no debe de contener saltos de linea ni numeros.");
                        System.out.println("\n- El autor no debe de tener saltos de linea.");
                        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                        System.out.print("\nIngrese el titulo del libro: ");
                        String tituloInicio = scanner.nextLine();
                        System.out.print("\nIngrese el ISBN del libro (5 caracteres numericos): ");
                        String isbnInicio = scanner.nextLine();
                        System.out.print("\nIngrese el genero del libro: ");
                        String generoInicio = scanner.nextLine();
                        System.out.print("\nIngrese el autor del libro: ");
                        String autorInicio = scanner.nextLine();                       
                        admin.libros.agregarLibroAlInicio(tituloInicio, isbnInicio, generoInicio, autorInicio);// Agrega el libro al inicio
                        break;
                    case 2:
                        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                        System.out.println("\nVALIDANDO DATOS: ");
                        System.out.println("\nPara ingresar un libro debe de tener presente: ");
                        System.out.println("\n- Los titulos deben de tener mas de tres caracteres, sin saltos de linea.");
                        System.out.println("\n- El ISBN debe de contener 5 numeros, nada de espacios ni saltos de linea.");
                        System.out.println("\n- El genero no debe de contener saltos de linea ni numeros.");
                        System.out.println("\n- El autor no debe de tener saltos de linea.");
                        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                        System.out.print("\nIngrese el titulo del libro: ");
                        String tituloFinal = scanner.nextLine();
                        System.out.print("\nIngrese el ISBN del libro (5 caracteres numericos): ");
                        String isbnFinal = scanner.nextLine();
                        System.out.print("\nIngrese el genero del libro: ");
                        String generoFinal = scanner.nextLine();
                        System.out.print("\nIngrese el autor del libro: ");
                        String autorFinal = scanner.nextLine();
                        admin.libros.agregarLibroAlFinal(tituloFinal, isbnFinal, generoFinal, autorFinal);// Agrega el libro al final
                        break;
                    case 3:
                        // Lee el ISBN del libro a eliminar y elimina el libro correspondiente
                        System.out.print("\nIngrese el ISBN del libro a eliminar (5 caracteres numericos): ");
                        String isbnEliminar = scanner.nextLine();
                        admin.libros.eliminarLibroPorISBN(isbnEliminar);// Elimina el libro por ISBN
                        break;
                    case 4:
                        admin.libros.mostrarLibros();// Muestra la lista de libros
                        break;
                    case 5:
                        admin.actualizarLibro(scanner);// Actualiza la información de un libro
                        break;
                    case 6:
                        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                        System.out.println("\nSaliendo del programa, vuelva pronto...");
                        break;
                }
            } else {
                // Muestra mensaje de error si la opción es inválida
                System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
                System.out.println("\nOpción invalida. Debe ser un numero entre 1 y 6.");
            }
        } while (!input.equals("6"));

        scanner.close();// Cierra el scanner
    }

    private void actualizarLibro(Scanner scanner) {
    boolean isbnValido = false;
    String isbn = "";

    // Validar ISBN
    while (!isbnValido) {
        System.out.print("\nIngrese el ISBN del libro a actualizar (5 caracteres numericos): ");
        isbn = scanner.nextLine().trim();

        if (!isbn.matches("\\d{5}")) {
            System.out.println("\nISBN invalido. Debe tener exactamente 5 caracteres numericos.");
        } else if (!libros.existeISBN(isbn)) {
            System.out.println("\nISBN no encontrado.");
            return; // Regresar al menú principal
        } else {
            isbnValido = true;
        }
    }

    boolean actualizar = true;
    while (actualizar) {
        // Muestra el menú de actualización
        System.out.println("-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_-_");
        System.out.println("\nMENU DE ACTUALIZACION:");
        System.out.println("1. Actualizar título");
        System.out.println("2. Actualizar ISBN");
        System.out.println("3. Actualizar genero");
        System.out.println("4. Actualizar autor");
        System.out.println("5. Volver al menu principal");
        System.out.print("\nDigite una opcion: ");

        String opcionActualizacion = scanner.nextLine().trim();

        switch (opcionActualizacion) {
            case "1":
                // Actualiza el título del libro
                System.out.print("\nIngrese el nuevo titulo del libro: ");
                String nuevoTitulo = scanner.nextLine().trim();
                if (nuevoTitulo.length() < 3) {
                    System.out.println("\nTitulo invalido. Debe tener al menos 3 caracteres.");
                } else {
                    libros.actualizarTitulo(isbn, nuevoTitulo);
                    actualizar = false;
                }
                break;
            case "2":
                // Actualiza el ISBN del libro
                System.out.print("\nIngrese el nuevo ISBN del libro (5 caracteres numericos): ");
                String nuevoISBN = scanner.nextLine().trim();
                if (!nuevoISBN.matches("\\d{5}")) {
                    System.out.println("\nISBN invalido. Debe tener exactamente 5 caracteres numericos.");
                } else if (libros.existeISBN(nuevoISBN)) {
                    System.out.println("\nISBN ya existe en otro libro.");
                } else {
                    libros.actualizarISBN(isbn, nuevoISBN);
                    actualizar = false;
                }
                break;
            case "3":
                 // Actualiza el género del libro
                System.out.print("\nIngrese el nuevo genero del libro: ");
                String nuevoGenero = scanner.nextLine().trim();
                if (nuevoGenero.isBlank()) {
                    System.out.println("\nGenero invalido. Debe ingresar un genero.");
                } else if (nuevoGenero.matches(".*\\d.*")) {
                    System.out.println("\nGenero invalido. No debe contener numeros.");
                } else {
                    libros.actualizarGenero(isbn, nuevoGenero);
                    actualizar = false;
                }
                break;
            case "4":
                // Actualiza el autor del libro
                System.out.print("\nIngrese el nuevo autor del libro: ");
                String nuevoAutor = scanner.nextLine().trim();
                if (nuevoAutor.isBlank()) {
                    System.out.println("\nAutor invalido. Debe ingresar un autor.");
                } else {
                    libros.actualizarAutor(isbn, nuevoAutor);
                    actualizar = false;
                }
                break;
            case "5":
                actualizar = false;
                break;
            default:
                System.out.println("\nOpcion invalida. Debe ser un número entre 1 y 5.");
            }
        }
    }
}
