package logic;

import java.util.LinkedList;
import data.*;
import entities.*;

public class Login {
	private DataCliente dc;
	
	public Login() {
		dc=new DataCliente();
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
}
