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
		 			+ "where id_persona = ?",
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
	
	public ArrayList<Elemento> elementosDisp(java.util.Date fechaHora, TipoElemento t) { 
		ArrayList<Elemento> disponibles = new ArrayList<Elemento>();

		PreparedStatement stmt=null;
		ResultSet rs=null;
		
		try {						
			stmt = FactoryConexion.getInstancia()
					.getConn().prepareStatement("SET @fecha =  ?, @tipo=?;");
			stmt.setTimestamp(1, new java.sql.Timestamp(fechaHora.getTime()));
			stmt.setInt(2,t.getId_tipo());
			stmt.executeQuery();

			
			stmt = FactoryConexion.getInstancia()
					.getConn().prepareStatement("select e.id_elemento, e.nombre from elemento e "
							+ "inner join tipoelemento t on e.id_tipo=t.id_tipo\n"
							+ "where t.id_tipo=@tipo and e.id_elemento not in (\n"
							+ "select e.id_elemento from elemento e left join reserva r on e.id_elemento=r.id_elemento \n" + 
							"inner join tipoelemento t on e.id_tipo=t.id_tipo\n" + 
							"where t.id_tipo=@tipo\n" + 
							"and (@fecha between r.fecha_hora_desde and r.fecha_hora_hasta) "
							+ "or (date_add(@fecha, INTERVAL t.tiempoMax*60 minute) between r.fecha_hora_desde and r.fecha_hora_hasta)"
							+ "or(@fecha<r.fecha_hora_desde and date_add(@fecha, INTERVAL t.tiempoMax*60 minute)>r.fecha_hora_hasta)"
							+ "and (r.estado='activa'))");				
			
			rs = stmt.executeQuery();
			if(rs!=null){
				while(rs.next()){
					Elemento e=new Elemento();
					e.setId_elemento(rs.getInt("id"));
					e.setNombre(rs.getString("nombre"));					
					disponibles.add(e);
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
		return disponibles;
	}
}	
	
