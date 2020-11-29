package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Estadia;
import entities.Servicio;
import entities.Tipo_Habitacion;

public class DataServicio {
	
	public void add(Servicio s) {
		
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into servicio(denominacion, descripcion, costo) values(?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setString(1, s.getDenominacion());
			stmt.setString(2, s.getDescripcion());
			stmt.setDouble(3, s.getCosto());
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                s.setIdServicio(keyResultSet.getInt(1));
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


	public float CalculatePriceForEstadia(Estadia es) {
		float precioTotal=0;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=DbConnector.getInstancia().getConn().prepareStatement(
					"SELECT sum(costo) as costo FROM hotel.estadia_servicio es\r\n" + 
					"inner join servicio s on s.id_servicio=es.id_servicio\r\n" + 
					"where es.id_estadia=?;"
					);
			stmt.setInt(1, es.getIdEstadia());
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()) {
				
				 precioTotal=(rs.getFloat("costo"));
				 // precioTotal=precioTotal+(rs.getFloat("costo"));
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
		
		return precioTotal;
	
	}
}
