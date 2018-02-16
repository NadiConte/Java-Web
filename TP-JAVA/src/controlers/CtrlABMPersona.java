package controlers;

import java.util.ArrayList;

import data.DataCategoria;
import data.DataPersona;
import entity.Categoria;
import entity.Persona;

public class CtrlABMPersona {

	private DataPersona dataPer = new DataPersona();

	private ArrayList<Persona> pers= new ArrayList<Persona>();
	private DataCategoria dataCat= new DataCategoria();
		
	
	public void add(Persona p) {
		
				dataPer.add(p);
	}
	
	public void delete(Persona p){
		dataPer.borrar(p);
	}
	
	public void update(Persona newp){
		
		dataPer.actualizar(newp);
	}
		
	
	public Persona getByDni(Persona pe) {
		return this.dataPer.getByDni(pe);
	}
	
	public Persona getById(int id){
		return dataPer.getById(id);
	}
	
	public Categoria getByID(int id){
		return this.dataCat.getByID(id);
	}
	
	public Persona getByNombreApellido(Persona p){
		
		for (int i=0; i < this.pers.size(); i++){
			if(pers.get(i).getNombre().equalsIgnoreCase(p.getNombre())
				&& pers.get(i).getApellido().equalsIgnoreCase(p.getApellido())) {
				return pers.get(i);		
			}
		}
		return null; 
	}
	
	public ArrayList<Persona> getAll(){
		dataPer= new DataPersona();
		return dataPer.getAll();
	}
		
	public Boolean validarUSR(Persona p) {
		return dataPer.isUserValid(p);
	}
	
	public Persona loguearUsuario(String user, String pass) {
		return dataPer.validarUsuario(user, pass);
	}

	public ArrayList<Categoria> getCategorias(){
		return dataCat.getAll();
	}


	


}
