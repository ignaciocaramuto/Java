package connections;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connections.ConeccionDbHotel;
import entities.*;


public class ConeccionServicio {

	public void add() {
		//hacer que devuelva el servicio insertado y que reciba los datos como parametros
		PreparedStatement stmt= null;
		ResultSet keyResultSet=null;
		//Servicio s=new Servicio();
		try {
			stmt=ConeccionDbHotel.getInstancia().getConn().
					prepareStatement(
							"insert into servicio(denominacion,descripcion,costo) values('masajes','te hacen masajes','152')",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			System.out.println("entro");
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
			System.out.println(keyResultSet.toString());
            /*
			if(keyResultSet!=null && keyResultSet.next()){
                
                s.setDenominacion(keyResultSet.getString("denominacion"));
                s.setDescripcion(keyResultSet.getString("descripcion"));
                s.setIdServicio(keyResultSet.getInt("id_Servicio"));
                s.setCosto(keyResultSet.getFloat("costo"));
            }
			*/
			
		}  catch (SQLException e) {
            e.printStackTrace();
		} finally {
            try {
                if(keyResultSet!=null)keyResultSet.close();
                if(stmt!=null)stmt.close();
                ConeccionDbHotel.getInstancia().releaseConn();
            } catch (SQLException e) {
            	e.printStackTrace();
            }
		}
	
	
	
}
}
