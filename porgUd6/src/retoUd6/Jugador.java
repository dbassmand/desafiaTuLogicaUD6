package retoUd6;

import java.time.LocalTime;

public class Jugador {

	
	private String nombre;
	private String arma;
	private String habitacion;
	private LocalTime horaPartida;
	
	public Jugador(String nombre, String arma, String habitacion, LocalTime horaPartida) {
        this.nombre = nombre;
        this.arma = arma;
        this.habitacion = habitacion;
        this.horaPartida = LocalTime.now(); // Obtiene la hora actual al momento de crear el objeto
    }
	
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getArma() {
		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(String habitacion) {
		this.habitacion = habitacion;
	}

	public LocalTime getHoraPartida() {
		return horaPartida;
	}

	public void setHoraPartida(LocalTime horaPartida) {
		this.horaPartida = horaPartida;
	}



}
