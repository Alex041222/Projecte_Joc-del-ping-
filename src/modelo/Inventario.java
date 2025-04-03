package modelo;

import java.util.ArrayList;

public class Inventario {
	
	private ArrayList<Item> lista; // Lista para guardar los items

    // Constructor: Inicializa el inventario como una lista vacía
    public Inventario() {
        this.lista = new ArrayList<>();
    }

    // Para obtener la lista de items
    public ArrayList<Item> getLista() {
        return lista;
    }

    // Para establecer una nueva lista de items
    public void setLista(ArrayList<Item> lista) {
        this.lista = lista;
    }

    // Método para agregar un item al inventario
    public void agregarItem(Item item) {
        lista.add(item);
    }

    // Para mostrar los items del inventario
    public void mostrarInventario() {
        for (Item item : lista) {
            System.out.println(item);
        }
    }
}
