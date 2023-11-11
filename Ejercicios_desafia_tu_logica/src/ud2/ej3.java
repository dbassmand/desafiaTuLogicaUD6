package ud2;

public class ej3 {

	public static void main(String[] args) {
		// Escribe un programa en Java que muestre y cuente los números que son múltiplos de 2 o de 3 que hay entre 1 y 100. 
		// Utiliza las estructuras de control que creas convenientes.

		int acumula=0;													//se define una variable entera inicializandola en el valor 0
		
		System.out.print("Los multiplos de 2 entre 1 y 100 son: ");		//impresion en pantalla
		for (int mult2=1; mult2<101;mult2++) {							//se inicializa variable entera mult2 con valor 1 y bucle for con 100 pasos
			if (mult2%2==0) {											//si el resto del numero entre 2 es 0 entonces el multiplo
				System.out.print(mult2+" ,");							//se imprime en pantalla
				acumula++;												//el iterador acumula se incrementa en 1, se contabilizan los multiplos encontrados
			}
		}
		System.out.println("\nHay "+ acumula+ " multiplos de 2.");		//impresion en pantalla
		
		acumula=0;														//se reinicializa la variable acumula a 0
		
		System.out.print("\nLos multiplos de 3 entre 1 y 100 son: ");	//se repite el procedimiento anterior
		for (int mult3=1; mult3<101;mult3++) {
			if (mult3%3==0) {											//se comprueba si el resto del numero entre 3 es 0
				System.out.print(mult3+" ,");
				acumula++;
			}
				
		}
		System.out.println("\nHay "+ acumula+ " multiplos de 3.");
		
		
	}

}
