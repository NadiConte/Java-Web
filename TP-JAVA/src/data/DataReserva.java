package data;

import java.util.Date;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import entity.Elemento;
import entity.Persona;
import entity.Reserva;
import entity.TipoElemento;

public class DataReserva {

	public ArrayList<Reserva> getAll(){
		//DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		//java.util.Date date = new Date();
		
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from reserva r "
		 			+ "inner join elemento e on r.id_elemento=e.id_elemento");
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setElemento(new Elemento());
					r.setId_reserva(rs.getInt("id_reserva"));
					r.setFecha_hora_desde(rs.getTimestamp("fecha_hora_desde")); 
					r.setFecha_hora_hasta(rs.getTimestamp("fecha_hora_hasta")); 
					r.setEstado(rs.getString("estado"));
					r.setDescripcion(rs.getString("descripcion"));
					
					r.getElemento().setId_elemento(rs.getInt("id_elemento"));
		 			r.getElemento().setNombre(rs.getString("e.nombre"));
		 			reservas.add(r);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return reservas;	
	}
	
public ArrayList<Reserva> getReservasdePer(Persona per){ //OBTENER RESERVAS POR PERSONA
	
	PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from reserva r "
		 			+ "inner join elemento e on r.id_elemento=e.id_elemento "
		 			+ "where id_persona = ? and r.fecha_hora_desde>=curdate()",
		 			PreparedStatement.RETURN_GENERATED_KEYS);
			
			stmt.setInt(1, per.getId_persona());
			
			
			rs = stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setElemento(new Elemento());
					r.setId_reserva(rs.getInt("id_reserva"));
					r.setFecha_hora_desde(rs.getTimestamp("fecha_hora_desde")); 
					r.setFecha_hora_hasta(rs.getTimestamp("fecha_hora_hasta")); 
					r.setDescripcion(rs.getString("descripcion"));
					r.setEstado(rs.getString("estado"));
					
					r.getElemento().setId_elemento(rs.getInt("id_elemento"));
		 			r.getElemento().setNombre(rs.getString("e.nombre"));
		 			reservas.add(r);
				}
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		return reservas;	
	}
	
	public void add(Reserva r){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into reserva (descripcion, id_elemento, id_persona, fecha_hora_desde, fecha_hora_hasta, estado) values (?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			//stmt.setTimestamp(1, new java.sql.Timestamp(r.getFecha_hora().getTime()));
 			stmt.setString(1, r.getDescripcion());
 			stmt.setInt(2, r.getElemento().getId_elemento());
 			stmt.setInt(3, r.getPersona().getId_persona());
			stmt.setTimestamp(4, new java.sql.Timestamp(r.getFecha_hora_desde().getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(r.getFecha_hora_hasta().getTime()));
 			stmt.setString(6, r.getEstado());
 			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId_reserva(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(Reserva r){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"DELETE FROM reserva where id_reserva=?",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, r.getId_reserva());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId_reserva(keyResultSet.getInt(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	public void update(Reserva r){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE  reserva SET fecha_hora_desde=?, descripcion=?, id_elemento =?, estado=?, fecha_hora_hasta=? where id_reserva=? ",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setString(1, r.getFecha_hora_desde().toString());
			stmt.setString(2, r.getDescripcion());
			stmt.setInt(3, r.getElemento().getId_elemento());
			stmt.setString(4, r.getEstado());
			stmt.setString(5, r.getFecha_hora_hasta().toString());
			stmt.setInt(6, r.getId_reserva());			
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				r.setId_reserva(keyResultSet.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}

	public void CancelarReservasDePersona(Persona logged) {
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"DELETE FROM reserva where id_persona=?",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, logged.getId_persona());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			if(keyResultSet!=null)keyResultSet.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public void cancelar(Reserva r) {
		 		PreparedStatement stmt=null;
		 	
		  		try {
		 			stmt=FactoryConexion.getInstancia().getConn()
		 				.prepareStatement(
		 					"update reservas set estado=? where id_reserva=?"					
		 					);
		 			stmt.setString(1,"cancelada");
		 			stmt.setInt(2, r.getId_reserva());			
		 		
		 
		 			stmt.executeUpdate();
		  		} catch (SQLException e) {
		  			e.printStackTrace();
		  		}
		  		try {
		 		if(stmt!=null)stmt.close();
		 			if (stmt != null)
		 				stmt.close();
		  			FactoryConexion.getInstancia().releaseConn();
		  		} catch (SQLException e) {
		  			e.printStackTrace();
		  		}
		  	}
	
	public int  cantReservasXTipo(Persona p,TipoElemento t, Elemento e) {
		PreparedStatement stmt= null;
		ResultSet rs=null;
		int i=0;
		try{ 
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select * from reserva r "
				+ "inner join tipoelemento e on r.id_elemento=e.id_elemento"
				+ "where (r.id_persona=? and r.id_elemento=? and e.id_tipo=? and r.fecha_hora_hasta>=curdate())");
		stmt.setInt(1,p.getId_persona());
		stmt.setInt(2,t.getId_tipo());	
		stmt.setInt(3,e.getId_elemento());
			
			 rs=stmt.executeQuery();
			 if (rs!= null ){
					while(rs.next()){
						i++;
					}
			 }
		} catch (SQLException ex) {
			
			ex.printStackTrace();
		}
		try {
			if(rs!=null) rs.close();
			if(stmt!=null) stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException ex) {	
			ex.printStackTrace();
		}
		return (i);	
	}
	
	public boolean estaDisponible(Reserva r){
		PreparedStatement stmt= null;
		ResultSet rs=null;
		ArrayList<Reserva> res = new ArrayList<Reserva>();
		boolean i=true;
		try{ 
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select * from reserva r "
				+ "inner join tipoelemento e on r.id_elemento=e.id_elemento "
				+ "where (?<r.`hora_fecha_hasta` and ?>r.`hora_fecha_desde`) and (r.id_elemento=? and e.id_tipo=?)");
		stmt.setString(1, r.getFecha_hora_hasta().toString());
		stmt.setString(1, r.getFecha_hora_desde().toString());	
		stmt.setInt(3,r.getElemento().getId_elemento());
		stmt.setInt(4,r.getElemento().getTipoElemento().getId_tipo());			
			 
			 rs=stmt.executeQuery();
			 if(rs!=null && rs.next()){
						i=false;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				if(rs!=null) rs.close();
				if(stmt!=null) stmt.close();
				FactoryConexion.getInstancia().releaseConn();
			} catch (SQLException e) {	
				e.printStackTrace();
			}
			return (i);	
		} 
		 
			 
}	
	
