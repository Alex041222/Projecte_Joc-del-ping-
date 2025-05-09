package modelo;

public class Jugador {
    private int posicion;  
    private String nombre; 
    private String color; 
    private Inventario inventario;
    private Tablero tablero;  // Referencia al tablero del jugador
    
    public Jugador(int posicion, String nombre, String color) {
        this.posicion = posicion;
        this.nombre = nombre;
        this.color = color;
        this.inventario = new Inventario();  // Esto asumiendo que la clase Inventario está definida.
    }

    public int getPosicion() {
        return posicion;
    }

    public void setPosicion(int posicion) {
        this.posicion = posicion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getColor() {
        return color;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void tirarDado() {
        int resultado = 1 + (int)(Math.random() * 6); 
        System.out.println(nombre + " lanza el dado y obtiene: " + resultado);
        this.posicion += resultado;
    }

    public void volverAlInicio() {
        System.out.println(nombre + " vuelve al inicio.");
        this.posicion = 0;
    }
}