<!-- <%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%> -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!--<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<head>

   <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">
   <script src="/scripts/jquery.min.js"></script>
   <script src="/bootstrap/js/bootstrap.min.js"></script>
	
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Menu Personas</title>
    <link href="style/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
			<form class="form-horizontal" id="formpersonas" name="Persona" action="Persona" method="post">
			<fieldset>
                 <legend class="text-center header">Personas</legend>

			<table class="table table-striped table-advance table-hover">
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>DNI</th>
					<th>Usuario</th>
					<th>Contraseña</th>
					<th>Mail</th>
					<th>Categoria</th>					
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
		<c:forEach items="${allPeople}" var="p">
			<tr>
				<td><input type="text"
				name="<c:out value="${p.nombre}"/>"
				value="<c:out value="${p.nombre}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${p.apellido}"/>"
				value="<c:out value="${p.apellido}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${p.dni}"/>"
				value="<c:out value="${p.dni}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${p.usuario}"/>"
				value="<c:out value="${p.usuario}"/>" disabled /></td>				
				<td><input type="text"
				name="<c:out value="${p.contraseña}"/>"
				value="<c:out value="${p.contraseña}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${p.email}"/>"
				value="<c:out value="${p.email}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${p.categoria.descripcion}"/>"
				value="<c:out value="${p.categoria.descripcion}"/>" disabled /></td>
				<td><input type="text"
				name="<c:out value="${p.email}"/>"
				value="<c:out value="${p.email}"/>" disabled /></td>
				<td><input type="checkbox" disabled name="<c:out value="${p.habilitado}"/>" 
				id="habilitado" value="<c:out value="${p.habilitado}"/>" ${p.habilitado == 'true' ? 'checked' : ''}>
				</td>
				
				
				
				 <td>
						<button class="btn btn-primary" type="input" value=<c:out value="${p.id_persona}"/> name="mapearEdit">Modificar</button>
						<button class="btn btn-primary" type="input" value=<c:out value="${p.id_persona}"/> name="borrar">Borrar</button>
				</td>
			</tr>
		</c:forEach>
			</tbody>
		</table>
		
		<div class="centrar-cont">
									<button type="input" name="mapearCrear" class="btn btn-primary" >Nuevo Persona</button>
		                          		<input type="button" name="btnCancelar" value="Cancelar" class="btn btn-primary" onClick="location.href='menuAdministrador.jsp'">	
		                          	</div>
	
		</fieldset>
		</form>
		</div>
      </div>
    </div>
</div>

	
</body>
</html>