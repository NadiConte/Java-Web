<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu de Elementos</title>
    <link href="style/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
			<form class="form-horizontal" id="formelementos" name="Elementos" action="Elementos" method="post">
			<fieldset>
                 <legend class="text-center header">Elementos</legend>
			<table class="table table-striped table-advance table-hover">
			<thead>
				<tr>
					<th>ID</th>
					<th>Nombre</th>
					<th>Tipo Elemento</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${allElements}" var="ele">		
			<tr>
				<td align="left"><input type="text"
				name="<c:out value="${ele.id_elemento}"/>"
				value="<c:out value="${ele.id_elemento}"/>" disabled /></td>
								<td align="left"><input type="text"
				name="<c:out value="${ele.nombre}"/>"
				value="<c:out value="${ele.nombre}"/>" disabled /></td>
								<td align="left"><input type="text"
				name="<c:out value="${ele.tipoElemento.nombre}"/>"
				value="<c:out value="${ele.tipoElemento.nombre}"/>" disabled /></td>
				<td>
	
						<button class="btn btn-primary" type="input" value=<c:out value = "${ele.nombre}"/> name="mapear">Modificar</button>
						<button class="btn btn-primary" type="input" value=<c:out value = "${ele.nombre}"/> name="borrar">Borrar</button>
				
				</td>
			</tr>
			</c:forEach>
			</tbody>
		</table>
		<div class="centrar-cont">
									<button type="input" name="mapearCrearEle" class="btn btn-primary" >Nuevo Elemento</button>
		                          		<input type="button" name="btnCancelar" value="Cancelar" class="btn btn-primary" onClick="location.href='menuAdministrador.jsp'">	
		                          	</div>
	
		</fieldset>
		</form>
		</div>
      </div>
    </div>
</div>
	

</body>
</html>