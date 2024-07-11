package m8ex5_frank_pulido;

import java.util.Scanner;

public class M8EX5_Frank_Pulido {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * Youtube EJERCIO MEJORADO : https://youtu.be/82eTLO0LPbg
		 * Youtube original : https://youtu.be/HFQDErfT694
		 * El ejercicio pide crear 2 Clases : Punto y Círculo
		 * La Clase Punto permite construir objetos con 2 coordenadas que definen la posición del punto.
		 * La Clase Círculo crea objetos con 2 atributos : el "centro" de Clase Punto y el radio Clase int.
		 * En la Clase Circulo deben desarrollarse Métodos que comparen un objeto Círculo con parámetros que definen
		 * un círculo (parámetros que le definen, no otro objeto).
		 * Métodos : distanciaCentros, iguales, concentricos, igualRadio, tangentes, secantes, noSolapan
		 */
		
		// Declaración e inicialización de variables
		
		byte opcionMenu = -1;
		byte respuesta = -1;
				
		double coordX = 0d;
		double coordY = 0d;
		double radio = 0d;
		
		double centroXcomparar = 0d;
		double centroYcomparar = 0d;
		double radioComparar = 0d;
		
		double distanciaCentros = -1;
		boolean concentricos = false;
		boolean radiosIguales = false;
		boolean iguales = false;
		boolean embebido = false;
		boolean tangentes = false;
		boolean secantes = false;
		boolean ajenos = false;
		String respuestaOrdenador = "";

		
		
		// Creación del Scanner para interface de Usuario
		
		Scanner dataentry = new Scanner (System.in);
		
		// Controlador
		
		System.out.println("Bienvenid@ a IT Geometría.\nEsta aplicación permite establecer el grado de intersección entre 2 círculos.");
		System.out.println("Antes de comenzar, repasemos los conceptos que hemos estudiado en clase.\n"
				+ "Un círculo se define a través de 2 parámetros : su \"Centro\" y su \"Radio\".\n"
				+ "La circunferencia es el conjunto de puntos equidistantes al Centro en una distancia equivalente al Radio.");
		System.out.println();
		System.out.println("Casos posibles :\n\n"
				+ "1. Círculos concéntricos : Los círculos concéntricos son aquellos que comparten el mismo Centro. Tendremos 2 posibles situaciones :\n\n"
				+ "\t1.1 Radios de distinta longitud : El de radio menor queda totalmente \"embebido\" en el de mayor radio, sin existir ningún\n"
				+ "\tpunto de intersección entre sus circunferencias.\n\n"
				+ "\t1.2 Círculos iguales : Si dos círculos concéntricos tienen además el mismo radio entonces los círculos son IGUALES y\n"
				+ "\tse intersectan en los infinitos puntos que conforman la totalidad de su circunferencia.\n\n"
				+ "2. Círculos NO concéntricos : Existen 5 casos posibles que definen el grado de intersección entre 2 círculos NO concéntricos :\n\n"
				+ "\t2.1 Que el radio del círculo mayor > Distancia entre centros + radio del círculo menor : En este caso el círculo menor está\n"
				+ "\tcompletante embebido en el mayor. Sus circunferencias NO se intersectan.\n\n"
				+ "\t2.2 Que el radio del círculo mayor == Distancia entre centros + radio del círculo menor.\n"
				+ "\tEn este caso el círculo menor está completante embebido en el mayor, pero además existe TANGENCIA : Sus circunferencias\n"
				+ "\tse intersectan en ún único punto, el llamado \"punto de tangencia\"\n\n"
				+ "\t2.3 Que el radio del círculo mayor > Distancia entre centros, pero que se de también la condición que :\n"
				+ "\tRadio del círculo mayor < Distancia entre centros + radio del círculo menor.\n"
				+ "\tEn este caso los círculos serán SECANTES : Existirán 2 puntos de intersección entre sus circunferencias.\n"
				+ "\tSe puede trazar una línea que una a estos 2 puntos de intersección, la llamada \"RECTA SECANTE\".\n\n"
				+ "\t2.4 Que la distancia entre los centros sea exactamente igual a la suma de sus radios.\n"
				+ "\tEn este caso los círculos son TANGENTES, sus circunferencias se intersectan en un único punto, igual que en el Caso 2.2, pero\n"
				+ "\tno existe solapamiento entre ellos.\n\n"
				+ "\t2.5 Último caso : Distancia entre centros > suma de los radios. En este caso los 2 círculos son ajenos :\n"
				+ "\t- No son tangentes.\n"
				+ "\t- No son secantes.\n"
				+ "\t- No se encuentra uno embebido en el otro.");
		
		System.out.println();
		System.out.println();

		System.out.println("Antes de empezar la práctica definiremos el Círculo de REFERENCIA con el que practicaremos.");
		System.out.println("Empezaremos por definir las coordenadas del Centro.");
		System.out.println("A continuación indique la coordenada del Centro sobre el eje X del plano cartesiano:");
		coordX = dataentry.nextDouble();
		System.out.println("A continuación indique la coordenada del Centro sobre el eje Y del plano cartesiano:");
		coordY = dataentry.nextDouble();
		
		Punto centroReferencia = new Punto(coordX, coordY);
		
		System.out.println("Por último necesitamos conocer la amplitud del Radio :");
		radio = dataentry.nextInt();
		
		Circulo referencia = new Circulo (centroReferencia, radio);

		System.out.println();
		System.out.println("Estupendo!. Ya tenemos el círculo de REFERENCIA con el que comparar todos los círculos cuyos parámetros nos indique\n"
				+ "durante la práctica y establecer el grado de intersección entre ellos.");
		System.out.println();
		
		do {
			System.out.println();
			System.out.println("1. Practicar.\n2. Salir del sistema.");
			opcionMenu = dataentry.nextByte();
			
			switch (opcionMenu) {
			
			case 1 :
				System.out.println();
				System.out.println("Empezaremos definir el círculo para el que queremos conocer el grado de intersección con el círculo de REFERENCIA.");
				System.out.println("Definamos sus parámetros (centro y radio). Le llamaremos \"círculo de PRUEBA\"");
				System.out.println("Coordenada del Centro sobre el eje X :");
				centroXcomparar = dataentry.nextInt();
				System.out.println("Coordenada del Centro sobre el eje Y :");
				centroYcomparar = dataentry.nextInt();
				System.out.println("Longitud de su radio :");
				radioComparar = dataentry.nextInt();
				
				Punto centroComparar = new Punto(centroXcomparar, centroYcomparar);
				Circulo circuloComparar = new Circulo(centroComparar, radioComparar);
				

				System.out.println();
				distanciaCentros = referencia.distanciaCentros(circuloComparar);
				System.out.println("La distancia entre los centros de los círculos REFERENCIA y PRUEBA es : " + distanciaCentros);
				// if (distanciaCentros == 0) {System.out.println("Los círculos son concéntricos!!! (ya hablaremos más de este concepto)");}
				System.out.println("El radio del círculo de REFERENCIA es : " + radio);
				System.out.println("El radio del círculo de PRUEBA es : " + radioComparar);
				
				System.out.println();
				System.out.println("A continuación evaluaremos si existe intersección entre el círculo de referencia y el que nos has dado a probar,\n"
						+ "pero antes debes decirnos que concluyes tu :");
								
				System.out.println();
				//// MENÚ DE USUARIO :
				do {
					concentricos = false;
					radiosIguales = false;
					iguales = false;
					tangentes = false;
					secantes = false;
					ajenos = false;
					System.out.println(menuUsuario());
					System.out.println();
					System.out.println("A continuación indica cual crees que es la opción correcta :");
					respuesta = dataentry.nextByte();
					
					switch (respuesta) {
					
					case 1 :
						concentricos = referencia.concentrico(circuloComparar);
						radiosIguales = referencia.radiosIguales(circuloComparar);
						if (concentricos && radiosIguales) {
							System.out.println("La respuesta es correcta, pero la respuesta ideal era (2) : \"Iguales\".");
						} else {
							System.out.println((concentricos)? "Respuesta correcta!!" : "Respuesta incorrecta. Sigue practicando");
						}
						radiosIguales = false;
						tangentes = false;
						secantes = false;
						ajenos = false;
						System.out.println();
						break;
						
					case 2 :
						iguales = referencia.circulosIguales(circuloComparar);
						System.out.println((iguales)? "Respuesta correcta!!" : "Respuesta incorrecta. Sigue practicando");
						break;
						
					case 3 :
						embebido = referencia.embebido(circuloComparar);
						System.out.println((embebido)? "Respuesta correcta!!" : "Respuesta incorrecta. Sigue practicando");
						break;
						
					case 4 :
						tangentes = referencia.embebidoTangente(circuloComparar);
						System.out.println((tangentes)? "Respuesta correcta!!" : "Respuesta incorrecta. Sigue practicando");
						break;
						
					case 5 :
						secantes = referencia.secante(circuloComparar);
						System.out.println((secantes)? "Respuesta correcta!!" : "Respuesta incorrecta. Sigue practicando");
						break;
						
					case 6 :
						tangentes = referencia.tangente(circuloComparar);
						System.out.println((tangentes)? "Respuesta correcta!!" : "Respuesta incorrecta. Sigue practicando");
						break;
						
					case 7 :
						ajenos = referencia.ajeno(circuloComparar);
						System.out.println((ajenos)? "Respuesta correcta!!" : "Respuesta incorrecta. Sigue practicando");
						break;
						
					default :
						System.out.println("Debe seleccionar una opción válida (del 1 al 7");
						break;
					
					}
					
					
				} while (respuesta < 1 || respuesta > 7);
				
				System.out.println();
				respuestaOrdenador = referencia.interseccion(circuloComparar);
				System.out.println(respuestaOrdenador);
				
				break;
				
			case 2 :
				System.out.println();
				System.out.println("Ha elegido cerrar sesión de usuario. En la siguiente clase estudiaremos como calcular el punto de tangencia, los\n"
						+ "2 puntos de corte en caso de círculos secantes y la ecuación de la recta secante que les une... Hasta pronto!!!");
				break;
				
			default :
				System.out.println("Debe elegir 1 o 2");
				break;
			}
			
		} while (opcionMenu != 2);
		
		
		dataentry.close();

	}
	
	public static String menuUsuario() {
		return "Dispones de 5 minutos parta evaluar cual de las siguientes condiciones se cumple (1 al 7) :\n"
				+ "1. Caso 1.1 : círculos concéntricos.\n"
				+ "2. Caso 1.2 : círculos iguales. Los puntos de intersección son infinitos.\n"
				+ "3. Caso 2.1 : círculos no concéntricos que no se intersectan, el menor está embebido en el mayor.\n"
				+ "4. Caso 2.2 : círculo tangente interior. Se intersectan en un único punto y además el menor está embebido en el mayor.\n"
				+ "5. Caso 2.3 : círculos secantes. Los círculos se intersectan en 2 puntos por estar parcialmente solapados.\n"
				+ "6. Caso 2.4 : círculo tangente exterior. Se intersectan en un único punto y no existe solapamiento entre sus áreas.\n"
				+ "7. Caso 2.5 : círculos ajenos. No existe ningún punto de intersección ni área de solapamiento.";
	}
	
	
}
