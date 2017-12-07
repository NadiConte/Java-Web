<%@page import="controlers.CtrlABMElemento"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.Reserva" %>
<%@ page import="entity.Elemento" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Reserva</title>
</head>
<body>
<form method="post" action="Reserva">


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
	
	
	
	<div class="form-group">
		<label>Elemento</label>
		<input type="text" name="elemento">
	</div>
	

	<button type="input" name="crear">Aceptar</button>
</form>

<a href="reservas.jsp"><button>Volver</button></a>
</body>
</html>