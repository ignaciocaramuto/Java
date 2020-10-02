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

	public Habitacion getOne(int nroHabitacion){
		Habitacion h=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT * FROM hotel.habitacion where nro_Habitacion=?"
					);
			stmt.setInt(1, nroHabitacion);
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				h=new Habitacion();
				h.setNro_Habitacion(rs.getInt("nro_Habitacion"));
				h.setDenominacion(rs.getString("denominacion"));
				h.setNroTipoHabitacion(rs.getInt("id_Tipo_Habitacion"));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null) {rs.close();}
				if(stmt!=null) {stmt.close();}
				DbConnector.getInstancia().releaseConn();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return h;
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
