<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="entity.Persona" %>
<%@ page import="entity.Categoria" %>
<%@ page import="controlers.CtrlABMPersona" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet">
<title>Modificar Persona</title>
</head>
<body>
Modificar
	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre" value=<c:out value="${persona.nombre}"/>>
	</div>
	
	<div class="form-group">
		<label>Apellido</label>
		<input type="text"  name="apellido" value=<c:out value="${persona.apellido}"/>>
	</div>
	
	<div class="form-group">
		<label>Dni</label>
		<input type="text"  name="dni" value=<c:out value="${persona.dni}"/>>
	</div>
	<div class="form-group">
		<label>Usuario</label>
		<input type="text" name="usuario" value=<c:out value="${persona.usuario}"/>>
	</div>
	<div class="form-group">
		<label>Contraseña</label>
		<input type="text" name="contraseña" value=<c:out value="${persona.contraseña}"/>>
	</div>
	<div class="form-group">
		<label>Email</label>
		<input type="text"  name="email" value=<c:out value="${persona.email}"/>>
	</div>
	<div class="form-group">
		<label>Habilitado</label>
		<input type="checkbox" class="form-control" name="habilitado" value=<c:out value="${persona.habilitado}"/>>
	</div>

 	<div class="form-group">
		<label>Categoria</label>

		
		<select name="id_categoria" id="tipo"style="width: 154px; height: 29px">
    <c:forEach items="${categorias}" var="cat">
        <option value="${cat.id_categoria}" ${cat.id_categoria == selectedCat.id_categoria ? 'selected' : ''}>${cat.descripcion}</option>
    </c:forEach>
</select>
		
	</div>	

<%--- tengo que poder llamar  al servlet desde aca --%>
<form action="/TPJAVA/personas" method="post" name="modificar"> 
    <input type="submit" value="Aceptar" />
</form>
<a href="/TPJAVA/personas"><button>Volver</button></a>
</body>
</html>