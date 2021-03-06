package servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import controlers.CtrlABMElemento;
import controlers.CtrlABMPersona;
import entity.Categoria;
import entity.Elemento;
import entity.Persona;
import entity.TipoElemento;
import util.Emailer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMReserva;
import controlers.CtrlABMTipo;
import entity.Categoria;

/**
 * Servlet implementation class Reserva
 */
@WebServlet({"/Reserva", "/reservas"})
public class Reserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reserva() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		ArrayList<entity.Reserva> res;
		CtrlABMReserva ctrl = new CtrlABMReserva();
		CtrlABMPersona cp = new CtrlABMPersona();			
		entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
		if (!per.esAdministrador()){
			res = ctrl.reservasDePer(per);	
		}else {
			res = ctrl.getAll();
		}
		request.setAttribute("todasReservas", res);
		request.getRequestDispatcher("reservas.jsp").forward(request, response);
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
			if (request.getParameter("mapearNuevaReserva")!= null) {
				
				CtrlABMTipo ctTipo= new CtrlABMTipo();
				ArrayList<TipoElemento>  ctele =new ArrayList<TipoElemento>();
				try {
					ctele = ctTipo.getAll();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				request.setAttribute("allTipos", ctele);
				
			request.getRequestDispatcher("crearReserva.jsp").forward(request, response);
				
			}
		
			if(request.getParameter("cargarElementos")!=null) {
			
				CtrlABMPersona cp = new CtrlABMPersona();			
				entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
				
				
				int idTipo = (Integer.parseInt(request.getParameter("id_tipo")));
				controlers.CtrlABMTipo cte = new controlers.CtrlABMTipo();
				TipoElemento te = cte.getByID(idTipo);
			
				if (per.esEncargado() || per.esAdministrador() || te.getSoloEncargado() == false) {	
				
				CtrlABMElemento ctele= new CtrlABMElemento();
				ArrayList<Elemento> elementos= (ArrayList<Elemento>) ctele.loadElementos(te);
				
				request.setAttribute("allElements", elementos);
				request.getRequestDispatcher("confirmarReserva.jsp").forward(request, response);}
				else {
					request.getRequestDispatcher("errorSoloEncargado.jsp").forward(request, response);
				}}
			
			
			if (request.getParameter("crear")!= null) {
			
			entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");		
			CtrlABMElemento ctele = new CtrlABMElemento();
			Elemento ele = ctele.getByID(Integer.parseInt(request.getParameter("id_ele")));				
			entity.Reserva r = new entity.Reserva();
			CtrlABMReserva cte = new CtrlABMReserva();
			r.setDescripcion(request.getParameter("descripcion"));
			
			CtrlABMTipo ct=new CtrlABMTipo();
			
			
			SimpleDateFormat f= new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");//YYYY-MM-DD HH-MM-SS
			java.util.Date fechaHoraDesde=null;
			java.util.Date fechaHoraHasta=null;
			String fechaDesde = request.getParameter("fecha_hora");		
			String fechaHasta = request.getParameter("fecha_hora_hasta");		
		
			try {
				fechaHoraDesde = f.parse(fechaDesde);
				fechaHoraHasta = f.parse(fechaHasta);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				}
			
			//2018/03/03 10:00:00	
				entity.TipoElemento t=ct.getByID(ele.getTipoElemento().getId_tipo());
				
				int cantRes= cte.cantReservasXTipo(per, t);
			
				if (cantRes<t.getCantMaxima()) {//no supera la cantidad maxima
					
						int cantDias=0;			
						cantDias = t.getDiasAnticipacion();			
						Date hoy = new Date();
						System.out.println(fechaHoraDesde);
						//Los tipos de elementos pueden tener una cantidad m�xima de d�as de anticipaci�n para ser reservados.
						
						if(((fechaHoraDesde.getTime()-hoy.getTime())/86400000) < cantDias){//diferencia de dias desde hoy hasta la fecha de reserva inferior a la esperada
							request.getRequestDispatcher("errorResDiasAnt.jsp").forward(request, response);
				
						}else {
							
							int tiempoMax=t.getTiempoMax();
							
							if(tiempoMax < ((fechaHoraHasta.getTime()-fechaHoraDesde.getTime())/3600000)){//supera la cantidad de tiempo maxima de reserva
								
								request.getRequestDispatcher("errorResTiempoMax.jsp").forward(request, response);
								}else {
							
								r.setFecha_hora_desde(fechaHoraDesde);
								r.setFecha_hora_hasta(fechaHoraHasta);
								r.setElemento(ele); 
								r.setPersona(per);
								String mail=r.getPersona().getEmail();

								if (cte.estaDisponible(r, t)){
									//esta disponible ese elemento para las horas seleccionadas
									
									try {
										System.out.println("reserva creada");
										cte.add(r);
										//Emailer.getInstance().send(mail,"Reserva Creada",cte.datosRes(r));
										request.getRequestDispatcher("exitoRes.jsp").forward(request, response);
									} catch (Exception e2) {
										System.out.println("Aca tira error");
									}
								}else {request.getRequestDispatcher("errorResObjetoReservado.jsp").forward(request, response);}
						}
					}
						
				}		else {request.getRequestDispatcher("errorResCantMax.jsp").forward(request, response);}	
			
				this.doGet(request, response);
		}
				
				
			
			
		
	if (request.getParameter("borrar")!= null) {
		
		entity.Reserva r = new entity.Reserva();
		CtrlABMReserva ctr = new CtrlABMReserva();
		Persona p=new Persona();
		CtrlABMPersona ctp=new CtrlABMPersona();
		
		int id = Integer.parseInt(request.getParameter("borrar"));
		r = ctr.getByID(id);
		p=ctp.getById(r.getPersona().getId_persona());
		String mail=p.getEmail();
		
		try {
			ctr.delete(r);
			//Emailer.getInstance().send(mail,"Reserva Cancelada",ctr.datosRes(r));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		this.doGet(request, response);
		}
	
	if (request.getParameter("volverMenu")!= null) {
		
		entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
		
		if (per.esAdministrador()) {
			request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
		}
		
		
	}
	
	if (request.getParameter("volverMenu")!=null) {
		
		CtrlABMPersona cp = new CtrlABMPersona();			
		entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
		if (per.esAdministrador()) {
			request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
		}
		
		
		
	}
	
}


}

