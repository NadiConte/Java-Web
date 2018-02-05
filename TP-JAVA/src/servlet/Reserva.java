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

import com.sun.javafx.scene.layout.region.Margins.Converter;
import com.sun.jmx.snmp.Timestamp;

import controlers.CtrlABMElemento;
import controlers.CtrlABMPersona;
import entity.Categoria;
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
		entity.Persona per = cp.getById(Integer.parseInt(request.getParameter("personaLogueada")));
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
		doGet(request, response);
			if (request.getParameter("crear")!= null) {
			
				CtrlABMPersona cp = new CtrlABMPersona();			
				Persona p = cp.getById(Integer.parseInt(request.getParameter("personaLogueada")));
				
				entity.Elemento elemento = new entity.Elemento();
				controlers.CtrlABMElemento ce = new controlers.CtrlABMElemento();
				elemento = ce.getByID(Integer.parseInt(request.getParameter("id_tipo")));
				
				
				if (p.esEncargado() || elemento.getTipoElemento().getSoloEncargado() == false) {
					entity.Reserva r = new entity.Reserva();
					CtrlABMReserva cte = new CtrlABMReserva();
					SimpleDateFormat f= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					r.setDescripcion(request.getParameter("descripcion"));
					java.util.Date fechaHoraDesde = null;
					String fecha = request.getParameter("fecha_hora");
					
					
					try {
						fechaHoraDesde = f.parse(fecha);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				
				
				
				r.setFecha_hora_desde(fechaHoraDesde);
				r.setElemento(elemento);
				r.setPersona(p);
				System.out.println(r.getFecha_hora_desde());
				System.out.println(r.getPersona().getNombre());
				
				
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
				else {
					request.getRequestDispatcher("/errorSoloEncargado.jsp").forward(request, response);
				}
				
				

			
			
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
		
		
	
		
		request.getRequestDispatcher("/reservas.jsp").forward(request, response);
	}
	
	if (request.getParameter("volverMenu")!= null) {
		CtrlABMPersona cp = new CtrlABMPersona();			
		Persona p = cp.getById(Integer.parseInt(request.getParameter("personaLogueada")));
		
		if (p.esAdministrador()) {
			request.getRequestDispatcher("/menuAdministrador.jsp").forward(request, response);
		}else {
			request.getRequestDispatcher("/menuPrincipal.jsp").forward(request, response);
		}
		
		
	}
}


}

