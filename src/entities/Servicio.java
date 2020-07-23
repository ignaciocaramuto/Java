package entities;

public class Servicio {
	private int idServicio;
	private String denominacion;
	private String descripcion;
	private float costo;
	public int getIdServicio() {
		return idServicio;
	}
	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}
	public String getDenominacion() {
		return denominacion;
	}
	public void setDenominacion(String denominacion) {
		this.denominacion = denominacion;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public float getCosto() {
		return costo;
	}
	public void setCosto(float costo) {
		this.costo = costo;
	}
}
