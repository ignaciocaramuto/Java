package clases;

import java.util.Date;

public abstract class Estadia {

	private int idEstadia;
	private Date fechaIngreso;
	private Date fechaEgreso;
	private String estado;
	
	public int getIdEstadia() {
		return idEstadia;
	}
	public void setIdEstadia(int idEstadia) {
		this.idEstadia = idEstadia;
	}
	public Date getFechaIngreso() {
		return fechaIngreso;
	}
	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}
	public Date getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
