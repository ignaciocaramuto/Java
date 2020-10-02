package entities;

public class Habitacion {
	private int nro_Habitacion;
	private String denominacion;
	private int nroTipoHabitacion;//cambiar por objeto
	
	public int getNroTipoHabitacion(){
		return this.nroTipoHabitacion;
	}
	public void setNroTipoHabitacion(int nroTipoHabitacion) {
		this.nroTipoHabitacion=nroTipoHabitacion;
	}
	
	public int getNro_Habitacion() {
		return nro_Habitacion;
	}
	public void setNro_Habitacion(int nro_Habitacion) {
		this.nro_Habitacion = nro_Habitacion;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}

	public String toString() {
		return "Habitacion [nro_Habitacion=" + nro_Habitacion + ", denominacion=" + denominacion
				+ ", nroTipoHabitacion=" + nroTipoHabitacion + "]";
	}

	
}
