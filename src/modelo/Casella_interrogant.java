package modelo;


	import java.util.Random;

	public class Casella_interrogant extends Casilla {
	    private static final Random rand = new Random();
	    
	    public Casella_interrogant(int posicion ,int posInterrogante) {
	        super(posicion);
	    }
		

		@Override
	    public void realizarAccion(Jugador jugador) {
	        System.out.println(jugador.getNombre() + " ha caído en una casilla de interrogación. ¡Evento aleatorio activado!");
	        activarEventoAleatorio(jugador);
	    }

	    private void activarEventoAleatorio(Jugador jugador) {
	        int evento = rand.nextInt(100); // Valor aleatorio entre 0-99
	        Inventario inventario = jugador.getInventario();
	        Tablero tablero = jugador.getTablero();
	        
	        if (evento < 5) { // 5% - Dau ràpid (5-10 casillas)
	            int avance = 5 + rand.nextInt(6);
	            System.out.println("EVENTO: Dau ràpid! Avanzas " + avance + " casillas.");
	            tablero.moverJugador(jugador, avance);
	        } 
	        else if (evento < 35) { // 30% - Dau lent (1-3 casillas)
	            int avance = 1 + rand.nextInt(3);
	            System.out.println("EVENTO: Dau lent. Avanzas " + avance + " casillas.");
	            tablero.moverJugador(jugador, avance);
	        } 
	        else if (evento < 65) { // 30% - Boles de neu (1-3)
	            int boles = 1 + rand.nextInt(3);
	            for (int i = 0; i < boles; i++) {
	                inventario.agregarItem(new Item(null, i)); // Corregido: agregarItem
	            }
	            System.out.println("EVENTO: Obtienes " + boles + " boles de neu.");
	        } 
	        else { // 35% - Peix
	            inventario.agregarItem(new Item(null, evento)); // Corregido: agregarItem
	            System.out.println("EVENTO: Obtienes un peix!");
	        }
	        
	        // Mostrar inventario actualizado
	        System.out.println("\nInventario actualizado:");
	        mostrarContenidoInventario(inventario);
	    }
//mostre el invenati
	    private void mostrarContenidoInventario(Inventario inventario) {
	        int bolasNieve = contarItems(inventario, "Bola de Nieve");
	        int peces = contarItems(inventario, "Peix");
	        
	        System.out.println(" - Boles de neu: " + bolasNieve);
	        System.out.println(" - Peixos: " + peces);
	    }
//mostre el numero de items
	    private int contarItems(Inventario inventario, String nombreItem) {
	        int contador = 0;
	        for (Item item : inventario.getLista()) {
	            if (item.getNombre().equalsIgnoreCase(nombreItem)) {
	                contador++;
	            }
	        }
	        return contador;
	    }
	}