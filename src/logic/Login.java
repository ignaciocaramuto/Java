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
	public void addHabitacion(Habitacion h){
	dh.add(h);	
	}
	public void modifyHabitacion(Habitacion h) {
		System.out.println(h);
		dh.modify(h);
		
	}
	public Habitacion getOneHabitacion(int nro) {
		return dh.getOne(nro);
	}
	public void deleteHabitacion(int nroHab) {
		dh.deleteHabitacion(nroHab);
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
	public void modifyClient(Cliente c) {
		
		
	}
	
}
