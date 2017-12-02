<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="entity.TipoElemento" %>
<%@ page import="controlers.CtrlABMTipo" %>
<%@ page import="java.util.ArrayList" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Elemento</title>
</head>
<body>
	<form method="post" action="Elemento">
	
	<div class="form-group">
		<label>ID</label>
		<input type="text" name="id"readonly>
	</div>
	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre">
	</div>

	<div class="form-group">
		<label>Tipo de Elemento</label>

	<%CtrlABMTipo ctt= new CtrlABMTipo();
		ArrayList<TipoElemento> tipos=new ArrayList<TipoElemento>();
		tipos=ctt.getAll(); %>
		<select name="id_tipo" id="tipo"style="width: 154px; height: 29px">
		
		<%for(TipoElemento t : tipos){%>
		<option value="<%=t.getId_tipo()%>"><%=t.getNombre()%></option><%} %>
	
		
		</select>	
	</div>	
	
	
		<button type="input" name="crear">Aceptar</button>
	</form>
	
	<a href="elementos.jsp"><button>Volver</button></a>

</body>
</html>