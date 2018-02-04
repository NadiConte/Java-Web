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
import entity.Elemento;
import entity.TipoElemento;

/**
 * Servlet implementation class Elemento
 */
@WebServlet({"/Elemento", "/Elementos", "/elementos"})
public class Elementos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Elementos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
      	CtrlABMElemento cf = new CtrlABMElemento();
		ArrayList<Elemento> ele = cf.getAll();
		request.setAttribute("allElements", ele);
		request.getRequestDispatcher("elementos.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		if (request.getParameter("mapear")!= null) {
			
			String nombre = request.getParameter("mapear");
						
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			e=cte.getByNombre(nombre);
			
			request.setAttribute("elemento", e);
			
			request.getRequestDispatcher("/modificarElemento.jsp").forward(request, response);
			
		}
		
		if (request.getParameter("modificar")!= null) {
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			TipoElemento te = new TipoElemento();
			CtrlABMTipo ctt = new CtrlABMTipo();

			
			//e.setId_elemento(Integer.parseInt(request.getParameter("id"))); los id son PL - no se modifican
			e.setNombre(request.getParameter("nombre"));
			int id_tipo=Integer.parseInt(request.getParameter("id_tipo"));
			te=ctt.getByID(id_tipo);
			e.setTipoElemento(te);			
			
			cte.update(e);
			this.doGet(request, response);
			}
		
		if (request.getParameter("crear")!= null) {
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			TipoElemento te = new TipoElemento();
			CtrlABMTipo ctt = new CtrlABMTipo();
			

			
			e.setNombre(request.getParameter("nombre"));
			//e.set del tipo de elemento NO SE COMO SE PASA 

			int id_tipo=Integer.parseInt(request.getParameter("id_tipo"));
			te=ctt.getByID(id_tipo);
			
			e.setTipoElemento(te);

			
			cte.add(e);
			this.doGet(request, response);
			
			}
		
		if (request.getParameter("borrar")!= null) {
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			String nombre = request.getParameter("borrar");
			//System.out.println(id);
			//e = cte.getByID(id);
			//System.out.println(e.getId_elemento());
			
			e=cte.getByNombre(nombre);
			cte.delete(e);
			this.doGet(request, response);
			}
	}

}
