<!-- <%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%> -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.TipoElemento" %>
<%@ page import="controlers.CtrlABMTipo" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		ArrayList<TipoElemento> ale = new ArrayList<TipoElemento>();
		CtrlABMTipo ct = new CtrlABMTipo();
		
		ale = ct.getAll();
	%>
	<a href="crearTipo.jsp"><button>Nuevo tipo</button></a>
	<div> 
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Dias anticipacion</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<% for (TipoElemento t : ale){
				
			%>
			<tr>
				<td><%= t.getId_tipo()%></td>
				<td><%= t.getNombre()%></td>
				<td><%= t.getDiasAnticipacion() %></td>
				<td>
					<form method="post" action="TipoElemento">
						<button type="input" value=<%= t.getId_tipo() %> name="mapear">Modificar</button>
						<button type="input" value=<%= t.getId_tipo() %> name="borrar">Borrar</button>
					</form>
				</td>
			</tr>
			<% } %>
			</tbody>
		</table>
	</div>
	
</body>
</html>