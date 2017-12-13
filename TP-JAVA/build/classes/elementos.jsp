<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.TipoElemento" %>
<%@ page import="controlers.CtrlABMTipo" %>
<%@ page import="controlers.CtrlABMElemento" %>
<%@ page import="entity.Elemento" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Elementos</title>
</head>
<body>
<% 
		ArrayList<Elemento> ele = new ArrayList<Elemento>();
      	CtrlABMElemento cf = new CtrlABMElemento();
		
		ele =cf.getAll();

	%>
	<div> 
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Tipo Elemento</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<% for (Elemento e : ele){
				
			%>
			<tr>
				<td><%= e.getId_elemento()%></td>
				<td><%= e.getNombre()%></td>
				<td><%= e.getTipoElemento().getNombre() %></td>
				<td>
					<form method="post" action="Elemento">
						<button type="input" value=<%= e.getNombre() %> name="mapear">Modificar</button>
						<button type="input" value=<%= e.getNombre() %> name="borrar">Borrar</button>
					</form>
				</td>
			</tr>
			<% } %>
			</tbody>
		</table>
	</div>
	<a href="crearElemento.jsp"><button>Nuevo Elemento</button></a>
	<a href="menuPrincipal.jsp"><button>Volver</button></a>
	
	
</body>
</html>