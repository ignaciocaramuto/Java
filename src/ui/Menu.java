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
			//c.setMail(s.nextLine());
			c.setMail("jp@gmail.com");

			System.out.print("password: ");
			//c.setContraseña(s.nextLine());
			c.setContraseña("jperez");
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
		String option;
		switch (command) {
		case "1":
			System.out.println(ctrlLogin.getAll());
			break;
		case "2":
			option=subMenu("cliente");
			executeABMCCliente(option);
			
			break;
		case "3":
			option=subMenu("tipo de habitacion");
			addTipo_Habitacion();
			//executeABMCTipoHabitacion(option);
			break;
		case "4":
			option=subMenu("habitacion");
			executeABMCHabitacion(option);
			break;
		case "5":
			option=subMenu("servicio");
			//executeABMCServicio(option);
			break;
		case "6":
			//RealizarReserva
			break;
		default:
			break;
		}
	}
	private String subMenu(String option) {
		System.out.println("1\t\tAgregar "+option);
		System.out.println("2\t\tEliminar "+option);
		System.out.println("3\t\tModificar "+option);
		System.out.println("4\t\tC "+option);
		return(s.nextLine());
	}
	
	private void executeABMCHabitacion(String option) {

		switch (option) {
		case "1":
			addHabitacion();
			break;
		case "2":
		//deleteCliente();
			break;
		case "3":
		//modifyCliente();	
			break;

		default:
			break;
		}
		
		
		
	}
	
	
	private void addHabitacion() {
		System.out.println();
		Habitacion h=new Habitacion();
		System.out.println("Ingrese la deniminacion :");
		h.setDenominacion(s.nextLine());
		System.out.println("Ingrese tipo de habitacion:");//agregar mostrat tipos
		h.setNroTipoHabitacion(s.nextInt());
		ctrlLogin.addHabitacion(h);
	}
	
	
	private void executeABMCCliente(String option) {
		switch (option) {
		case "1":
			addCliente();
			break;
		case "2":
		deleteCliente();
			break;
		case "3":
		modifyCliente();	
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
	private void modifyCliente() {
		boolean bandNoSeTrajoCliente=true;
		Cliente c=new Cliente();
		while (bandNoSeTrajoCliente){
		try {
			System.out.println("Ingrese el Nro de Documento del cliente que desea modificar");
			
			c=ctrlLogin.getOne(s.nextLine());
			boolean bandSeguirModificando=true;
			while(bandSeguirModificando) {
			System.out.println("Que desea modificar a "+c.getNombre()+" "+c.getApellido());
			System.out.print("1-Tipo doc ");

			System.out.print("2-Nro doc ");

			System.out.print("3-Nombre ");

			System.out.print("4-Apellido ");

			System.out.print("5-Email ");

			System.out.print("6-Password ");

			System.out.print("7-Telefono ");

			System.out.print("8-Sexo ");

			System.out.print("9-Fecha de nacimiento(yyyy-mm-dd) ");
			
			String option=s.nextLine();
			switch (option) {
			case "1":
			
				System.out.print("Ingrese Tipo doc: ");
				c.setTipoDoc(s.nextLine());
				break;
			case "2":
				System.out.print("Ingrese Nro doc: ");
				c.setNumDoc(s.nextLine());
				break;
			case "3":
				System.out.print("Ingrese Nombre: ");
				c.setNombre(s.nextLine());
				break;
			case "4":
				System.out.print("Ingrese Apellido: ");
				c.setApellido(s.nextLine());
				break;
			case "5":
				System.out.print("Ingrese Email: ");
				c.setMail(s.nextLine());
				break;
			case "6":
				System.out.print("Ingrese Password: ");
				c.setContraseña(s.nextLine());
				break;
			case "7":
				System.out.print("Ingrese Telefono: ");
				c.setTelefono(s.nextLine());
				break;
			case "8":
				System.out.print("Ingrese Sexo: ");
				c.setSexo(s.nextLine());
				break;
			case "9":
				System.out.print("Ingrese echa de nacimiento(yyyy-mm-dd): ");
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
				break;
			default:
				System.out.println("Ingrese una opcion valida");
			}
			System.out.println("¡Desea seguir modificando?(si/no)");
			String op=s.nextLine();
			if(op.equals("no")){
				bandSeguirModificando=false;
			}
			}
		ctrlLogin.modifyClient(c);
		System.out.println("Cliente modificado con exito");
			System.out.println(c);
			bandNoSeTrajoCliente=false;
			} catch (NullPointerException e) {
				System.out.println("No se encontro ningun cliente con ese dni\n");
			}
		
		}
	}
		
	
	
	private void deleteCliente() {
		boolean bandNoSeTrajoCliente=true;
		Cliente c=new Cliente();
		while (bandNoSeTrajoCliente){
		try {
			System.out.println("Ingrese el Nro de Documento del cliente que desea eliminar");
			
			c=ctrlLogin.getOne(s.nextLine());
			System.out.println("Eliminar a "+c.getNombre()+" "+c.getApellido()+"\n\n\n1-Si\n2-No");
			String option=s.nextLine();
			bandNoSeTrajoCliente=false;
			if (option.equals("1")) {
				ctrlLogin.deleteClient(c);
				System.out.println("El cliente "+c.getNombre()+" "+c.getApellido()+" fue eliminado con exito");
			} else {
				System.out.println("El cliente "+c.getNombre()+" "+c.getApellido()+" sigue en el sistema");
			}
		
			} catch (NullPointerException e) {
				System.out.println("No se encontro ningun cliente con ese dni\n");
			}
		}
		
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
