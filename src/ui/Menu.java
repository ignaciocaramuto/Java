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
		boolean validate = false;
		while (!validate) {
		
		try {
			
			
			System.out.print("Email: ");
			c.setMail(s.nextLine());

			System.out.print("password: ");
			c.setContraseña(s.nextLine());
			
			c=ctrlLogin.validate(c);
			String name=c.getNombre();
			//Para que me tire una excepcion si esta vacio(ver si hay mejor forma)
			validate = true;
			
		} catch (Exception e) {
			System.out.println("Email/contraseña incorrecto, intente de nuevo");
			c=new Cliente();
		}
		}
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
		case "3":
			addTipo_Habitacion();
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
		System.out.println("3\t\tABMC Tipo de habitacion");
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
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //se formatea la fecha a yyyy-MM-dd
		Date myDate = null; //crea un objeto myDate de tipo Date
		try {
			myDate = formatter.parse(date); //convierte la variable date ingresada por teclado en la fecha formateada
		} catch (ParseException e) {
			e.printStackTrace();
		}
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime()); //crea la variable sqlDate del tipo java.sql.Date y le asigna el valor de la variable myDate con el tiempo para poder insertarla en la db
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
	
	private void addTipo_Habitacion() {
		System.out.println();
		Tipo_Habitacion th = new Tipo_Habitacion();
		System.out.print("Ingrese denominacion: ");
		th.setDenominacion(s.nextLine());
		System.out.print("Ingrese descripcion: ");
		th.setDescripcion(s.nextLine());
		System.out.print("Ingrese capacidad maxima de personas: ");
		th.setCapacidad_Personas(s.nextInt());
		System.out.print("Ingrese precio por dia: ");
		th.setPrecio_Por_Dia(s.nextFloat());
		ctrlLogin.addTipohabitacion(th);
	}

}
