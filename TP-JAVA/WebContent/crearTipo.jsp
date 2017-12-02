<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="TipoElemento">

	<div class="form-group">
		<label>ID</label>
		<input type="text" name="id" readonly>
	</div>
	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre">
	</div>
	
	<div class="form-group">
		<label>Cantidad maxima</label>
		<input type="text" name="cantMax">
	</div>
	
	<div class="form-group">
		<label>Dias anticipacion</label>
		<input type="text" name="diasAnt">
	</div>
	
	<div class="form-group">
		<label>Tiempo maximos</label>
		<input type="text" name="tiempoMax">
	</div>


	<button type="input" name="crear">Aceptar</button>
</form>

<a href="tipoElementos.jsp"><button>Volver</button></a>
</body>
</html>