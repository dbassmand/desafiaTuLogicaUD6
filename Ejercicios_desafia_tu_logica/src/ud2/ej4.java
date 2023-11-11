package ud2;

import java.util.Scanner;

public class ej4 {

	public static void main(String[] args) {
		// Escribe un programa en Java que pida al usuario 3 números y un orden de ordenamiento, que puede ser ascendente o descendente, 
		// a continuación, según el orden indicado se mostrarán en pantalla dichos números. Ej.: si los números introducidos son 4,7,2 y 
		// se escoge orden ascendente (de menor a mayor) aparecen en pantalla en este orden 2,4,7, 
		// si el ordenamiento es descendente (de mayor a menor) se mostrarán en el siguiente 7, 4, 2. Utiliza estructuras de control adecuadas.  

		Scanner entrada = new Scanner(System.in); 						//Se crea una nuva entrada de teclado con la clase Scanner
		int num1,num2, num3, aux, orden; 								//Se declaran 3 variables de tipo entero
		
	
		System.out.println("Teclea 3 numeros: "); 						//se imprime en pantalla
		System.out.print("\nEl primero: ");								//se solicita al usuario que teclee el primer numero
		num1= entrada.nextInt();
		System.out.print("El segundo: ");								//se solicita al usuario que teclee el segundo numero
		num2= entrada.nextInt();
		System.out.print("El tercero: ");								//se solicita al usuario que teclee el tercer numero
		num3= entrada.nextInt();
		
		System.out.println("Como quieres ordenarlos: ");				//se pregunta en que orden se quiere ordenas

		do {
			System.out.println("Pulsa (1)ascendente o (2)descendente");	//se guarda en la variable orden la entrada de teclado
			orden = entrada.nextInt();
				
			if(orden==1) { 												// opcion (1)ascendente
				if(num2< num1) { 										//se compara el primer y segundo numero
					aux=num2;											//se utiliza la variable aux para almacenar temporalmente
					num2=num1;											//se procede a ordenar las variables
					num1=aux;											//se procede a ordenar las variables
				}
				if(num3< num2) {										//se compara el tercer y segundo numero
					aux=num3;											//se utiliza la variable aux para almacenar temporalmente
					num3=num2;											//se procede a ordenar las variables
					num2=aux;											//se procede a ordenar las variables
				}
				if(num2< num1) {										//se vuelve a repetir la comparacion entre primer y segundo numero
					aux=num2;
					num2=num1;
					num1=aux;
				}
				System.out.println("El orden ascendente es: "+num1+" "+num2+" "+num3); //impresion en pantalla
			}
			if(orden==2) { 												// opcion (2)descendente
			
				if (num2>num1) {//se repite el proceso anterior pero en orden inverso
					aux=num1;
					num1=num2;
					num2=aux;
				}
				if (num3>num2) {
					aux=num2;
					num2=num3;
					num3=aux;
				}
				if (num2>num1) {
					aux=num1;
					num1=num2;
					num2=aux;
				}	
				System.out.println("El orden descendente es: "+num1+" "+num2+" "+num3);//impresion en pantalla
			}
		}while(orden!=1 && orden!=2);									//el bucle se repite siempre que la respuesta sobre el orden sea incorrecta
	}	
		

}
