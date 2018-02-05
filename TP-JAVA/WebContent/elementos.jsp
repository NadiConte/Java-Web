<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Elementos</title>
<link href="style/bootstrap.css" rel="stylesheet">
</head>
<body>
	<class="container">
	<form id="formelementos" name="Elementos"
			action="Elementos" method="post">
		<table class = "table table-striped">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Tipo Elemento</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allElements}" var="ele">		
			<tr>
				<td align="left"><input type="text"
				name="<c:out value="${ele.id_elemento}"/>"
				value="<c:out value="${ele.id_elemento}"/>" disabled /></td>
								<td align="left"><input type="text"
				name="<c:out value="${ele.nombre}"/>"
				value="<c:out value="${ele.nombre}"/>" disabled /></td>
								<td align="left"><input type="text"
				name="<c:out value="${ele.tipoElemento.nombre}"/>"
				value="<c:out value="${ele.tipoElemento.nombre}"/>" disabled /></td>
				<td>
					<form method="post" action="Elementos">

						<button type="input" value=<c:out value = "${ele.nombre}"/> name="mapear">Modificar</button>
						<button type="input" value=<c:out value = "${ele.nombre}"/> name="borrar">Borrar</button>
					</form>
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<a href="crearElemento.jsp"><button>Nuevo Elemento</button></a>
	<a href="menuAdministrador.jsp"><button>Volver</button></a>
	
</form>
</body>
</html>