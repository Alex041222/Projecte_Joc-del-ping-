package modelo;

public class Trineo extends Casilla {

    public Trineo(int posicion) {
        super(posicion);
    }

    @Override
    public void realizarAccion(Jugador jugador) {
        // Suponiendo que el jugador avanza 3 casillas al caer en el trineo
        int avance = 3;
        int nuevaPos = jugador.getPosicion() + avance;

        // Asegúrate de no salirse del tablero
        Tablero tablero = jugador.getTablero();  // Obtener el tablero del jugador
        if (nuevaPos >= tablero.getCasillas().size()) {
            nuevaPos = tablero.getCasillas().size() - 1; // Límite superior del tablero
        }

        jugador.setPosicion(nuevaPos);
        System.out.println(jugador.getNombre() + " se desliza en el trineo y avanza " + avance + " casillas.");

        // Realiza la acción de la casilla a la que ha llegado
        Casilla casillaDestino = tablero.getCasillas().get(nuevaPos);
        casillaDestino.realizarAccion(jugador);
    }
}