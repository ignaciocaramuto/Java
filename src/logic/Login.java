package logic;

import java.util.LinkedList;
import data.*;
import entities.*;

public class Login {
	private DataCliente dc;
	private DataTipoHabitacion dth;
	private DataHabitacion dh;
	
	public Login() {
		dc=new DataCliente();
		dth=new DataTipoHabitacion();
		dh=new DataHabitacion();
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

	public Tipo_Habitacion validateTipo_Habitacion(Tipo_Habitacion th) {
		
		return dth.validate(th);
	}

	public void addHabitacion(Habitacion h) {
		dh.add(h);
	}
	
	
}
