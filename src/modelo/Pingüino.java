package modelo;

public class Pingüino extends Jugador {
    private Inventario inventario;

    public Pingüino(int Posicion, String Nombre, String Color) {
        super(Posicion, Nombre, Color); // Llamo al constructor del Jugador
        this.inventario = new Inventario();    
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void gestionarBatalla() {
        // Implementa lógica para gestionar batalla
        System.out.println("Gestionando la batalla...");
    }

    public void usarObjeto() {
        // Implementa lógica para usar un objeto del inventario
        System.out.println("Usando objetos del inventario...");
    }

    public void añadirItem(Item item) {
        // Implementa lógica para añadir un item al inventario
        System.out.println("Añadiendo item: " + item.getNombre());
        inventario.agregarItem(item);
    }

    public void quitarItem(Item item) {
        // Implementa lógica para quitar un item del inventario
        System.out.println("Quitando item: " + item.getNombre());
        inventario.eliminarItem(item);
    }
}