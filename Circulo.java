package m8ex5_frank_pulido;



public class Circulo {
	
	
	// Atributos
	
	private Punto centro;
	private double radio;
	
	// Constructor
	
	public Circulo (Punto centro, double radio) {
		this.centro = centro;
		this.radio = radio;
	}
	
	// Getters
	
	public Punto getCentro() {
		return this.centro;
	}
	
	public double getRadio() {
		return this.radio;
	}
	
	// Setters
	
	public void setCentro(Punto centro) {
		this.centro = centro;
	}
	
	public void setRadio(int radio) {
		this.radio = radio;
	}
	
	
	////// Métodos propios
	
	
	// STRING Grado de intersección
	
	public String interseccion(Circulo circuloComparar) {
		double sumaRadios = this.getRadio() + circuloComparar.getRadio();
		double interseccion = this.distanciaCentros(circuloComparar) - sumaRadios;
		String reply = "";
		
		if (interseccion > 0) {
			reply = "Los círculos son ajenos : No se intersectan y tampoco se encuentra uno interior al otro, no existe solapamiento entre sus áreas.";
		}
		else if (this.circulosIguales(circuloComparar)) {
			reply = "Al ser IGUALES los círculos se intersectan en TODOS los puntos de su circunferencia.";
		}
		else if (this.concentrico(circuloComparar) && (this.getRadio() > circuloComparar.getRadio())) {
			reply = "Al ser CONCÉNTRICOS y tener el círculo de referencia un MAYOR radio que el de prueba, el área del círculo de prueba está embebida\n"
					+ "en el de referencia sin existir intersección entre sus circunferencias.";
		}
		else if (this.concentrico(circuloComparar) && (this.getRadio() < circuloComparar.getRadio())) {
			reply = "Al ser CONCÉNTRICOS y tener el círculo de referencia un MENOR radio que el de prueba, el área del círculo de referencia está embebida\n"
					+ "en el de prueba sin existir intersección entre sus circunferencias.";
		}
		else if (this.distanciaCentros(circuloComparar) == sumaRadios) {
			reply = "Los círculos son tangentes. La distancia entre sus centros es IGUAL a la suma de sus radios.";
		}
		else if(this.getRadio() > (this.distanciaCentros(circuloComparar) + circuloComparar.getRadio())) {
			reply = "El círculo de prueba está completamente embebido en el de referencia que es mayor y no se intersectan.";
		}
		else if(this.getRadio() == (this.distanciaCentros(circuloComparar) + circuloComparar.getRadio())) {
			reply = "El círculo de prueba está completamente embebido en el de referencia que es mayor y son tangentes"
					+ " (sus circunferencias poseen un único punto de intersección).";
		}
		else if(circuloComparar.getRadio() > (this.distanciaCentros(circuloComparar) + this.getRadio())) {
			reply = "El círculo de referencia está completamente embebido en el de prueba que es mayor y no se intersectan.";
		}
		else if(circuloComparar.getRadio() == this.distanciaCentros(circuloComparar) + this.getRadio()) {
			reply = "El círculo de referencia está completamente embebido en el de prueba que es mayor y son tangentes"
					+ " (sus circunferencias poseen un único punto de intersección).";
		}
		else if (this.secante(circuloComparar)){
			reply = "El círculo de referencia y el de prueba son \"secantes\", están parcialmente solapados por lo que poseen dos puntos de intersección.";
		}
		else {
			reply = "Si aparece este mensaje es que he dejado de considerar algún caso.";
		}
		
		return reply;
	}
	
	
	// Método 1.2 círculos iguales
	
	public boolean circulosIguales(Circulo circuloComparar) {
		boolean iguales = (this.distanciaCentros(circuloComparar) == 0 && radiosIguales(circuloComparar));
		return iguales;
	}
	
	// Método círculos de igual radio
	
	public boolean radiosIguales (Circulo circuloComparar) {
		boolean radiosIguales = (this.getRadio() == circuloComparar.getRadio())? true : false;
		return radiosIguales;
	}
	
	// Método 1.1 círculos concéntricos
	
	public boolean concentrico (Circulo circuloComparar) {
		boolean concentricos = (this.distanciaCentros(circuloComparar) == 0)? true : false;
		return concentricos;
	}
	
	// Método Caso 2.1 : embebido
	
	public boolean embebido (Circulo circuloComparar) {
		boolean embebido1 = false;
		boolean embebido2 = false;
		double embebidoComparar = this.getRadio() - (this.distanciaCentros(circuloComparar) + circuloComparar.getRadio());
		double embebidoReferencia = circuloComparar.getRadio() - (this.distanciaCentros(circuloComparar) + this.getRadio());
		embebido1 = (embebidoComparar > 0)? true : false;
		embebido2 = (embebidoReferencia > 0)? true : false;
		return (embebido1 || embebido2)? true : false;
	}
	
	// Método Caso 2.2 : tangente embebido (interior)
	
	public boolean embebidoTangente (Circulo circuloComparar) {
		boolean tangente1 = false;
		boolean tangente2 = false;
		double embebidoTangente1 = this.getRadio() - (this.distanciaCentros(circuloComparar) + circuloComparar.getRadio());
		double embebidoTangente2 = circuloComparar.getRadio() - (this.distanciaCentros(circuloComparar) + this.getRadio());
		tangente1 = (embebidoTangente1 == 0)? true : false;
		tangente2 = (embebidoTangente2 == 0)? true : false;
		return (tangente1 || tangente2)? true : false;
	}
	
	// Método Caso 2.3 : secantes

	public boolean secante (Circulo circuloComparar) {
		double sumaRadios = this.getRadio() + circuloComparar.getRadio();
		double interseccion = this.distanciaCentros(circuloComparar) - sumaRadios;
		return (interseccion < 0)? true : false;
	}
	
	// Método Caso 2.4 : tangente exterior
	
	public boolean tangente (Circulo circuloComparar) {
		double sumaRadios = this.getRadio() + circuloComparar.getRadio();
		double interseccion = this.distanciaCentros(circuloComparar) - sumaRadios;
		return (interseccion == 0)? true : false;
	}

	// Método Caso 2.5 : ajeno

	public boolean ajeno (Circulo circuloComparar) {
		double sumaRadios = this.getRadio() + circuloComparar.getRadio();
		double interseccion = this.distanciaCentros(circuloComparar) - sumaRadios;
		return (interseccion > 0)? true : false;
	}
	
	// Método Tangentes SIN importar posición relativa (interior o exterior)
	
	public boolean tangenteInteriorExterior (Circulo circuloComparar) {
		boolean tangenteExterior = false;
		boolean tangenteInterior = false;
		tangenteExterior = this.tangente(circuloComparar);
		tangenteInterior = this.embebidoTangente(circuloComparar);
		return (tangenteExterior || tangenteInterior)? true : false;
	}
	
	
	// Método distancia entre centros
	public double distanciaCentros(Circulo circuloComparar) {
		double cateto1 = this.getCentro().getCoordX() - circuloComparar.getCentro().getCoordX();
		double cateto2 = this.getCentro().getCoordY() - circuloComparar.getCentro().getCoordY();
		double distanciaCentros = Math.sqrt(Math.pow(cateto1,2) + Math.pow(cateto2,2));
		return distanciaCentros;
	}
	
	

}
