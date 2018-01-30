package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;
import entity.Persona;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		try {
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			CtrlABMPersona ctrl= new CtrlABMPersona();
			Persona per=ctrl.loguearUsuario(user, pass);
			
			try {
				if(per != null){
					request.setAttribute("listaPersonas", ctrl.getAll());
					request.getSession().setAttribute("user", per);
					
					
					System.out.println();


					if (!per.esAdministrador()) { 
						request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
						}else {
						request.getRequestDispatcher("menuAdministrador.jsp").forward(request, response);	
						}
				
				
				}
			} catch (Exception e) {
				System.out.println("error");
			
				
			
			}
			
			//System.out.println();
			request.getRequestDispatcher("PaginaError.jsp").forward(request, response);

			
			//request.getRequestDispatcher("menuPrincipal.jsp").forward(request, response);
			//response.getWriter().append(user).append(" ").append(pass);
			
			
		} catch (Exception e) {
			//e.printStackTrace();

			
		}
	}

}
