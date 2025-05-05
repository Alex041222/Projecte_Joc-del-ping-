package modelo;

public class CasillaHielo extends Casilla {
    public CasillaHielo(int posicion) {
        super(posicion);
    }

    @Override
    public void realizarAccion(Jugador j) {
        System.out.println("¡Te resbalas en el hielo!");
        j.setPosicion(j.getPosicion() - 1);  // Retroceder una casilla, ejemplo de acción.
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