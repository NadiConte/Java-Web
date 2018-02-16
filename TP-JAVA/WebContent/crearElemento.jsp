<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Elemento</title>
</head>
<body>
	
	<form method="post" action="Elemento">
	
	
	<div class="form-group">
		<label>Nombre</label>
		<input type="text" name="nombre">
	</div>

	<div class="form-group">
		<label>Tipo de Elemento</label>


		<select name="id_tipo" id="tipo"style="width: 154px; height: 29px">
		<c:forEach items="${tipos}" var="t">
        <option value="${t.id_tipo}">${t.nombre}</option>
    
    </c:forEach>
    </select>
		
		</div>	
	
	
		<button type="input" name="crear">Aceptar</button>
</form>
	<a href="elementos.jsp"><button>Volver</button></a>

</body>
</html>