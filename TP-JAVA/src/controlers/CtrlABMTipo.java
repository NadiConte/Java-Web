package controlers;


import java.util.ArrayList;
import java.util.List;

import data.DataTipoElemento;
import entity.TipoElemento;

public class CtrlABMTipo {
	
	private DataTipoElemento dataTipo;


	
	public CtrlABMTipo(){
	dataTipo= new DataTipoElemento();
	}
	

	public void add(TipoElemento t) {
		dataTipo.add(t);;
	}
	
	public void delete(TipoElemento t){
		dataTipo.delete(t);
	}
	
	public void update(TipoElemento t){
		dataTipo.update(t);
	}
		
	public TipoElemento getByNombre(TipoElemento t){
		return this.dataTipo.getByNombre(t);
	}
	
	public TipoElemento getByNombre(String nombre){
		TipoElemento t=new TipoElemento();
		t.setNombre(nombre);
		return getByNombre(t);
	}
	
	public ArrayList<TipoElemento> getTipos(){
		return dataTipo.getAll();}


	public ArrayList<TipoElemento>getAll() throws Exception{
		return dataTipo.getAll();
		}

	
	public List<TipoElemento> loadtipos() { 
		java.util.List<TipoElemento> tipos = new java.util.ArrayList<TipoElemento>();
		tipos.addAll(this.getTipos());
		return tipos;
	}
	
	public TipoElemento getByID(int id) {
		return dataTipo.getByID(id);
	}
	
}
