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

<%

	Persona p = (Persona)request.getAttribute("persona");

%>
<form method="post" action="Persona">

	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre" value=<%= p.getNombre()%>>
	</div>
	
	<div class="form-group">
		<label>Apellido</label>
		<input type="text"  name="apellido" value=<%= p.getApellido() %>>
	</div>
	
	<div class="form-group">
		<label>Dni</label>
		<input type="text"  name="dni" value=<%= p.getDni()%>>
	</div>
	<div class="form-group">
		<label>Usuario</label>
		<input type="text" name="usuario" value=<%= p.getUsuario() %>>
	</div>
	<div class="form-group">
		<label>Contraseña</label>
		<input type="password" name="contraseña" value=<%=p.getContraseña() %>>
	</div>
	<div class="form-group">
		<label>Email</label>
		<input type="text"  name="email" value=<%=p.getEmail()%>>
	</div>
	<div class="form-group">
		<label>Habilitado</label>
		<input type="checkbox" class="form-control" name="habilitado" value=<%= p.isHabilitado()%>>
	</div>

	<div class="form-group">
		<label>Categoria</label>

	<%CtrlABMPersona ctp= new CtrlABMPersona();
		ArrayList<Categoria> cats=new ArrayList<Categoria>();
		cats=ctp.getCategorias();%>
		<select name="id_categoria" id="tipo"style="width: 154px; height: 29px">
		
		<%for(Categoria c : cats){%>
		<option value="<%=c.getId_categoria()%>"<%if (c.getId_categoria()==p.getCategoria().getId_categoria()) { %> selected <% }%>><%=c.getDescripcion()%></option><%} %>	
		
		</select>	
	</div>	
	

	<button type="input" name="modificar">Aceptar</button>
</form>

<a href="/personas.jsp"><button>Volver</button></a>

</body>
</html>