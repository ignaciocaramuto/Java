package data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Servicio;

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

}
