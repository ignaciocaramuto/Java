package entities;

import java.util.Date;

public class Estadia {

	private int idEstadia;
	private java.sql.Date fechaIngreso;
	private java.sql.Date fechaEgreso;
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
		this.fechaIngreso = (java.sql.Date) fechaIngreso;
	}
	public Date getFechaEgreso() {
		return fechaEgreso;
	}
	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = (java.sql.Date) fechaEgreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}
