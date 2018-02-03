<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="entity.Elemento" %>
<%@ page import="controlers.CtrlABMElemento" %>

<%@ page import="entity.TipoElemento" %>
<%@ page import="controlers.CtrlABMTipo" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Elemento</title>
</head>
<body>
Modifica

<%

	Elemento e = (Elemento)request.getAttribute("elemento");

%>
<form method="post" action="Elemento">

	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre" value=<%= e.getNombre()%>>
	</div>

	<div class="form-group">
		<label>ID_Tipo</label>

	<%CtrlABMTipo ctt= new CtrlABMTipo();
		ArrayList<TipoElemento> tipos=new ArrayList<TipoElemento>();
		tipos=ctt.getAll(); %>
		<select name="id_tipo" id="tipo"style="width: 154px; height: 29px">
		
		<%for(TipoElemento t : tipos){%>
		<option value="<%=t.getId_tipo()%>"><%=t.getNombre()%></option><%} %>
	
		
		</select>	
	</div>	
	

	<button type="input" name="modificar">Aceptar</button>
</form>

<a href="/WEB-INF/elementos.jsp"><button>Volver</button></a>

</body>
</html>