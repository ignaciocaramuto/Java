package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Habitacion;

public class DataHabitacion {
	
	public void add(Habitacion hab) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"insert into habitacion(denominacion, id_Tipo_Habitacion) values(?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setString(1, hab.getDenominacion());
			//stmt.setString(2, hab.getId_Tipo_Habitacion());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                //hab.setId_Tipo_Habitacion(keyResultSet.getInt(1));
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
