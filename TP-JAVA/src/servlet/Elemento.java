package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMElemento;

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
			int idTipo = Integer.parseInt(request.getParameter("mapear"));
			
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			e = cte.getByID(idTipo);
			
			request.setAttribute("elemento", e);
			
			request.getRequestDispatcher("modificarElemento.jsp").forward(request, response);
			
		}
		
		if (request.getParameter("modificar")!= null) {
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			e.setId_elemento(Integer.parseInt(request.getParameter("id")));
			e.setNombre(request.getParameter("nombre"));

			
			cte.update(e);
			
			request.getRequestDispatcher("elementos.jsp").forward(request, response);
		}
		
		if (request.getParameter("crear")!= null) {
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			e.setNombre(request.getParameter("nombre"));
			//e.set del tipo de elemento NO SE COMO SE PASA 
			
			cte.add(e);
			
			request.getRequestDispatcher("elementos.jsp").forward(request, response);
		}
		
		if (request.getParameter("borrar")!= null) {
			
			entity.Elemento e = new entity.Elemento();
			CtrlABMElemento cte = new CtrlABMElemento();
			
			int idTipo = Integer.parseInt(request.getParameter("borrar"));
			System.out.println(idTipo);
			e = cte.getByID(idTipo);
			System.out.println(e.getId_elemento());
			cte.delete(e);
			
			request.getRequestDispatcher("elementos.jsp").forward(request, response);
		}
	}

}
