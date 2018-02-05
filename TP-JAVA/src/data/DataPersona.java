package data;

import java.util.ArrayList;
import java.sql.*;

import entity.*;

public class DataPersona {

	public ArrayList<Persona> getAll(){
	
		Statement stmt=null;
		ResultSet rs=null;
		ArrayList<Persona> pers= new ArrayList<Persona>();
		try {
			stmt = FactoryConexion.getInstancia()
					.getConn().createStatement();
			rs = stmt.executeQuery("select * from persona p "
		 			+ "inner join categoria c on p.id_categoria=c.id_categoria");
			if(rs!=null){
				while(rs.next()){
					Persona p=new Persona();
					p.setCategoria(new Categoria());
					p.setId_persona(rs.getInt("id_persona"));
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));
					p.setDni(rs.getString("dni"));
					p.setHabilitado(rs.getBoolean("habilitado"));
					p.setEmail(rs.getString("email"));
					p.setContraseña(rs.getString("pass"));
					p.setUsuario(rs.getString("usuario"));
		 			p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
		 			p.getCategoria().setNombreCat(rs.getString("c.nombre"));
					pers.add(p);
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
		
		return pers;
		
	}
	
	public Persona getByDni(Persona per){
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_persona, p.nombre, apellido, dni, habilitado, email, p.id_categoria, c.nombre from persona p "
					+ "inner join categoria c on p.id_categoria=c.id_categoria where dni=?");
			stmt.setString(1, per.getDni());
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Persona();
				p.setCategoria(new Categoria());
				p.setId_persona(rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setEmail(rs.getString("email"));
				p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
				p.getCategoria().setNombreCat(rs.getString("nombre")); 
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public Persona getById(int id){
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_persona, p.nombre, apellido, dni, habilitado, email, p.id_categoria, c.nombre from persona p "
					+ "inner join categoria c on p.id_categoria=c.id_categoria where id_persona=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Persona();
				p.setCategoria(new Categoria());
				p.setId_persona(rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setEmail(rs.getString("email"));
				p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
				p.getCategoria().setNombreCat(rs.getString("nombre")); 	
	 		}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}
	
	public void add(Persona p){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"insert into persona(dni, nombre, apellido, habilitado, email, id_categoria, usuario, pass) values (?,?,?,?,?,?,?,?)",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, p.getDni());
 			stmt.setString(2, p.getNombre());
 			stmt.setString(3, p.getApellido());
 			stmt.setBoolean(4, p.isHabilitado());
 			stmt.setString(5, p.getEmail());
 			stmt.setInt(6, p.getCategoria().getId_categoria());
 			stmt.setString(7, p.getUsuario());
 			stmt.setString(8, p.getContraseña());
 			
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId_persona(keyResultSet.getInt(1));
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
	
	public void borrar(Persona p){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"DELETE FROM persona where id_persona=?",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setInt(1, p.getId_persona());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId_persona(keyResultSet.getInt(1));
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
	
	public void actualizar(Persona p){
		PreparedStatement stmt=null;
		ResultSet keyResultSet=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"UPDATE  persona SET dni=?, nombre=? , apellido=?,usuario=?, pass=?, habilitado=?, email?, id_categoria=? where id_persona=? ",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			
			stmt.setString(1, p.getDni());
			stmt.setString(2, p.getNombre());
			stmt.setString(3, p.getApellido());
			stmt.setString(4, p.getUsuario());
			stmt.setString(5, p.getContraseña());
			stmt.setBoolean(6, p.isHabilitado());
			stmt.setString(7, p.getEmail());
 			stmt.setInt(8, p.getCategoria().getId_categoria());
			stmt.setInt(9, p.getId_persona());
			stmt.executeUpdate();
			keyResultSet=stmt.getGeneratedKeys();
			if(keyResultSet!=null && keyResultSet.next()){
				p.setId_persona(keyResultSet.getInt(1));
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
	
	public Boolean isUserValid(Persona per) {
		int aux = 0;
		ResultSet rs=null;
		PreparedStatement stmt=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn()
					.prepareStatement(
					"select * from persona where usuario = ? and pass = ?",
					PreparedStatement.RETURN_GENERATED_KEYS
					);
			stmt.setString(1, per.getUsuario());
			stmt.setString(2, per.getContraseña());
			
			rs= stmt.executeQuery();
		if(rs!=null && rs.next() && rs.getInt("habilitado")==1){
			return true;}	
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return false;
		



}
	
	public Persona validarUsuario(String user, String pass){
		Persona p=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select id_persona, p.nombre, apellido, dni, habilitado, email, p.id_categoria, c.nombre from persona p "
					+ "inner join categoria c on p.id_categoria=c.id_categoria where usuario=? and pass = ? and habilitado = 1");
			stmt.setString(1, user);
			stmt.setString(2, pass);
			
			rs=stmt.executeQuery();
			if(rs!=null && rs.next()){
				p=new Persona();
				p.setCategoria(new Categoria());
				p.setId_persona(rs.getInt("id_persona"));
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setDni(rs.getString("dni"));
				p.setHabilitado(rs.getBoolean("habilitado"));
				p.setEmail(rs.getString("email"));
				p.getCategoria().setId_categoria(rs.getInt("id_categoria"));
				p.getCategoria().setNombreCat(rs.getString("nombre")); 
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return p;
	}

}


