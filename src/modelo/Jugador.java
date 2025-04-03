package modelo;

public class Jugador {

<<<<<<< Updated upstream
=======
	private int Posicion;
	private String Nombre;
	private String Color;
	
	 public Jugador( int Posicion, String Nombre,String color) {
			this.setPosicion(Posicion);
			this.setNombre(Nombre);
			this.setColor(color);
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

	public void setNombre(String Nombre) {
		this.Nombre = Nombre;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String Color) {
		this.Color = Color;
	}
	
	public void tirarDado(String tipo_dado) {
		
	}
	
	public void moverPosicion(int p) {
		
		this.Posicion=this.Posicion+p;
	}
	
	
	
	
	
	
	
	
	
>>>>>>> Stashed changes
}
