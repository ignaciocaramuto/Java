package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Scanner;
import entities.*;
import logic.Login;

public class Menu {
	Scanner s=null;
	Login ctrlLogin = new Login();

	public void start() {
		s = new Scanner(System.in);
		Cliente c=login();
		System.out.println("Bienvenido "+c.getNombre()+" "+c.getApellido());
		System.out.println();
		
		String command;
		do {
			command=getCommand();
			executeCommand(command);
			System.out.println();
			
		}while(!command.equalsIgnoreCase("exit"));
		
		s.close();
	}
	
	private Cliente login() {
		Cliente c=new Cliente();
		
		System.out.print("Email: ");
		c.setMail(s.nextLine());

		System.out.print("password: ");
		c.setContraseña(s.nextLine());
		
		c=ctrlLogin.validate(c);
		
		return c;
	}
	
	private void executeCommand(String command) {
		switch (command) {
		case "1":
			System.out.println(ctrlLogin.getAll());
			break;
		case "2":
			addCliente();
			break;
		case "search":
			System.out.println();
			break;
		case "new":
			
	
			break;
		case "edit":
			
			break;
		case "delete":
			
			break;
		default:
			break;
		}
	}
	
	private String getCommand() {
		System.out.println("Ingrese el comando según la opción que desee realizar");
		System.out.println("1\t\tlistar todos los clientes");
		System.out.println("2\t\tABMC cliente");
		System.out.println("3\t\tABMC Tipo de habitacion"); //puede devolver varios
		System.out.println("4\t\tABMC Habitacion");
		System.out.println("5\t\tABMC Servicio");
		System.out.println("6\t\tRealizar reserva de habitacion");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
	
	private void addCliente() {
		System.out.println();
		Cliente c=new Cliente();
		//Documento d=new Documento();
		//Rol r=new Rol();
		System.out.print("Tipo doc: ");
		c.setTipoDoc(s.nextLine());
		System.out.print("Nro doc: ");
		c.setNumDoc(s.nextLine());
		System.out.print("Nombre: ");
		c.setNombre(s.nextLine());
		System.out.print("Apellido: ");
		c.setApellido(s.nextLine());
		System.out.print("Email: ");
		c.setMail(s.nextLine());
		System.out.print("Password: ");
		c.setContraseña(s.nextLine());
		System.out.print("Telefono: ");
		c.setTelefono(s.nextLine());
		System.out.print("Sexo: ");
		c.setSexo(s.nextLine());
		System.out.print("Fecha de nacimiento(yyyy-mm-dd): ");
		String date = s.nextLine();
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date myDate = null;
		try {
			myDate = formatter.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
		c.setFechaNacimiento(sqlDate);
		System.out.print("Tipo tarjeta de credito: ");
		c.setTipoTarjetaCredito(s.nextLine());
		System.out.print("Numero de tarjeta de credito: ");
		c.setNumTarjetaCredito(s.nextLine());
		//System.out.print("Rol: ");
		//r.addRol(s.nextLine());
		ctrlLogin.addClient(c);
		//ctrlLogin.setRoles(p);
	}

}
