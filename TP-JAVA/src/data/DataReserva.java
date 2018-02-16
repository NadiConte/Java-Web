package data;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
		 			+ "inner join elemento e on r.id_elemento=e.id_elemento "
					+ "inner join persona p on r.id_persona = p.id_persona");
			if(rs!=null){
				while(rs.next()){
					Reserva r=new Reserva();
					r.setElemento(new Elemento());
					r.setId_reserva(rs.getInt("id_reserva"));
					r.setFecha_hora_desde(rs.getTimestamp("fecha_hora_desde")); 
					r.setFecha_hora_hasta(rs.getTimestamp("fecha_hora_hasta")); 
					r.setDescripcion(rs.getString("descripcion"));
					r.setPersona(new Persona());
					r.getPersona().setUsuario(rs.getString("p.usuario"));
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
	
	public Reserva getReservasPorID(int id){ //OBTENER RESERVAS POR PERSONA
		Reserva r=new Reserva();
		PreparedStatement stmt=null;
			ResultSet rs=null;
			try {
				stmt = FactoryConexion.getInstancia().getConn()
						.prepareStatement("select * from reserva r "
			 			+ "inner join elemento e on r.id_elemento=e.id_elemento "
			 			+ "inner join persona p on r.id_persona=p.id_persona "		
			 			+ "where id_reserva = ? and r.fecha_hora_desde>=now()",
			 			PreparedStatement.RETURN_GENERATED_KEYS);
				
				stmt.setInt(1, id);
				
				
				rs = stmt.executeQuery();
				if(rs!=null){
					while(rs.next()){
						DataPersona dp = new DataPersona();
						int idp = rs.getInt("p.id_persona");
						
						r.setElemento(new Elemento());
						r.setId_reserva(rs.getInt("id_reserva"));
						r.setFecha_hora_desde(rs.getTimestamp("fecha_hora_desde")); 
						r.setFecha_hora_hasta(rs.getTimestamp("fecha_hora_hasta")); 
						r.setDescripcion(rs.getString("descripcion"));
						r.getElemento().setId_elemento(rs.getInt("id_elemento"));
			 			r.getElemento().setNombre(rs.getString("e.nombre"));
			 			r.setPersona(new Persona());
			 			r.setPersona(dp.getById(idp));
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
			return r;	
		}
	
public ArrayList<Reserva> getReservasdePer(Persona per){ //OBTENER RESERVAS POR PERSONA
	
	PreparedStatement stmt=null;
		ResultSet rs=null;
		ArrayList<Reserva> reservas= new ArrayList<Reserva>();
		try {
			stmt = FactoryConexion.getInstancia().getConn()
					.prepareStatement("select * from reserva r "
		 			+ "inner join elemento e on r.id_elemento=e.id_elemento "
		 			+ "inner join persona p on r.id_persona = p.id_persona "
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
					r.setPersona(new Persona());
					r.getPersona().setUsuario(rs.getString("p.usuario"));
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
					"insert into reserva (descripcion, id_elemento, id_persona, fecha_hora_desde, fecha_hora_hasta) values (?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			//stmt.setTimestamp(1, new java.sql.Timestamp(r.getFecha_hora().getTime()));
 			stmt.setString(1, r.getDescripcion());
 			stmt.setInt(2, r.getElemento().getId_elemento());
 			stmt.setInt(3, r.getPersona().getId_persona());
			stmt.setTimestamp(4, new java.sql.Timestamp(r.getFecha_hora_desde().getTime()));
			stmt.setTimestamp(5, new java.sql.Timestamp(r.getFecha_hora_hasta().getTime()));
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
					"UPDATE  reserva SET fecha_hora_desde=?, descripcion=?, id_elemento =?, fecha_hora_hasta=? where id_reserva=? ",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setString(1, r.getFecha_hora_desde().toString());
			stmt.setString(2, r.getDescripcion());
			stmt.setInt(3, r.getElemento().getId_elemento());
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
	
	
	public int cantReservasXTipo(Persona p,TipoElemento t) {
		PreparedStatement stmt= null;
		ResultSet rs=null;
		int i=0;
		try{ 
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select * from reserva r" //se puede contar tambien con un count(*)
				+ " inner join elemento e on e.id_elemento = r.id_elemento"
				+ " where (r.id_persona = ? and e.id_tipo = ? and r.fecha_hora_hasta >= now())");
		stmt.setInt(1,p.getId_persona());
		stmt.setInt(2,t.getId_tipo());	
			
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
	
	public boolean estaDisponible(Reserva r, TipoElemento t){
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new Date();
		
		
		PreparedStatement stmt= null;
		ResultSet rs=null;
		boolean i=true;
		try{ 
		stmt= FactoryConexion.getInstancia().getConn().prepareStatement( "select * from reserva r"
				+ " where r.id_elemento=? AND r.fecha_hora_desde >= ? AND r.fecha_hora_hasta <= ?  ");
		
		stmt.setInt(1,r.getElemento().getId_elemento());
		stmt.setString(2, dateFormat.format(r.getFecha_hora_desde()));		 
		stmt.setString(3, dateFormat.format(r.getFecha_hora_hasta()));
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
	
