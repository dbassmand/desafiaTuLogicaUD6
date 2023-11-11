package ud2;

public class ej1 {

	public static void main(String[] args) {
		// Escribe un programa en Java que muestre los números del 10 al 1, en ese orden. 
		//Debes utilizar una estructura de tipo while ó do-while.
		
		int numero=10; 								//se define la variable numero incializandola con el valor 10
		
		System.out.print("El resultado es: ");		//impresion en pantalla
		
		while (numero>0) { 							//el bucle se repetira siempre que el numero sea mayor que 0
			System.out.print(numero +" ,");			//impresion en pantall
			numero--;								//cada iteración al valor de numero se le resta 1
		}

	}

}
