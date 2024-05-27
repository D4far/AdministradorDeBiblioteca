/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradordebiblioteca;

// Clase que representa un libro en una lista doblemente enlazada
public class Libro {
    private String titulo;    // Título del libro
    private String isbn;      // ISBN del libro
    private String genero;    // Género del libro
    private String autor;     // Autor del libro
    private Libro siguiente;  // Siguiente libro en la lista
    private Libro anterior;   // Libro anterior en la lista

    // Constructor que inicializa un libro con su título, ISBN, género y autor
    public Libro(String titulo, String isbn, String genero, String autor) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.genero = genero;
        this.autor = autor;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getter para obtener el título del libro
    public String getTitulo() {
        return titulo;
    }

    // Getter para obtener el ISBN del libro
    public String getIsbn() {
        return isbn;
    }

    // Getter para obtener el género del libro
    public String getGenero() {
        return genero;
    }

    // Getter para obtener el autor del libro
    public String getAutor() {
        return autor;
    }

    // Getter para obtener el siguiente libro en la lista
    public Libro getSiguiente() {
        return siguiente;
    }

    // Setter para establecer el siguiente libro en la lista
    public void setSiguiente(Libro siguiente) {
        this.siguiente = siguiente;
    }

    // Getter para obtener el libro anterior en la lista
    public Libro getAnterior() {
        return anterior;
    }

    // Setter para establecer el libro anterior en la lista
    public void setAnterior(Libro anterior) {
        this.anterior = anterior;
    }

    // Setter para establecer el título del libro
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    // Setter para establecer el ISBN del libro
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    // Setter para establecer el género del libro
    public void setGenero(String genero) {
        this.genero = genero;
    }

    // Setter para establecer el autor del libro
    public void setAutor(String autor) {
        this.autor = autor;
    }

    // Método para representar el libro como una cadena de texto
    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", genero='" + genero + '\'' +
                ", autor='" + autor + '\'' +
                '}';
    }
}
