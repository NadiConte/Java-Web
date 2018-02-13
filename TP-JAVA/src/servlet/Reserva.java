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
		request.getRequestDispatcher("/reservas.jsp").forward(request, response);
		
	
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
				
			request.getRequestDispatcher("/crearReserva.jsp").forward(request, response);
				
			}
		
			if(request.getParameter("cargarElementos")!=null) {
			
				CtrlABMPersona cp = new CtrlABMPersona();			
				entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
				
				
				int idTipo = (Integer.parseInt(request.getParameter("id_tipo")));
				controlers.CtrlABMTipo cte = new controlers.CtrlABMTipo();
				TipoElemento te = cte.getByID(idTipo);
			
				if (per.esEncargado() || per.esAdministrador() || te.getSoloEncargado() == false) {	
				
				CtrlABMElemento ctele= new CtrlABMElemento();
				ArrayList<Elemento> elementos= ctele.getByTipo(idTipo);
				
				request.setAttribute("allElements", elementos);
				request.getRequestDispatcher("/confirmarReserva.jsp").forward(request, response);}
				else {
					request.getRequestDispatcher("/errorSoloEncargado.jsp").forward(request, response);
				}}
			
			
			if (request.getParameter("crear")!= null) {
			
			CtrlABMPersona cp = new CtrlABMPersona();			
			entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");		
			CtrlABMElemento ctele = new CtrlABMElemento();
			Elemento ele = ctele.getByID(Integer.parseInt(request.getParameter("id_ele")));				
			entity.Reserva r = new entity.Reserva();
			CtrlABMReserva cte = new CtrlABMReserva();
			r.setDescripcion(request.getParameter("descripcion"));
			
			SimpleDateFormat f= new SimpleDateFormat("dd/MM/yyyy HH:mm");
			java.util.Date fechaHoraDesde = null, fechaHoraHasta = null;
			String fechaDesde = request.getParameter("fecha_hora");		
			String fechaHasta = request.getParameter("fecha_hora_hasta");		
			
			try {
						fechaHoraDesde = f.parse(fechaDesde);
						fechaHoraHasta = f.parse(fechaHasta);
								
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				r.setFecha_hora_desde(fechaHoraDesde);
				r.setFecha_hora_hasta(fechaHoraHasta);
				r.setElemento(ele);
				r.setPersona(per);
				
				String mail=r.getPersona().getEmail();

				//Falta setear la fecha que viene de request.getParameter("fecha_hora")) <--- convertir ese String en Date;
				// e.setFecha_hora(fecha_hora);
				
				try {
					cte.add(r);
					Emailer.getInstance().send(mail,"Reserva Creada",cte.datosRes(r));
				} catch (Exception e2) {
					System.out.println("Aca tira error");
				}
				this.doGet(request, response);
				}
				
				
			
			
		
	if (request.getParameter("borrar")!= null) {
		
		entity.Reserva r = new entity.Reserva();
		CtrlABMReserva ctp = new CtrlABMReserva();
		
		r.setId_reserva(Integer.parseInt(request.getParameter("borrar")));
		
		System.out.println(r.getId_reserva());
		ctp.delete(r);
		//System.out.println(id);
		//e = cte.getByID(id);
		//System.out.println(e.getId_elemento());
		
		
		this.doGet(request, response);
		}
	
	if (request.getParameter("volverMenu")!= null) {
		
		entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
		
		if (per.esAdministrador()) {
			request.getRequestDispatcher("/menuAdministrador.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
		}
		
		
	}
	
	if (request.getParameter("volverMenu")!=null) {
		
		CtrlABMPersona cp = new CtrlABMPersona();			
		entity.Persona per = (Persona) request.getSession().getAttribute("personaLogueada");
		if (per.esAdministrador()) {
			request.getRequestDispatcher("/menuAdministrador.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
		}
		
		
		
	}
}


}

