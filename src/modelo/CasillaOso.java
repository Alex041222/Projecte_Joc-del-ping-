package modelo;

public class CasillaOso extends Casilla {
    public CasillaOso(int posicion) {
        super(posicion);
    }

    @Override
    public void realizarAccion(Jugador j) {
        System.out.println("¡Un oso ha atacado! Regresas al inicio.");
        j.volverAlInicio();  // El jugador vuelve al inicio
    }

    @Override
    public void añadirJugador(Jugador j) {
        getJugadoresActuales().add(j);
    }

    @Override
    public void quitarJugador(Jugador j) {
        getJugadoresActuales().remove(j);
    }
}