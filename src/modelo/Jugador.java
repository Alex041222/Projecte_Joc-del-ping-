package modelo;

public class Jugador {
    private int posicion;  // Cambiado a minúscula para seguir convenciones
    private String nombre; // Cambiado a minúscula
    private String color;  // Cambiado a minúscula
    private Inventario inventario;
    
    public Jugador(int posicion, String nombre, String color) {
        this.posicion = posicion;  // Asignación directa
        this.nombre = nombre;      // Asignación directa
        this.color = color;        // Asignación directa
        this.inventario = new Inventario();
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

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public void tirarDado() {
        Item dadoRapido = null;
        Item dadoLento = null;
        
        // Buscar items de dado rápido y lento en el inventario
        for (Item item : inventario.getLista()) {
            if (item.getNombre().equalsIgnoreCase("dado rápido") && item.getCantidad() > 0) {
                dadoRapido = item;
            } else if (item.getNombre().equalsIgnoreCase("dado lento") && item.getCantidad() > 0) {
                dadoLento = item;
            }
        }
        
        int resultado;
        String tipoDado = "normal";
        
        // Determinar qué tipo de dado lanzar
        if (dadoRapido != null) {
            // Dado rápido: 4-6
            resultado = 4 + (int)(Math.random() * 3); // 4, 5 o 6
            tipoDado = "rápido";
            // Consumir 1 unidad
            dadoRapido.setCantidad(dadoRapido.getCantidad() - 1);
            // Eliminar item si la cantidad llega a 0
            if (dadoRapido.getCantidad() <= 0) {
                inventario.getLista().remove(dadoRapido);
            }
        } else if (dadoLento != null) {
            // Dado lento: 1-3
            resultado = 1 + (int)(Math.random() * 3); // 1, 2 o 3
            tipoDado = "lento";
            // Consumir 1 unidad
            dadoLento.setCantidad(dadoLento.getCantidad() - 1);
            // Eliminar item si la cantidad llega a 0
            if (dadoLento.getCantidad() <= 0) {
                inventario.getLista().remove(dadoLento);
            }
        } else {
            // Dado normal: 1-6
            resultado = 1 + (int)(Math.random() * 6); // 1, 2, 3, 4, 5 o 6
        }
        
        System.out.println(nombre + " usa dado " + tipoDado + " y obtiene: " + resultado);
        
        // Actualizar posición del jugador
        this.posicion += resultado;
    }
}