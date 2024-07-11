package m8ex5_frank_pulido;

public class Punto {
	
	
	// Atributos
	
	private double coordX;
	private double coordY;
	
	// Constructor
	
	public Punto (double coordX, double coordY) {
		this.coordX = coordX;
		this.coordY = coordY;
	}
	
	// Getters
	
	public double getCoordX() {
		return this.coordX;
	}
	
	public double getCoordY() {
		return this.coordY;
	}
	
	// Setters
	
	public void setCoordX(int coordX) {
		this.coordX = coordX;
	}
	
	public void setCoordY(int coordY) {
		this.coordY = coordY;
	}

	
}
