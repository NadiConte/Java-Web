package entity;

import java.sql.Date;
import java.text.DateFormat;

public class Reserva {
	
	private int id_reserva;
	private java.util.Date fecha_hora_desde;
	private java.util.Date fecha_hora_hasta;
	private String descripcion;
	private String estado;
	private Elemento elemento;
	private Persona persona;
	
	public Persona getPersona() {
		return persona;
	}

	public void setPersona(Persona persona) {
		this.persona = persona;
	}

	public int getId_reserva() {
		return id_reserva;
	}
	
	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}
	
	public java.util.Date getFecha_hora_desde() {
		return fecha_hora_desde;
	}
	
	public java.util.Date getFecha_hora_hasta() {
		return fecha_hora_hasta;
	}

	public void setFecha_hora_hasta(java.util.Date fecha_hora_hasta) {
		this.fecha_hora_hasta = fecha_hora_hasta;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public void setFecha_hora_desde(java.util.Date fecha_hora_desde) {
		this.fecha_hora_desde = fecha_hora_desde;
	}
	
	public String getDescripcion() {
		return descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Elemento getElemento() {
		return elemento;
	}
	
	public void setElemento(Elemento elemento) {
		this.elemento = elemento;
	}

	public Reserva() {
	}
	
	public Reserva(java.util.Date fecha_hora_desde, java.util.Date fecha_hora_hasta, String descripcion, String estado) {
		this.fecha_hora_desde = fecha_hora_desde;
		this.fecha_hora_hasta = fecha_hora_hasta;
		this.descripcion = descripcion;
		this.estado = estado;
	}

	@Override
	public boolean equals(Object r){
		return (r instanceof Reserva) &&
				(((Reserva)r).getId_reserva() == this.getId_reserva());
	}
	
	/*@Override
	public String toString(){
		return Integer.toString(this.getId_reserva()+" - "+this.getPersona().getNombre()+" - "+this.getElemento().getTipoElemento().getNombre()+" - "+this.getElemento().getNombre()+" - "+
				this.getFecha_hora_desde()+" - "+ this.getFecha_hora_hasta() ;
	}*/
	
}
