<!-- <%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%> -->
<%@page import="controlers.CtrlABMTipo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
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
		<label>Fecha - Hora Desde</label>
		<input type="text" name="fecha_hora">
	</div>
	
		<div class="form-group">
		<label>Fecha - Hora Hasta</label>
		<input type="text" name="fecha_hora_hasta">
	</div>
	
	
	
	<div class="form-group">
		<label>Descripcion</label>
		<input type="text" name="descripcion">
	</div>
	
			
		<div class="form-group">
		<label>Elementos Disponibles</label>

	
		<select name="id_ele" id="elemento"style="width: 154px; height: 29px">
		
		<c:forEach items="${allElements}" var="e">
		<option value="${e.id_elemento}">${e.nombre}</option>
		  </c:forEach>
		</select>	
	</div>	
	

		

	<button type="input" name="crear">Guardar Reserva</button>
</form>

<a href="/TPJAVA/crearReserva"><button>Volver</button></a>

</body>
</html>