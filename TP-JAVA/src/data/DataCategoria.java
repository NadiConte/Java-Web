package data;

import java.util.ArrayList;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import entity.Categoria;
import entity.TipoElemento;

public class DataCategoria {

	public ArrayList<Categoria> getAll(){
		Statement stmt=null;
		ResultSet rs= null;
		ArrayList<Categoria> cats= new ArrayList<Categoria>();
		try {
			stmt = FactoryConexion.getInstancia().getConn().createStatement();
			rs= stmt.executeQuery("select * from categoria");
			if(rs!=null){
				while(rs.next()){
					Categoria c= new Categoria();
					c.setId_categoria(rs.getInt("id_categoria"));
					c.setNombreCat(rs.getString("nombre"));
					cats.add(c);
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
		return cats;
				
	}
	
	public Categoria getByID(int id){
		Categoria c=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		try {
			stmt=FactoryConexion.getInstancia().getConn().prepareStatement(
					"select * from categoria c where c.id_categoria=?");
			stmt.setInt(1, id);
			rs=stmt.executeQuery();
			if(rs!=null){
				while(rs.next()) {
					c=new Categoria();
					c.setId_categoria(rs.getInt("id_categoria"));
					c.setNombreCat(rs.getString("nombre"));
				}
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		try {
			if(rs!=null)rs.close();
			if(stmt!=null)stmt.close();
			FactoryConexion.getInstancia().releaseConn();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		return c;
	}
}
