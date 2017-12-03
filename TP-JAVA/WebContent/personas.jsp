<!--<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Persona" %>
<%@ page import="controlers.CtrlABMPersona" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Categoria" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu Personas</title>
</head>
<body>
<% 
		ArrayList<Persona> alp = new ArrayList<Persona>();
		CtrlABMPersona ctp = new CtrlABMPersona();
		
		alp =ctp.getAll();

	%>
	<div> 
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Usuario</th>
					<th>Categoria</th>					
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<% for (Persona p : alp){
				
			%>
			<tr>
				<td><%= p.getId_persona()%></td>
				<td><%= p.getNombre()%></td>
				<td><%= p.getApellido() %></td>
				<td><%= p.getDni() %></td>
				<td><%= p.getUsuario() %></td>				
				<td><%= p.getCategoria().getDescripcion() %></td>
				<td>
					<form method="post" action="Persona">
						<button type="input" value=<%= p.getId_persona() %> name="mapear">Modificar</button>
						<button type="input" value=<%= p.getId_persona() %> name="borrar">Borrar</button>
					</form>
				</td>
			</tr>
			<% } %>
			</tbody>
		</table>
	</div>
	<a href="crearPersona.jsp"><button>Nuevo Persona</button></a>
	<a href="menuPrincipal.jsp"><button>Volver</button></a>
	
	
</body>
</html>