<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entity.TipoElemento" %>
<%@ page import="controlers.CtrlABMTipo" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
Modifica

<%
	TipoElemento te = (TipoElemento)request.getAttribute("tipoElemento");
%>
<form method="post" action="TipoElemento">

	<div class="form-group">
		<label>ID</label>
		<input type="text" name="id" value=<%= te.getId_tipo() %> readonly>
	</div>
	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre" value=<%= te.getNombre()%>>
	</div>
	
	<div class="form-group">
		<label>Cantidad maxima</label>
		<input type="text" name="cantMax" value=<%= te.getCantMaxima() %>>
	</div>
	
	<div class="form-group">
		<label>Dias anticipacion</label>
		<input type="text" name="diasAnt" value=<%= te.getDiasAnticipacion()%>>
	</div>
	
	<div class="form-group">
		<label>Tiempo maximos</label>
		<input type="text" name="tiempoMax" value=<%= te.getTiempoMax()%>>
	</div>


	<button type="input" name="modificar">Aceptar</button>
</form>

<a href="tipoElementos.jsp"><button>Volver</button></a>

</body>
</html>