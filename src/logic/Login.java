package logic;

import java.util.LinkedList;
import data.*;
import entities.*;

public class Login {
	private DataCliente dc;
	private DataTipoHabitacion dth;
	
	public Login() {
		dc=new DataCliente();
		dth=new DataTipoHabitacion();
	}
	public Cliente getOne(String nroDoc) {

		return dc.getByDni(nroDoc);
	}
	
	public Cliente validate(Cliente c) {

		return dc.getByUser(c);
	}
	
	public LinkedList<Cliente> getAll(){
		return dc.getAll();
	}
	
	public void addClient(Cliente cli) {
		dc.add(cli);
	}
	
	public void deleteClient(Cliente cli) {
		dc.delete(cli);
	}
	public void addTipohabitacion(Tipo_Habitacion thab) {
		dth.add(thab);
	}
	
	
}
