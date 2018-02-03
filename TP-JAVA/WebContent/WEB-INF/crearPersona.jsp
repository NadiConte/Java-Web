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
<title>Alta de Persona</title>
</head>
<body>

<%

	Persona p = (Persona)request.getAttribute("persona");

%>
<form method="post" action="Persona">

	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" class="form-control" name="nombre">
	</div>
	
	<div class="form-group">
		<label>Apellido</label>
		<input type="text" class="form-control" name="apellido">
	</div>
	
	<div class="form-group">
		<label>Dni</label>
		<input type="text" class="form-control" name="dni" >
	</div>
	
	<div class="form-group">
		<label>Habilitado</label>
		<input type="checkbox" class="form-control" name="habilitado" >>
	</div>
	
	
	<div class="form-group">
		<label>Usuario</label>
		<input type="text" class="form-control" name="usuario" >
	</div>
	
	<div class="form-group">
		<label>Contraseña</label>
		<input type="password" class="form-control" name="contraseña" >
	</div>
	
	
	
	
	<div class="form-group">
		<label>Categoria</label>

	<%CtrlABMPersona ctp= new CtrlABMPersona();
		ArrayList<Categoria> cats=new ArrayList<Categoria>();
		cats=ctp.getCategorias();%>
		<select name="id_categoria" id="tipo"style="width: 154px; height: 29px">
		
		<%for(Categoria c : cats){%>
		<option value="<%=c.getId_categoria()%>"><%=c.getDescripcion()%></option><%} %>	
		
		</select>	
	</div>	
	

	<button type="input" name="crear">Aceptar</button>
</form>

<a href="/WEB-INF/personas.jsp"><button>Volver</button></a>

</body>
</html>