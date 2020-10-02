package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Cliente;
import entities.Habitacion;

public class DataHabitacion {
	public void deleteHabitacion(int nroHab) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"DELETE FROM habitacion WHERE (`nro_Habitacion` = ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);

			stmt.setInt(1, nroHab);
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            System.out.println(keyResultSet);//borrar

			
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

	public void add(Habitacion h) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"INSERT INTO `hotel`.`habitacion` (`denominacion`, `id_Tipo_Habitacion`) VALUES (?, ?);",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, h.getDenominacion());
			stmt.setInt(2, h.getNroTipoHabitacion());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                h.setNro_Habitacion(keyResultSet.getInt(1));
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
