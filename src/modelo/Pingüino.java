package modelo;

public class Pingüino extends Jugador {

    public Pingüino(int posicion, String nombre, String color) {
        super(posicion, nombre, color);
    }
//pelea pinguinos
    public void gestionarBatalla(Pingüino enemigo) {
        System.out.println("Batalla entre " + getNombre() + " y " + enemigo.getNombre());

        
        int fuerzaPropia = (int)(Math.random() * 6) + 1;
        int fuerzaEnemigo = (int)(Math.random() * 6) + 1;

        
        if (getInventario().tieneObjeto("Lanza")) fuerzaPropia += 2;
        if (enemigo.getInventario().tieneObjeto("Escudo")) fuerzaEnemigo += 1;

        
        if (fuerzaPropia > fuerzaEnemigo) {
            System.out.println(getNombre() + " gana la batalla.");
            enemigo.volverAlInicio();
        } else if (fuerzaPropia < fuerzaEnemigo) {
            System.out.println(enemigo.getNombre() + " gana la batalla.");
            volverAlInicio();
        } else {
            System.out.println("Empate. Nadie se mueve.");
        }
    }
}