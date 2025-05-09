package modelo;

public class Probar_juego {
    public static void main(String[] args) {
        Tablero tablero = new Tablero();

        // Crear pingüinos
        Pingüino pinguino1 = new Pingüino(0, "Pinguino1", "Azul");

        // Agregar jugadores
        tablero.agregarJugador(pinguino1);
        
        // Ejecutar turnos de ejemplo
        for (int i = 0; i < 5; i++) {  // 5 turnos de prueba
            tablero.ejecutarTurnoActual();
            System.out.println("---------------------------");
        }
    }
}