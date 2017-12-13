package controlers;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JComboBox;

import org.jdesktop.beansbinding.AutoBinding.UpdateStrategy;
import org.jdesktop.swingbinding.JComboBoxBinding;
import org.jdesktop.swingbinding.SwingBindings;

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
	
	public void initDataBindings(ArrayList<Elemento> elementos, JComboBox cboElementos_1) {
		JComboBoxBinding<Elemento,List<Elemento>,JComboBox> jComboBinding = SwingBindings.createJComboBoxBinding(UpdateStrategy.READ_WRITE, elementos, cboElementos_1, "elementosDeUnTipo");
		jComboBinding.bind();
	}	
	
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



}	