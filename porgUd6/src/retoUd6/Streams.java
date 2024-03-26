package retoUd6;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;


public class Streams {
		
		
	static boolean comprobarExiste(String nombreArchivo) {
				
		//String rutaFicheroAEscribir = System.getProperty("user.dir") + "\\" + nombreArchivo + ".txt";
		File ef = new File(nombreArchivo);

		if(ef.exists()) {
			
			return false;
		}else {

		}	return true;
	}
	
	/*Se crea  metodo para crear el archivo de texto donde se vana escribir
	 * los datos de los objetos jugadores creados.
	 */		
	static void creaArchivo(String archivo) {

		File file = new File(archivo);
		if (!file.exists()) {
			try {
				if (file.createNewFile()) {
					System.out.println("Archivo creado: " + file.getAbsolutePath());
				} 
			}catch (IOException e) {

				System.out.println("Error al crear el archivo '"+archivo);
				e.printStackTrace();
			}
		}
	}

	/*metodo que recibe como parametro un array de objetos jugadores,
		  secrea un bucle for-each para recorrer el ArrayList exatrayenco con los Getters
		  las variables de los objetos para escribirlos en el archivo de texto.
	 */
	static void guardarInformacion(ArrayList<Jugador> jugadores) {
		String nombreArchivo = "datosPartidaCluedo.txt";

		try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo, true))) { //clase FileWriter en modo true para que escriba en adelante
			// Agrega la cabecera con la fecha actual

			for (Jugador jugador : jugadores) {
				
				writer.write("\nCabecera - Fecha: " + LocalDate.now() + "\n"+
						"Jugador [Nombre= " + jugador.getNombre() + 
						", arma= " + jugador.getArma() + 
						", habitación= " + jugador.getHabitacion() +
						", hora de partida: " + jugador.getHoraPartida()+"]");
				System.out.println("");
			}
			System.out.println("Información de los jugadores guardada en el archivo " + nombreArchivo);
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}
	/*Se crea un metodo para leer un archivo de texto y mostrarlo en consola.
	 * El moetodo recibe como parametro el archivo
	 */
	static void leerInformacion(String archivo) {
		try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
			String linea;
			while ((linea = reader.readLine()) != null) {
				System.out.println(linea); // Imprime la línea leída por consola
			}
		} catch (IOException e) {
			System.err.println("Error al leer el archivo: " + e.getMessage());
		}
	}
}
