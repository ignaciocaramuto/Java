package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import data.*;
import entities.*;

public class Login {
	private DataCliente dc;
	private DataTipoHabitacion dth;
	private DataHabitacion dh;
	private DataServicio ds;
	private DataEstadia de;
	
	public Login() {
		dc=new DataCliente();
		dth=new DataTipoHabitacion();
		dh=new DataHabitacion();
		ds=new DataServicio();
		de=new DataEstadia();
	}
	
	public Cliente validateCliente(Cliente c) {

		return dc.getByUser(c);
	}
	
	public LinkedList<Cliente> getAll(){
		return dc.getAll();
	}
	
	public void addClient(Cliente cli) {
		dc.add(cli);
	}

	public void addTipohabitacion(Tipo_Habitacion thab) {
		dth.add(thab);
	}
	
	public void updateTipoHabitacion(Tipo_Habitacion th) {
		dth.update(th);
	}
	
	public void deleteTipohabitacion(Tipo_Habitacion th) {
		dth.delete(th);	
	}

	public Tipo_Habitacion validateTipo_Habitacion(Tipo_Habitacion th) {
		
		return dth.validate(th);
	}

	public void add_Habitacion(Habitacion h) {
		dh.add(h);
	}
	
	public void add_Servicio(Servicio s) {
		ds.add(s);
	}
	

	public Habitacion buscarHabitacionesLibres(Tipo_Habitacion thab, Estadia es) {
		return dh.buscar(thab, es);
	}

	public void createEstadia(int i, Estadia e, Cliente c) {
		de.add(i, e, c);
	}
	
	
}
