/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package administradordebiblioteca;

// Clase que representa un nodo en una lista doblemente enlazada
public class Nodo {
    private Libro libro;      // El libro contenido en este nodo
    private Nodo siguiente;   // El siguiente nodo en la lista
    private Nodo anterior;    // El nodo anterior en la lista

    // Constructor que inicializa el nodo con un libro y sin nodos siguientes o anteriores
    public Nodo(Libro libro) {
        this.libro = libro;
        this.siguiente = null;
        this.anterior = null;
    }

    // Getter para obtener el libro contenido en este nodo
    public Libro getLibro() {
        return libro;
    }

    // Getter para obtener el siguiente nodo
    public Nodo getSiguiente() {
        return siguiente;
    }

    // Setter para establecer el siguiente nodo
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    // Getter para obtener el nodo anterior
    public Nodo getAnterior() {
        return anterior;
    }

    // Setter para establecer el nodo anterior
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
}