<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


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
<form method="post" action="Persona">
	
	<div class="form-group">
		<label>ID</label>
		<input type="text" name="id_persona" readonly="readonly" value=<c:out value="${persona.id_persona}" />>
	</div>
	
	
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
		<input type="checkbox" name="<c:out value="${persona.habilitado}"/>" 
				id="habilitado" value="<c:out value="${persona.habilitado}"/>" ${persona.habilitado == 'true' ? 'checked' : ''}>
	</div>

 	<div class="form-group">
		<label>Categoria</label>
		 
		<select name="id_categoria">
		<c:forEach items="${categorias}" var="categoria">
        <option value="${categoria.id_categoria}" ${categoria.id_categoria == selectedCat.id_categoria ? 'selected="selected"' : ''}>${categoria.descripcion}</option>
    
    </c:forEach>
    </select>


	</div>	

<button type="input" name="modificar">Aceptar</button>
</form>

<a href="/TPJAVA/personas"><button>Volver</button></a>
</body>
</html>