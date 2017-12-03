package controlers;

import java.util.ArrayList;
import java.util.List;


import data.DataElemento;
import data.DataTipoElemento;
import entity.Elemento;
import entity.TipoElemento;
public class CtrlABMElemento {
	

	private DataElemento dataElem;
	private DataTipoElemento dataTipo;
	
	public void add(Elemento e){
		dataElem= new DataElemento();
		dataElem.add(e);
		
		}
	public void delete(Elemento e){
		dataElem= new DataElemento();
		dataElem.delete(e);
		
		}

	public void update(Elemento e){
		dataElem= new DataElemento();
		dataElem.update(e);
		
		}

	public Elemento getByNombre(Elemento e){
		dataElem= new DataElemento();
		return this.dataElem.getByElemento(e);
	
	}
	
	public Elemento getByTipo(String tipo){
		dataElem= new DataElemento();
		return this.dataElem.getByTipo(tipo);
	
	}	
	
	public Elemento getByID(int id){
		dataElem= new DataElemento();
		return this.dataElem.getById(id);
	}	
	
	public Elemento getByNombre(String nombre){
		dataElem= new DataElemento();
		Elemento e=new Elemento();
		e = dataElem.getByNombre(nombre);
		return e;
		
	}
	


	public ArrayList<TipoElemento> getTipo(){
		dataElem= new DataElemento();
		return dataTipo.getAll();
	}
		
	

	public List<Elemento> loadElementos(TipoElemento tipoel){
		
		java.util.List<Elemento> elementos = new java.util.ArrayList<Elemento>();
		elementos.addAll(this.getElementos(tipoel));
			return elementos;}
	

public ArrayList<Elemento> getElementos(TipoElemento tipoel){ 
	dataElem= new DataElemento();
	return dataElem.getAll(tipoel);
}

public ArrayList<Elemento> getAll(){ 
	dataElem= new DataElemento();
	return dataElem.getAll();
}
}
