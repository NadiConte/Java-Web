<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="controlers.CtrlABMElemento"%>
<%@ page import="entity.Reserva" %>
<%@ page import="entity.Elemento" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Persona" %>
<%@ page import="controlers.CtrlABMPersona" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Reserva</title>
</head>
<body>

<%

CtrlABMPersona ctrlPer = new CtrlABMPersona();
Persona per=(Persona)session.getAttribute("user");

out.print(per.getNombre());
%>

<form method="post" action="Reserva">

	<input name="personaLogueada" value=<%= per.getId_persona() %> hidden>
	<div class="form-group">
		<label>Fecha y Hora</label>
		<input type="text" name="fecha_hora">
	</div>
	
	<div class="form-group">
		<label>Descripcion</label>
		<input type="text" name="descripcion">
	</div>
	
		<div class="form-group">
		<label>Elementos</label>

	<%CtrlABMElemento ctele= new CtrlABMElemento();
		ArrayList<Elemento> elementos=new ArrayList<Elemento>();
		elementos = ctele.getAll(); %>
		<select name="id_tipo" id="tipo"style="width: 154px; height: 29px">
		
		<%for(Elemento e : elementos){%>
		<option value="<%=e.getId_elemento()%>"><%=e.getNombre()%></option><%} %>
	
		
		</select>	
	</div>	
	
	

	<button type="input" name="crear">Aceptar</button>
</form>

<a href="reservas.jsp"><button>Volver</button></a>
</body>
</html>