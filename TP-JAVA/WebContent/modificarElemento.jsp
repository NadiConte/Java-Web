<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.2/css/bootstrap.min.css" integrity="sha384-PsH8R72JQ3SOdhVi3uxftmaW6Vc51MKb0q5P2rRUpPvrszuE4W1povHYgTpBfshb" crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Modificar Elemento</title>
</head>
<body>
<form method="post" action="Elementos">

	
	
	<div class="form-group">
		<label>ID</label>
		<input type="text" name="id_ele" readonly="readonly" value=<c:out value="${elemento.id_elemento}" />>
	</div>
	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre" value=<c:out value="${elemento.nombre}"/>>
	</div>
		
 	<div class="form-group">
		<label>Tipo Elemento</label>
		 
		<select name="id_tipo">
		<c:forEach items="${tiposEle}" var="t">
        <option value="${t.id_tipo}" ${t.id_tipo == miTipo.id_tipo ? 'selected="selected"' : ''}>${t.nombre}</option>
    </c:forEach>
    </select>


	</div>	
		
		
	

	<button type="input" name="modificar">Aceptar</button>
</form>

<a href="/TPJAVA/elementos"><button>Volver</button></a>

</body>
</html>