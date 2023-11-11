package ud2;


import java.util.Scanner;

public class ej2 {

	public static void main(String[] args) {
		// Escribe un programa en Java que pida un número por teclado hasta que éste sea positivo. 
		//A continuación, muestra los primeros 20 números sucesivos a dicho número.
		
		Scanner entrada = new Scanner(System.in);				//Se crea una nuva entrada de teclado con la clase Scanner
		int numero;												// nuema variable de tipo entero
		
			do {
			System.out.println("Teclea un numero positivo: ");	//impresion en pantalla
			numero = entrada.nextInt();							//se guarda la entrada de teclado en la variable numero
			
			}while (numero<0);									//l bucle se repite en caso que se introduzca un numero negativo
			
			System.out.print("El resultado es: ");
			
			for (int i=0; i<20;i++) { 							//bucle de 20 iteraciones
				System.out.print(numero + 1+" ,");				//se imprime a partir del siguiente numero introducido
				numero++;										//se incrementa en 1 el numero introducido cada cada iteracion
				}
				 
			}
		
	}


