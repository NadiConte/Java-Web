package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMElemento;
import controlers.CtrlABMTipo;
import entity.TipoElemento;

/**
 * Servlet implementation class Elemento
 */
@WebServlet("/Elemento")
public class Elemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Elemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
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
			
			request.getRequestDispatcher("modificarElemento.jsp").forward(request, response);
			
		}
		
		if (request.getParameter("modificar")!= null) {
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			TipoElemento te = new TipoElemento();
			CtrlABMTipo ctt = new CtrlABMTipo();

			
			e.setId_elemento(Integer.parseInt(request.getParameter("id")));
			e.setNombre(request.getParameter("nombre"));
			int id_tipo=Integer.parseInt(request.getParameter("id_tipo"));
			te=ctt.getByID(id_tipo);
			e.setTipoElemento(te);			
			
			cte.update(e);
			
			request.getRequestDispatcher("elementos.jsp").forward(request, response);
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
			
			request.getRequestDispatcher("elementos.jsp").forward(request, response);
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
			
			request.getRequestDispatcher("elementos.jsp").forward(request, response);
		}
	}

}
