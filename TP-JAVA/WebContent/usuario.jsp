<!--<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Persona" %>
<%@ page import="controlers.CtrlABMPersona" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Categoria" %>
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
		ArrayList<Persona> alp = new ArrayList<Persona>();
		CtrlABMPersona cp = new CtrlABMPersona();

		alp = cp.getAll();
		out.print(alp);
		
		ArrayList<TipoElemento> ale = new ArrayList<TipoElemento>();
		CtrlABMTipo ct = new CtrlABMTipo();
		
		ale = ct.getAll();
		out.print(ale);

		
		
	%>
	
	
	<div> 
		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
			<% for (Persona p : alp){
				
			%>
			<tr>
				<td><%= p.getId_persona() %></td>
				<td><%= p.getNombre() %></td>
				<td><%= p.getApellido() %></td>
			</tr>
			<% } %>
			</tbody>
		</table>
	</div>
</body>
</html>