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
@WebServlet({"/TipoElemento", "/tipoElementos"})
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
		
		ArrayList<entity.TipoElemento> ale = new ArrayList<>();
		CtrlABMTipo ct = new CtrlABMTipo();
		
		try {
			ale = ct.getAll();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("todosTipoEle", ale);
		request.getRequestDispatcher("/tipoElementos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("mapearEdit") != null ||request.getParameter("mapearCrear") != null) {

			CtrlABMTipo cte = new CtrlABMTipo();
		
			if (request.getParameter("mapearEdit") != null) {
				int id_tipo = Integer.parseInt(request.getParameter("mapearEdit"));
				entity.TipoElemento te = new entity.TipoElemento();
				te = cte.getByID(id_tipo);				
				request.setAttribute("tipo", te);

				request.getRequestDispatcher("modificarTipo.jsp").forward(request, response);
			}
			
			if (request.getParameter("mapearCrear") != null){
				request.getRequestDispatcher("crearTipo.jsp").forward(request, response);

			}
			
		}
			
		
		if (request.getParameter("modificar")!= null) {
			
			entity.TipoElemento te = new entity.TipoElemento();
			CtrlABMTipo cte = new CtrlABMTipo();
			
			int idTipo = Integer.parseInt(request.getParameter("id_tipo"));
			te = cte.getByID(idTipo);
			
			te.setNombre(request.getParameter("nombre"));
			te.setCantMaxima(Integer.parseInt(request.getParameter("cantMax")));
			te.setDiasAnticipacion(Integer.parseInt(request.getParameter("diasAnt")));
			te.setTiempoMax(Integer.parseInt(request.getParameter("tiempoMax")));
			te.setSoloEncargado(Boolean.parseBoolean(request.getParameter("soloEncargado")));
			cte.update(te);
			
			this.doGet(request, response);}
		
		if (request.getParameter("crear")!= null) {
			
			entity.TipoElemento te = new entity.TipoElemento();
			CtrlABMTipo cte = new CtrlABMTipo();
			
			te.setNombre(request.getParameter("nombre"));
			te.setCantMaxima(Integer.parseInt(request.getParameter("cantMax")));
			te.setDiasAnticipacion(Integer.parseInt(request.getParameter("diasAnt")));
			te.setTiempoMax(Integer.parseInt(request.getParameter("tiempoMax")));
			te.setSoloEncargado(Boolean.parseBoolean(request.getParameter("soloEncargado")));
			cte.add(te);
			
			this.doGet(request, response);
		}
		
		if (request.getParameter("borrar")!= null) {
			
			entity.TipoElemento te = new entity.TipoElemento();
			CtrlABMTipo cte = new CtrlABMTipo();
			
			int idTipo = Integer.parseInt(request.getParameter("borrar"));
			
			te = cte.getByID(idTipo);
			
			cte.delete(te);
			
			this.doGet(request, response);
			
		}
	}

}
