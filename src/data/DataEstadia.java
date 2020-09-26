package data;

import java.util.ArrayList;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import entities.Cliente;
import entities.Estadia;

public class DataEstadia {

	public void add(int i, Estadia es, Cliente c) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=DbConnector.getInstancia().getConn().
					prepareStatement(
							"insert into estadia(fecha_Ingreso, fecha_Egreso, estado, id_Cliente, nro_Habitacion) values(?,?,?,?,?)",
							PreparedStatement.RETURN_GENERATED_KEYS
							);
			stmt.setDate(1, (java.sql.Date) es.getFechaIngreso());
			stmt.setDate(2, (java.sql.Date) es.getFechaEgreso());
			stmt.setString(3, "Reservada");
			stmt.setInt(4, c.getIdCliente());
			stmt.setInt(5, i);
			stmt.executeUpdate();
			
			keyResultSet=stmt.getGeneratedKeys();
            if(keyResultSet!=null && keyResultSet.next()){
                es.setIdEstadia(keyResultSet.getInt(1));
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
