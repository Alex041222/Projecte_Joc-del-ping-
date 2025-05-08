package modelo;

import java.util.ArrayList;

public class Inventario {

    private ArrayList<Item> lista;

    public Inventario() {
        this.lista = new ArrayList<>();
    }

    public ArrayList<Item> getLista() {
        return lista;
    }

    public void agregarItem(Item item) {
        lista.add(item);
    }

    public void eliminarItem(Item item) {
        lista.remove(item);
    }

    public boolean tieneObjeto(String nombre) {
        return lista.stream().anyMatch(i -> i.getNombre().equalsIgnoreCase(nombre));
    }
}