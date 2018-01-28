package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.scene.layout.region.Margins.Converter;

import controlers.CtrlABMPersona;
import entity.Categoria;

/**
 * Servlet implementation class Persona
 */
@WebServlet("/Persona")
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("mapear") != null) {

			int id = Integer.parseInt(request.getParameter("mapear"));

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			p = ctp.getById(id);

			request.setAttribute("persona", p);

			request.getRequestDispatcher("modificarPersona.jsp").forward(request, response);

		}

		if (request.getParameter("modificar") != null) {

			entity.Persona p = new entity.Persona();
			CtrlABMPersona ctp = new CtrlABMPersona();

			Categoria c = new Categoria();

			// p.setId_persona(Integer.parseInt(request.getParameter("id")));
			p.setNombre(request.getParameter("nombre"));
			p.setApellido(request.getParameter("apellido"));
			p.setDni(request.getParameter("dni"));
			// p.setUsuario(request.getParameter("usuario"));
			// p.setContraseña(request.getParameter("contraseña"));

			p.setHabilitado(Boolean.parseBoolean(request.getParameter("habilitado")));
			int id_cat = Integer.parseInt(request.getParameter("id_categoria"));

			System.out.println(p.isHabilitado());
			System.out.println(p.getNombre());
			p.setContraseña("mario");
			c = ctp.getByID(id_cat);
			p.setCategoria(c);

			System.out.println(p.isHabilitado());
			System.out.println(c.getDescripcion());
			System.out.println(p.getCategoria().getDescripcion());

			p.setId_persona(Integer.parseInt(request.getParameter("id")));
			ctp.update(p);
			System.out.println(p.getCategoria().getDescripcion());

			request.getRequestDispatcher("personas.jsp").forward(request, response);
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
			boolean enabled = request.getParameter("habilitado") != null;

			p.setHabilitado(enabled);
			int id_cat = Integer.parseInt(request.getParameter("id_categoria"));

			c = ctp.getByID(id_cat);
			p.setCategoria(c);

			ctp.add(p);

			request.getRequestDispatcher("personas.jsp").forward(request, response);
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

			request.getRequestDispatcher("personas.jsp").forward(request, response);
		}
	}

}
