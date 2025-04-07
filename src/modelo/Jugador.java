package modelo;

public class Jugador {
    private int Posicion;  
    private String Nombre; 
    private String Color; 
    private Inventario inventario;
    
    public Jugador(int Posicion, String Nombre, String Color) {
        this.Posicion = Posicion;  
        this.Nombre = Nombre;      
        this.Color = Color;        
        this.inventario = new Inventario();
    }

    public int getPosicion() {
        return Posicion;
    }

    public void setPosicion(int Posicion) {
        this.Posicion = Posicion;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        this.Color = color;
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
        
        
        for (Item item : inventario.getLista()) {
            if (item.getNombre().equalsIgnoreCase("dado rápido") && item.getCantidad() > 0) {
                dadoRapido = item;
            } else if (item.getNombre().equalsIgnoreCase("dado lento") && item.getCantidad() > 0) {
                dadoLento = item;
            }
        }
        
        int resultado;
        String tipoDado = "normal";
        
       
        if (dadoRapido != null) {
            
            resultado = 4 + (int)(Math.random() * 3); 
            tipoDado = "rápido";
            dadoRapido.setCantidad(dadoRapido.getCantidad() - 1);
            if (dadoRapido.getCantidad() <= 0) {
                inventario.getLista().remove(dadoRapido);
            }
            
    	} else if (dadoLento != null) {
            resultado = 1 + (int)(Math.random() * 3);
            tipoDado = "lento";
            dadoLento.setCantidad(dadoLento.getCantidad() - 1);
         
            if (dadoLento.getCantidad() <= 0) {
                inventario.getLista().remove(dadoLento);
            }
            
        } else {
   
            resultado = 1 + (int)(Math.random() * 6); 
        }
        
        System.out.println(Nombre + " usa dado " + tipoDado + " y obtiene: " + resultado);
        
        this.Posicion += resultado;
    }
}