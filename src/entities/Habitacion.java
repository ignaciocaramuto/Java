package entities;

public class Habitacion {
	private int nro_Habitacion;
	private String denominacion;
	private Tipo_Habitacion id_Tipo_Habitacion;
	
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
	public Tipo_Habitacion getId_Tipo_Habitacion() {
		return id_Tipo_Habitacion;
	}
	public void setId_Tipo_Habitacion(Tipo_Habitacion thab) {
		this.id_Tipo_Habitacion = thab;
	}
	
	
}
