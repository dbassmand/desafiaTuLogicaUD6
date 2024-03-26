package retoUd6;


import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class Main {

	/*Los arrays se declara como estaticos fuera del metodo main para que sean accesibles desde cualquier sitio 
	 * y para que una vez se modifiquen, en caso de jugar varias partidas los datos nuevos perduren.
	 * Solo vuelve a sus valores iniciales si se reinicia la aplicación. 
	 */
	static String personajesArray[]= {"Amapola","Celeste","Prado","Mora","Rubio","Blanco"};
	static String armasArray []= {"bate","pistola","candelabro","cuchillo","cuerda","hacha","pesa","veneno","trofeo"};
	static String habitacionesArray[]= {"casa de invitados","teatro","spa","observatorio","comedor","terraza","salon","cocina","vestibulo"};
	static Scanner sc = new Scanner(System.in);
	//las siguientes variables las hago static de la clase ya que el metodo
	//barajar debe ser booleano por el enunciado. Al ponerlo así puedo utilizar
	//los parametros para crear objetos Jugador desde cualquier sitio.
	static int result1;
	static int result2;
	static int result3;
		
	public static void main(String[] args) {
		
				
		ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
		
		System.out.println("Bienvenido al Cluedo. Voy a mezclar las cartas por ti.");
		System.out.println("A continuacion se mostraran todas las opciones disponibles.\n");
		
		boolean bandera = true; 
		do {
			
			partida(jugadores);
			sc.nextLine();
			System.out.println("Quieres crear una nueva combinación para el juego (s para continuar)?");
			String continuar = sc.nextLine();
			
			if(!continuar.equals("s") ) {
				bandera = false;
				System.out.println("Gracias por jugar!!");
			}
		
		} while (bandera);
	
		/*metodo de la clase Streams, 
		 * no es necesario crear un objto de la clase al ser un metodo estático
		 * */		
		String archivo = "datosPartidaCluedo.txt";
		
		
		/*estructura de control para comprobar si el archivo ya existe de lo contrario
		 *volverá a crearlo perdiendose los registros anteriores 
		 */
		if(!Streams.comprobarExiste(archivo)) {
			System.out.println("El archivo datosPartidaCluedo.txt ya existe.");
		}else {
			Streams.creaArchivo(archivo);
		}
			
		/*Una vez crear el archivo txt se llama al metodo para
		 * guarda la información del ArrayList jugadores en formato texto
		 */
		Streams.guardarInformacion(jugadores);
		
		//comprobamos el contenido del archivo datosPartidaCluedo.txt mostrando el contenido en consola
		
		Streams.leerInformacion(archivo);
	}
	
	public static void partida(ArrayList<Jugador> jugadores) {
		int respuesta=0;
		mostrarOpciones();
		
		
		
		do {
		    System.out.println("\nQuieres añadir algo más?\n");
		    System.out.println("Menu para añadir más información");
		    System.out.println("1. Personaje");
		    System.out.println("2. Arma");
		    System.out.println("3. Habitacion");
		    System.out.println("4. Continuar");
		    System.out.print("opcion: ");

		    // Verifica si la entrada es un entero
		    if (sc.hasNextInt()) {
		        respuesta = sc.nextInt();
		        if (respuesta >= 1 && respuesta <= 4) {
		            // Opción válida, procede con el tratamiento
		            anadeDatos(respuesta);
		        } else {
		            System.out.println("Introduce una opción válida entre 1-4");
		        }
		    } else {
		        System.out.println("Error: Debes introducir un número entero.");
		        sc.nextLine(); // Limpia el buffer del Scanner
		    }

		} while (respuesta != 4);

		
		System.out.println("...barajando cartas...");
		
		
		barajar(personajesArray, armasArray, habitacionesArray);
		jugadores.add(cartasGanadoras());
				
		if(clave()) {
			mostrarCartas(jugadores);
		}else {
			System.out.println("Clave incorrecta!");
		}
	}
	
	//metodo que recibe un array y un numero, incrementa la longitud del array
		//tantas posiciones como numeros reciba
		public static String[] actualizarArray(String[] arrayAntiguo, int num) {
			
			String[] arrayNuevo = new String[arrayAntiguo.length + num];
				
			System.arraycopy(arrayAntiguo, 0, arrayNuevo, 0, arrayAntiguo.length);
					
			return arrayNuevo;
		}
	

	//metodo para mostrar los datos almacenados en los arrays unidimensionales
	//hace uso del bucle for-each
	public static void mostrarOpciones() {
										
		System.out.println("Listado de personajes");
		System.out.println("---------------------");

		for (String per : personajesArray ) {
			System.out.println(per);
		}
		System.out.println("");
		System.out.println("Listado de armas");
		System.out.println("---------------------");

		for (String arms : armasArray) {
			System.out.println(arms);
		}
		System.out.println("");
		System.out.println("Listado de habitaciones");
		System.out.println("---------------------");

		for (String hab : habitacionesArray) {
			System.out.println(hab);
		}
				
	}
		
	//metodo que recibe variable entera para modificar
	//los arrays unidimensionales
	public static void anadeDatos(int respuesta) {
		switch(respuesta) {
		
			case 1:{
				//Codigo para añadir nuevos personajes
				System.out.println("Cuantos personajes quieres añadir? ");
				int num;
				if(sc.hasNextInt()) { //verifica si la entrada en un entero
					num = sc.nextInt();
					personajesArray = actualizarArray(personajesArray, num);
					sc.nextLine();//Limpia el buffer del Scanner
					for (int i = personajesArray.length-num; i<personajesArray.length; i++) {
						System.out.print("\nIntroduce el nombre del personaje: ");
						String introDato = sc.nextLine();
						personajesArray[i] = introDato;
					}
					//se visualizan todos los nombre almacenados
					System.out.println("Lista de personajes actualizado: " + Arrays.toString(personajesArray));
				}else {
					System.out.println("Error: Debes introducir un numero entero.");
					sc.nextLine(); //Limpia el buffer del Scanner
				}
				break;
			}
	
			case 2:{
				//codigo para añadir nuevas armas
				System.out.println("Cuantas armas quieres añadir? ");
				int num;
				if(sc.hasNextInt()) {
					num = sc.nextInt();
					armasArray = actualizarArray(armasArray, num);
					sc.nextLine();
					for(int i = armasArray.length-num; i<armasArray.length;i++) {
						System.out.println("\nIntroduce el nuevo arma: ");
						String introDato = sc.nextLine();
						armasArray[i]= introDato;
					}
					System.out.println("Inventario de armas actualizado: "+Arrays.toString(armasArray));
				}else {
					System.out.println("Error: Debes introducir un numero entero.");
					sc.nextLine(); //Limpia el buffer del Scanner
				}				
				break;
			}
	
			case 3:{
				//Codigo para añadir nuevas estancias
				System.out.println("Cuantas estancias quieres añadir? ");
				int num;
				if(sc.hasNextInt()) {
					num = sc.nextInt();
					habitacionesArray = actualizarArray(habitacionesArray, num);
					sc.nextLine();
					for (int i = habitacionesArray.length-num; i<habitacionesArray.length;i++) {
						System.out.println("\nIntroduces nueva estancia: ");
						String introDato = sc.nextLine();
						habitacionesArray[i]= introDato;
					}
					System.out.println("La lista de habitaciones actualizada es: "+ Arrays.toString(habitacionesArray));
				}else {
					System.out.println("Error: Debes introducir un numero entero.");
					sc.nextLine(); //Limpia el buffer del Scanner					
				}
				break;
			}
			case 4:{ 
				System.out.println("¡Genial, sigamos...!");
				break;			
			}	
		}
	}
	
	/*este metodo es booleano por que lo dice el enunciado
	  para mi no tiene sentido, ello me ha hecho estableces
	las variables como esticas de la clase Main.
	El metodo recibe como argumeto los 3 arrays unidimensionales y 
	escoje aleatoriamente un numero de su longitud.
	*/
	static boolean barajar(String[]array1,String[]array2,String[]array3) {
		boolean exito=true;
		Random rand = new Random();
		result1 =rand.nextInt(array1.length);
		System.out.println(result1);
		result2=rand.nextInt(array2.length);
		System.out.println(result2);
		result3=rand.nextInt(array3.length);
		System.out.println(result3);
						
		return exito;
	}
	//metodo que devuelve un objeto de la clase Jugador
	public static Jugador cartasGanadoras() {
		String parametro1= personajesArray[result1];
		String parametro2= armasArray[result2];
		String parametro3= habitacionesArray[result3];
		LocalTime horaPartida= LocalTime.now();
		Jugador player = new Jugador(parametro1,parametro2,parametro3,horaPartida);
		return player;
	}
	//metodo para mostrar los atributos del ultimo objeto guardado en el ArrayList
	public static void mostrarCartas(ArrayList<Jugador> jugadores) {
		if (!jugadores.isEmpty()) {
	        // Obtiene el último elemento de la lista
	        Jugador ultimoJugador = jugadores.get(jugadores.size() - 1);
	        // Muestra la información del último jugador
	        System.out.println("Último jugador almacenado: Jugador [Nombre= "+ ultimoJugador.getNombre()+
	        					", Arma= " + ultimoJugador.getArma()+
	        					", Habitación= " + ultimoJugador.getHabitacion()+
	        					", Hora de partida= " + ultimoJugador.getHoraPartida() );      
	    } else {
	        System.out.println("La lista de jugadores está vacía.");
	    }
	}
	//metodo para comprobar contraseña
	public static boolean clave() {
		int pass;
		int password = 123;
		boolean coincide = false;
		System.out.println("Si introduces la clave correcta te puedo mostrar quien ha sido el\n culpable, como y donde....");
		if(!sc.hasNextInt()) {
			System.out.println("La constraseña debe ser numerica");
			sc.nextLine(); //Limpia el buffer del Scanner
		}else {
			pass= sc.nextInt();
			 if(pass == password) {
				 coincide= true;
			 }
		}				
		 return coincide;
	}
}
