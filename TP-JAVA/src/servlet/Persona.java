package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMPersona;
import entity.Categoria;

/**
 * Servlet implementation class Persona
 */
@WebServlet({"/Persona", "/personas", "/Personas"})
public class Persona extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Persona() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		ArrayList<entity.Persona> alp;
		CtrlABMPersona ctp = new CtrlABMPersona();
		
		alp =ctp.getAll();
		
		request.setAttribute("allPeople", alp);
		request.getRequestDispatcher("personas.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("mapearEdit") != null ||request.getParameter("mapearCrear") != null) {
			
			CtrlABMPersona ctp = new CtrlABMPersona();
			ArrayList<Categoria> cats=ctp.getCategorias();
			request.setAttribute("categorias", cats);
			
			if (request.getParameter("mapearEdit") != null) {
				int id = Integer.parseInt(request.getParameter("mapearEdit"));
				entity.Persona p = new entity.Persona();
				p = ctp.getById(id);
				request.setAttribute("persona", p);
				Categoria miCat = new Categoria();
				for (Categoria c: cats) {
					if (p.getCategoria().getId_categoria() == c.getId_categoria()) {
						miCat = c;
					}
				}
				request.setAttribute("selectedCat", miCat);
				request.getRequestDispatcher("modificarPersona.jsp").forward(request, response);
			}
			
			if (request.getParameter("mapearCrear") != null){
				request.getRequestDispatcher("crearPersona.jsp").forward(request, response);

			}
			
		}

		if (request.getParameter("modificar") != null) {
		
			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			p.setId_persona(Integer.parseInt(request.getParameter("id_persona")));
			p.setNombre(request.getParameter("nombre"));
			p.setApellido(request.getParameter("apellido"));
			p.setDni(request.getParameter("dni"));
			p.setUsuario(request.getParameter("usuario"));
			p.setContraseña(request.getParameter("contraseña"));
			p.setEmail(request.getParameter("email"));
			p.setHabilitado(Boolean.parseBoolean(request.getParameter("habilitado")));
			Integer id_cat = Integer.parseInt(request.getParameter("id_categoria"));
			Categoria c = ctp.getByID(id_cat);
			p.setCategoria(c);
			ctp.update(p);

			this.doGet(request, response);
		}

		if (request.getParameter("crear") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			Categoria c = new Categoria();

			p.setNombre(request.getParameter("nombre"));
			p.setApellido(request.getParameter("apellido"));
			p.setDni(request.getParameter("dni"));
			p.setUsuario(request.getParameter("usuario"));
			p.setContraseña(request.getParameter("contraseña"));
			p.setEmail(request.getParameter("email"));
			boolean enabled = request.getParameter("habilitado") != null;
			p.setHabilitado(enabled);
			int id_cat = Integer.parseInt(request.getParameter("id_categoria"));

			c = ctp.getByID(id_cat);
			p.setCategoria(c);

			ctp.add(p);

			this.doGet(request, response);
		}

		if (request.getParameter("borrar") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			int id = Integer.parseInt(request.getParameter("borrar"));
			// System.out.println(id);
			// e = cte.getByID(id);
			// System.out.println(e.getId_elemento());

			p = ctp.getById(id);
			ctp.delete(p);

			this.doGet(request, response);
		}
	}

}
