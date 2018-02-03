package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMElemento;
import controlers.CtrlABMTipo;
import entity.*;



/**
 * Servlet implementation class TipoElemento
 */
@WebServlet("/TipoElemento")
public class TipoElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TipoElemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
				}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("mapear")!= null) {
			int idTipo = Integer.parseInt(request.getParameter("mapear"));
			
			
			entity.TipoElemento te = new entity.TipoElemento();
			CtrlABMTipo cte = new CtrlABMTipo();
			
			te = cte.getByID(idTipo);
			
			request.setAttribute("tipoElemento", te);
			
			request.getRequestDispatcher("/WEB-INF/modificarTipo.jsp").forward(request, response);
			
		}
		
		if (request.getParameter("modificar")!= null) {
			
			entity.TipoElemento te = new entity.TipoElemento();
			CtrlABMTipo cte = new CtrlABMTipo();
			
			te.setId_tipo(Integer.parseInt(request.getParameter("id")));
			te.setNombre(request.getParameter("nombre"));
			te.setCantMaxima(Integer.parseInt(request.getParameter("cantMax")));
			te.setDiasAnticipacion(Integer.parseInt(request.getParameter("diasAnt")));
			te.setTiempoMax(Integer.parseInt(request.getParameter("tiempoMax")));
			
			cte.update(te);
			
			request.getRequestDispatcher("/WEB-INF/tipoElementos.jsp").forward(request, response);
		}
		
		if (request.getParameter("crear")!= null) {
			
			entity.TipoElemento te = new entity.TipoElemento();
			CtrlABMTipo cte = new CtrlABMTipo();
			
			te.setNombre(request.getParameter("nombre"));
			te.setCantMaxima(Integer.parseInt(request.getParameter("cantMax")));
			te.setDiasAnticipacion(Integer.parseInt(request.getParameter("diasAnt")));
			te.setTiempoMax(Integer.parseInt(request.getParameter("tiempoMax")));
			
			cte.add(te);
			
			request.getRequestDispatcher("/WEB-INF/tipoElementos.jsp").forward(request, response);
		}
		
		if (request.getParameter("borrar")!= null) {
			
			entity.TipoElemento te = new entity.TipoElemento();
			CtrlABMTipo cte = new CtrlABMTipo();
			
			int idTipo = Integer.parseInt(request.getParameter("borrar"));
			
			te = cte.getByID(idTipo);
			
			cte.delete(te);
			
			request.getRequestDispatcher("/WEB-INF/tipoElementos.jsp").forward(request, response);
		}
	}

}
