/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradordebiblioteca;

// Clase que maneja una lista doblemente enlazada de libros
public class Libros {
    private Nodo cabeza; // Primer nodo de la lista
    private Nodo cola;   // Último nodo de la lista

    // Constructor que inicializa una lista vacía
    public Libros() {
        this.cabeza = null;
        this.cola = null;
    }

    // Método para agregar un libro al inicio de la lista
    public void agregarLibroAlInicio(String titulo, String isbn, String genero, String autor) {
        titulo = titulo.trim();
        isbn = isbn.trim();
        genero = genero.trim();
        autor = autor.trim();

        // Validaciones para el título
        if (titulo.length() < 3 || titulo.contains("\n")) {
            System.out.println("\nTitulo invalido. Debe tener al menos 3 caracteres y no contener saltos de linea.");
            return;
        }

        // Verificar si el título ya existe
        if (existeTitulo(titulo)) {
            System.out.println("\nTitulo invalido. Ya existe un libro con este titulo.");
            return;
        }

        // Validaciones para el ISBN
        if (!isbn.matches("\\d{5}") || isbn.contains("\n")) {
            System.out.println("\nISBN invalido. Debe tener 5 caracteres numericos y no contener saltos de linea.");
            return;
        }

        // Verificar si el ISBN ya existe
        if (existeISBN(isbn)) {
            System.out.println("\nISBN invalido. Ya existe un libro con este ISBN.");
            return;
        }

        // Validaciones para el género
        if (genero.isBlank()) {
            System.out.println("\nGenero invalido. Debe ingresar un genero.");
            return;
        }

        if (genero.matches(".*\\d.*") || genero.contains("\n")) {
            System.out.println("\nGenero invalido. No debe contener numeros ni saltos de linea.");
            return;
        }

        // Validaciones para el autor
        if (autor.isBlank()) {
            System.out.println("\nAutor invalido. Debe ingresar un autor.");
            return;
        }

        if (autor.contains("\n")) {
            System.out.println("\nAutor invalido. No debe contener saltos de linea.");
            return;
        }

        // Crear el nuevo libro y nodo
        Libro nuevoLibro = new Libro(titulo, isbn, genero, autor);
        Nodo nuevoNodo = new Nodo(nuevoLibro);
        
        // Si la lista está vacía, el nuevo nodo es cabeza y cola
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            nuevoNodo.setSiguiente(cabeza);
            cabeza.setAnterior(nuevoNodo);
            cabeza = nuevoNodo;
        }
        System.out.println("\nLibro agregado exitosamente.");
    }

    // Método para agregar un libro al final de la lista
    public void agregarLibroAlFinal(String titulo, String isbn, String genero, String autor) {
        titulo = titulo.trim();
        isbn = isbn.trim();
        genero = genero.trim();
        autor = autor.trim();

        // Validaciones para el título
        if (titulo.length() < 3 || titulo.contains("\n")) {
            System.out.println("\nTitulo invalido. Debe tener al menos 3 caracteres y no contener saltos de linea.");
            return;
        }

        // Verificar si el título ya existe
        if (existeTitulo(titulo)) {
            System.out.println("\nTitulo invalido. Ya existe un libro con este titulo.");
            return;
        }

        // Validaciones para el ISBN
        if (!isbn.matches("\\d{5}") || isbn.contains("\n")) {
            System.out.println("\nISBN invalido. Debe tener 5 caracteres numericos y no contener saltos de linea.");
            return;
        }

        // Verificar si el ISBN ya existe
        if (existeISBN(isbn)) {
            System.out.println("\nISBN invalido. Ya existe un libro con este ISBN.");
            return;
        }

        // Validaciones para el género
        if (genero.isBlank()) {
            System.out.println("\nGenero invalido. Debe ingresar un genero.");
            return;
        }

        if (genero.matches(".*\\d.*") || genero.contains("\n")) {
            System.out.println("\nGenero invalido. No debe contener numeros ni saltos de linea.");
            return;
        }

        // Validaciones para el autor
        if (autor.isBlank()) {
            System.out.println("\nAutor invalido. Debe ingresar un autor.");
            return;
        }

        if (autor.contains("\n")) {
            System.out.println("\nAutor invalido. No debe contener saltos de linea.");
            return;
        }

        // Crear el nuevo libro y nodo
        Libro nuevoLibro = new Libro(titulo, isbn, genero, autor);
        Nodo nuevoNodo = new Nodo(nuevoLibro);
        
        // Si la lista está vacía, el nuevo nodo es cabeza y cola
        if (cola == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(cola);
            cola = nuevoNodo;
        }
        System.out.println("\nLibro agregado exitosamente.");
    }

    // Método para eliminar un libro por su ISBN
    public void eliminarLibroPorISBN(String isbn) {
        isbn = isbn.trim();

        // Validación para el ISBN
        if (!isbn.matches("\\d{5}") || isbn.contains("\n")) {
            System.out.println("\nISBN invalido. Debe tener 5 caracteres numericos y no contener saltos de linea.");
            return;
        }

        Nodo actual = cabeza;

        // Buscar el nodo con el ISBN especificado
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                if (actual == cabeza) {
                    cabeza = actual.getSiguiente();
                    if (cabeza != null) {
                        cabeza.setAnterior(null);
                    } else {
                        cola = null;
                    }
                } else if (actual == cola) {
                    cola = actual.getAnterior();
                    if (cola != null) {
                        cola.setSiguiente(null);
                    } else {
                        cabeza = null;
                    }
                } else {
                    actual.getAnterior().setSiguiente(actual.getSiguiente());
                    actual.getSiguiente().setAnterior(actual.getAnterior());
                }
                System.out.println("\nISBN eliminado exitosamente.");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("\nISBN no encontrado.");
    }

    // Método para mostrar todos los libros en la lista
    public void mostrarLibros() {
        if (cabeza == null) {
            System.out.println("\nNo hay libros en la biblioteca.");
            return;
        }

        Nodo actual = cabeza;

        // Recorrer y mostrar todos los libros
        while (actual != null) {
            System.out.println(actual.getLibro());
            actual = actual.getSiguiente();
        }
    }

    // Método para actualizar el título de un libro por su ISBN
    public void actualizarTitulo(String isbn, String nuevoTitulo) {
        Nodo actual = cabeza;

        // Buscar el nodo con el ISBN especificado
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                actual.getLibro().setTitulo(nuevoTitulo);
                System.out.println("\nTitulo actualizado exitosamente.");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("\nISBN no encontrado.");
    }

    // Método para actualizar el ISBN de un libro
    public void actualizarISBN(String isbn, String nuevoISBN) {
        Nodo actual = cabeza;

        // Buscar el nodo con el ISBN especificado
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                actual.getLibro().setIsbn(nuevoISBN);
                System.out.println("\nISBN actualizado exitosamente.");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("\nISBN no encontrado.");
    }

    // Método para actualizar el género de un libro
    public void actualizarGenero(String isbn, String nuevoGenero) {
        Nodo actual = cabeza;

        // Buscar el nodo con el ISBN especificado
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                actual.getLibro().setGenero(nuevoGenero);
                System.out.println("\nGenero actualizado exitosamente.");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("\nISBN no encontrado.");
    }

    // Método para actualizar el autor de un libro
    public void actualizarAutor(String isbn, String nuevoAutor) {
        Nodo actual = cabeza;

        // Buscar el nodo con el ISBN especificado
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                actual.getLibro().setAutor(nuevoAutor);
                System.out.println("\nAutor actualizado exitosamente.");
                return;
            }
            actual = actual.getSiguiente();
        }
        System.out.println("\nISBN no encontrado.");
    }

    // Método para verificar si un título ya existe en la lista
    public boolean existeTitulo(String titulo) {
        Nodo actual = cabeza;

        // Recorrer y buscar el título especificado
        while (actual != null) {
            if (actual.getLibro().getTitulo().equalsIgnoreCase(titulo)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }

    // Método para verificar si un ISBN ya existe en la lista
    public boolean existeISBN(String isbn) {
        Nodo actual = cabeza;

        // Recorrer y buscar el ISBN especificado
        while (actual != null) {
            if (actual.getLibro().getIsbn().equals(isbn)) {
                return true;
            }
            actual = actual.getSiguiente();
        }
        return false;
    }
}
