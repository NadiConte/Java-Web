<!-- <%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%> -->
<%@page import="controlers.CtrlABMPersona"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Reserva" %>
<%@ page import="entity.Persona" %>
<%@page import="controlers.CtrlABMReserva" %>
<%@page import="controlers.CtrlABMPersona" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Reservas</title>
</head>
<body>
	<% 
		ArrayList <Reserva> res = new ArrayList<Reserva>();
		CtrlABMReserva ctrl = new CtrlABMReserva();
		CtrlABMPersona ctrlPer = new CtrlABMPersona();
		Persona per=(Persona)session.getAttribute("user");
		out.print(per.getNombre());
		res = ctrl.reservasDePer(per);
    //funciona perfecto.
	%>
	<div> 
		<table>
			<thead>
				<tr>
					<th>Fecha y Hora</th>
					<th>Descripcion</th>
					<th>Elemento</th>
					<th>Estado</th>
			   </tr>
			    </tr>
			</thead>
			<tbody>
			<% for (Reserva r : res){
				
			%>
			<tr>
				<td><%= r.getFecha_hora()%></td>
				<td><%= r.getDescripcion() %></td>
				<td><%= r.getElemento().getNombre()%></td>
					
				<td>
				
					<form method="post" action="Reserva">
				
						<button type="submit" value=<%= r.getId_reserva() %> name="borrar">cancelar</button>
					</form>
				</td>
			</tr>
			<% } %>
			</tbody>
		</table>
	</div>
	<a href="crearReserva.jsp"><button>Nueva Reserva</button></a>
	<a href="menuPrincipal.jsp"><button>Volver</button></a>
	
</body>
</html>