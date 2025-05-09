package modelo;

public class Agujero extends Casilla {

    public Agujero(int posicion) {
        super(posicion);
    }

    @Override
    public void realizarAccion(Jugador jugador) {
        // El jugador cae en un agujero y regresa al inicio
        System.out.println(jugador.getNombre() + " ha caído en un agujero y regresa al inicio.");
        jugador.setPosicion(0);  // El jugador vuelve a la casilla 0

        // Ejecuta la acción de la casilla 0
        Tablero tablero = jugador.getTablero();  // Obtener el tablero del jugador
        Casilla casillaDestino = tablero.getCasillas().get(0);  // La casilla de inicio (casilla 0)
        casillaDestino.realizarAccion(jugador);  // Realiza la acción en la casilla 0
    }
}