package data;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import entities.*;

public class DataTipoHabitacion {
	
	public void add(Tipo_Habitacion th) {
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"insert into tipo_habitacion(denominacion, descripcion, capacidad_Personas, precio_Por_Dia) values(?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setString(1, th.getDenominacion());
			stmt.setString(2, th.getDescripcion());
			stmt.setInt(3, th.getCapacidad_Personas());
			stmt.setFloat(4, th.getPrecio_Por_Dia());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                th.setId_Tipo_Habitacion(keyResultSet.getInt(1));
            }
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                DbConnector.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
		
		
		
		
		

		
		
	}
}	

