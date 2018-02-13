<!-- <%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Tipos de Elementos</title>
</head>
<body>

	<form id="formtipos" name="TipoElemento"
			action="TipoElemento" method="post">

	<div> 
		<table class = "table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Dias anticipacion</th>
					<th>Cantidad Maxima</th>
					<th>Tiempo Maximo</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
		<c:forEach items="${todosTipoEle}" var="t">
			<tr>
				<td><input type="text"
				name="<c:out value="${t.nombre}"/>"
				value="<c:out value="${t.nombre}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${t.diasAnticipacion}"/>"
				value="<c:out value="${t.diasAnticipacion}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${t.cantMaxima}"/>"
				value="<c:out value="${t.cantMaxima}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${t.tiempoMax}"/>"
				value="<c:out value="${t.tiempoMax}"/>" disabled /></td>	
				<td><input type="checkbox" disabled name="<c:out value="${t.soloEncargado}"/>" 
				id="habilitado" value="<c:out value="${t.soloEncargado}"/>" ${t.soloEncargado== 'true' ? 'checked' : ''}>
				</td>			
				<td>
					<button type="input" value=<c:out value="${t.id_tipo}"/> name="mapearEdit">Modificar</button>
					<button type="input" value=<c:out value="${t.id_tipo}"/> name="borrar">Borrar</button>
				</td>
			</tr>
		 </c:forEach>
			</tbody>
		</table>
	</div>
	<button type="input" name="mapearCrear">Nuevo Tipo</button>
	</form>
	<a href="menuAdministrador.jsp"><button>Volver</button></a>
	
</body>
</html>