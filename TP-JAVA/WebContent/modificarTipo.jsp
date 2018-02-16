<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Tipo Elemento</title>
</head>
<body>
Modificar


<form method="post" action="TipoElemento">

	<div class="form-group">
		<label>ID</label>
		<input type="text" name="id_tipo" readonly="readonly" value=<c:out value="${tipo.id_tipo}" />>
	</div>
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre" value=<c:out value="${tipo.nombre}"/>>
	</div>
	<div class="form-group">
		<label>Cantidad Maxima</label>
		<input type="text"  name="cantMax" value=<c:out value="${tipo.cantMaxima}"/>>
	</div>
	<div class="form-group">
		<label>Dias Anticipacion</label>
		<input type="text"  name="diasAnt" value=<c:out value="${tipo.diasAnticipacion}"/>>
	</div>
	<div class="form-group">
		<label>Tiempo Maximo</label>
		<input type="text" name="tiempoMax" value=<c:out value="${tipo.tiempoMax}"/>>
	</div>
	<div class="form-group">
		<label>Solo Encargado</label>
		<input type="checkbox" name="<c:out value="${tipo.soloEncargado}"/>" 
				id="soloEncargado" value="<c:out value="${tipo.soloEncargado}"/>" ${tipo.soloEncargado== 'true' ? 'checked' : ''}>
	</div>   

	<button type="input" name="modificar">Aceptar</button>
</form>

<a href="tipoElementos"><button>Volver</button></a>

</body>
</html>