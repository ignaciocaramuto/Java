package ui;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
			executeCommand(command, c);
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

<<<<<<< HEAD
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
		String option;
=======
		System.out.print("password: ");
		c.setContraseña(s.nextLine());
		
		c=ctrlLogin.validateCliente(c);
		
		return c;
	}
	
	private void executeCommand(String command, Cliente c) {
>>>>>>> nacho
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
<<<<<<< HEAD
			option=subMenu("habitacion");
			//executeABMCHabitacion(option);
			break;
		case "5":
			option=subMenu("servicio");
			//executeABMCServicio(option);
			break;
		case "6":
			//RealizarReserva
=======
			 addHabitacion();
	
			break;
		case "5":
			addServicio();
			
			break;
		case "6":
			reservaHabitacion(c);
			
			break;
		case "7":
			deleteTipoHabitacion();
			
>>>>>>> nacho
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
	private void executeABMCCliente(String option) {
		switch (option) {
		case "1":
			addCliente();
			break;
		case "2":
		//	deleteCliente();
			break;
		case "3":
		//modifyCliente();	
			break;
		case "4":
		//loqueseacCliente();
	
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
		System.out.println("4\t\tABMC Habitacion"); //Tiene que pertenecer a un tipo de habitacion
		System.out.println("5\t\tABMC Servicio");
		System.out.println("6\t\tRealizar reserva de habitacion");
		System.out.println();
		System.out.print("comando: ");
		return s.nextLine();
	}
<<<<<<< HEAD
	//de aca para abajo capaz iria mejor en logica
=======
	
	//metodo para convertir la fecha al formato "yyyy-mm-dd"
	private Date convertDate(String date) {
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //se formatea la fecha a yyyy-MM-dd
		Date myDate = null; //crea un objeto myDate de tipo Date
		try {
			myDate = formatter.parse(date); //convierte la variable date ingresada por teclado en la fecha formateada y se la asigna al a variable myDate de tipo Date
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return myDate;
	}
	
	//metodo para registrar un cliente en la db
>>>>>>> nacho
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
		Date myDate = convertDate(date);
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
	
	//metodo para añadir un tipo de habitacion
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
	
	//metodo para modificar un tipo de habitacion
	private void updateTipoHabitacion() {
		System.out.println();
		Tipo_Habitacion th = new Tipo_Habitacion();
		System.out.println("Ingrese id del tipo de habitacion a editar: ");
		th.setId_Tipo_Habitacion(s.nextInt());
		System.out.println("Ingrese denominacion del tipo de habitacion: ");
		s.nextLine();
		th.setDenominacion(s.nextLine());
		System.out.println("Ingrese descripcion del tipo de habitacion: ");
		th.setDescripcion(s.nextLine());
		System.out.println("Ingrese cantidad de personas del tipo de habitacion: ");
		th.setCapacidad_Personas(s.nextInt());
		System.out.println("Ingrese precio por dia del tipo de habitacion: ");
		th.setPrecio_Por_Dia(s.nextFloat());
		ctrlLogin.updateTipoHabitacion(th);
	}
	
	private void deleteTipoHabitacion() {
		System.out.println();
		Tipo_Habitacion th = new Tipo_Habitacion();
		System.out.print("Ingrese id del tipo de habitacion a eliminar: "); 
		th.setId_Tipo_Habitacion(s.nextInt());
		ctrlLogin.deleteTipohabitacion(th);
	}
	
	private Tipo_Habitacion validateTipoHabitacion(Tipo_Habitacion th) {
		
		return ctrlLogin.validateTipo_Habitacion(th);
	}  
	
	//metodo para añadir una habitacion
	private void addHabitacion() {
		System.out.println();
		Tipo_Habitacion th = new Tipo_Habitacion();
		Habitacion h = new Habitacion();
		System.out.print("Ingrese denominacion del tipo de habitacion: ");
		th.setDenominacion(s.nextLine());
		Tipo_Habitacion thab = validateTipoHabitacion(th);
		//System.out.print(thab.getId_Tipo_Habitacion());
		if (thab!=null) {
			h.setId_Tipo_Habitacion(thab.getId_Tipo_Habitacion());
			//System.out.print(h.getId_Tipo_Habitacion());
			ctrlLogin.add_Habitacion(h);
		}
	}
	
	//metodo para añadir un servicio
	private void addServicio() {
		System.out.println();
		Servicio ser = new Servicio();
		System.out.print("Ingrese denominacion del servicio: ");
		ser.setDenominacion(s.nextLine());
		System.out.print("Ingrese descripcion del servicio: ");
		ser.setDescripcion(s.nextLine());
		System.out.print("Ingrese costo del servicio: ");
		ser.setCosto(s.nextDouble());
		ctrlLogin.add_Servicio(ser);
	}
	
	//metodo para reservar una habitacion
	private void reservaHabitacion(Cliente c) {
		System.out.println();
		Habitacion h = new Habitacion();
		Estadia es = new Estadia();
		Tipo_Habitacion  th = new Tipo_Habitacion();
		System.out.print("Ingrese fecha desde: ");
		String date;
		Date today = Calendar.getInstance().getTime();
		Date myDate = null;
		do { 
			date=s.nextLine();
			myDate = convertDate(date); //metodo para convertir la fecha al formato "yyyy-mm-dd"
		}while(myDate.compareTo(today) < 0); //valida que no se ingrese una fecha anterior a hoy
		
		java.sql.Date sqlDate = new java.sql.Date(myDate.getTime()); //crea la variable sqlDate del tipo java.sql.Date y le asigna el valor de la variable myDate con el tiempo para poder insertarla en la db
		es.setFechaIngreso(sqlDate);
		System.out.print("Ingrese fecha hasta: ");
		String date2;
		Date myDate2 = null;
		do { 
			date2=s.nextLine();
			myDate2 = convertDate(date2);
		}while((myDate2.compareTo(today) < 0) || (myDate2.compareTo(myDate) <= 0)); //valida que no se ingrese una fecha anterior a hoy 0 que la fecha de egreso no sea menor o igual que la fecha de ingreso
		
		java.sql.Date sqlDate2 = new java.sql.Date(myDate2.getTime()); //crea la variable sqlDate del tipo java.sql.Date y le asigna el valor de la variable myDate con el tiempo para poder insertarla en la db
		es.setFechaEgreso(sqlDate2);
		System.out.print("Ingrese tipo de habitacion que desea reservar: ");
		th.setDenominacion(s.nextLine());
		Tipo_Habitacion thab = validateTipoHabitacion(th);
		if(thab!=null) {
			h = ctrlLogin.buscarHabitacionesLibres(thab, es); //metodo para encontrar todas las habitaciones disponibles dentro de las fechas ingresadas
			if (h == null) {
				System.out.print("No hay habitaciones disponibles para esas fechas");
				return;
			}
		} else {
			System.out.print("No existe ese tipo de habitacion");
			return;
		}
		ctrlLogin.createEstadia(h.getNro_Habitacion(), es, c); //le pasa los parametros del nro de habitacion, el objeto estadia y el cliente logueado
		System.out.print("Habitacion reservada para el dia " + es.getFechaIngreso() + " al " + es.getFechaEgreso() + "\n"+
				"Cliente: " + c.getApellido() + ", " + c.getNombre());
		}
	
}
