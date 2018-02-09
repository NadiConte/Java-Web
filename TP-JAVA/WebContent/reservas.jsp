<!-- <%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/scripts/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Reservas</title>
</head>
<body>
 
	<form id="formreservas" name="Reserva"
			action="Reserva" method="post">
		<table>
			<thead>
				<tr>
					<th>Fecha y Hora Desde</th>
					<th>Fecha y Hora Hasta</th>
					<th>Descripcion</th>
					<th>Elemento</th>
					<th>Estado</th>
			   </tr>
			    </tr>
			</thead>
			<tbody>
				<c:forEach items="${todasReservas}" var="res">
			<tr>
				<td><input type="text"
				name="<c:out value="${res.fecha_hora_desde}"/>"
				value="<c:out value="${res.fecha_hora_desde}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${res.fecha_hora_hasta}"/>"
				value="<c:out value="${res.fecha_hora_hasta}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${res.descripcion}"/>"
				value="<c:out value="${res.descripcion}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${res.elemento.nombre}"/>"
				value="<c:out value="${res.elemento.nombre}"/>" disabled /></td>
					
				<td>
						<button type="submit" value=<c:out value = "${res.id_reserva}"/> name="borrar">cancelar</button>
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>

	<button type="input" name="mapearNuevaReserva">Nueva Reserva</button>
			</form>
		<button type="button"  name="volverMenu">Volver</button>
	

</body>
</html>