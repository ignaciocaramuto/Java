package conecciones;
import java.sql.*;
public class Coneccion_Servicios {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//creamos la coneccion
			Connection coneccion=DriverManager.getConnection("jdbc:mysql://190.138.217.160:3306/hotel","Ignacio","123");
		//crear statement
			Statement consulta=coneccion.createStatement();
		//ejecutar consulta sql
		String instruccionSql="INSERT INTO `hotel`.`servicios` ( `Denominacion`, `Descripcion`, `Costo`) VALUES ( 'as', 'as', '5')";
		consulta.executeUpdate(instruccionSql)	;
		System.out.println("Servicio insertado");
					
		}
		
		catch(Exception e){
			System.out.println("No se pudo conectar,error: "+e.toString());
		}
	}

}
