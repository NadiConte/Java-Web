package controlers;

import java.util.ArrayList;
import data.DataElemento;
import data.DataPersona;
import data.DataReserva;
import data.DataTipoElemento;
import entity.Elemento;
import entity.Persona;
import entity.Reserva;
import entity.TipoElemento;


public class CtrlABMReserva {

	private DataReserva dataRes;
	private DataPersona dataPer;
	private DataElemento dataElem;
	private DataTipoElemento dataTipo;
	private ArrayList<Reserva> res;
	
	
		
	public CtrlABMReserva() {
		dataRes = new DataReserva();
		dataElem= new DataElemento();
		dataPer= new DataPersona();
		dataTipo= new DataTipoElemento();
	}
	
	public void add(Reserva r) {
		dataRes.add(r);;
	}
	
	public void delete(Reserva r){
		dataRes.delete(r);
	}
	
	public void update(Reserva r){
		dataRes.update(r);
		
		
	}
	
	
	public ArrayList<Reserva> getAll(){
	return dataRes.getAll();}
	
	public ArrayList<Persona> getPersonas(){
	return dataPer.getAll();}
	
	
	
	public ArrayList<Reserva> reservasDePer(Persona logged) {
		return dataRes.getReservasdePer(logged);
		
	}
	
	public void cancelarReservas(Persona logged) {
		dataRes.CancelarReservasDePersona(logged);
	}
	
	
	
	public String datosRes(Reserva r) throws Exception{
		
		String msj = 
				"Datos de la reserva: "+ r.getId_reserva()+"\n"
				+ "Tipo de elemento: " + r.getElemento().getTipoElemento().getNombre()+"\n"
				+ "Elemento reservado: " + r.getElemento().getNombre()+"\n"
				+ "Fecha de inicio de la reserva: " + r.getFecha_hora_desde()+"\n"
				+ "Fecha de fin de la reserva: " + r.getFecha_hora_hasta()+"\n"
				+ "Datos personales:\n"
				+ "Nombre: " + r.getPersona().getNombre()+"\n"
				+ "Apellido: " + r.getPersona().getApellido()+"\n";
		return msj;
	}
	
	public int cantReservasXTipo(Persona p,TipoElemento t, Elemento e) {
		return dataRes.cantReservasXTipo(p, t, e);
	}
	
	public boolean estaDisponible(Reserva r) {
		return dataRes.estaDisponible(r);
	}
	
	
}	