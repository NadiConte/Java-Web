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
    <link href="style/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
		<form class="form-horizontal" method="post" action="Persona">
			 <fieldset>
                 <legend class="text-center header">Modificar Persona</legend>
                 					<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">ID</label>
		                              	<div class="col-sm-10">
		                              		<input type="text" name="id_persona" readonly="readonly" class="form-control" value=<c:out value="${persona.id_persona}" />>
		                              	</div>
		                          	</div>
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Nombre</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="nombre" class="form-control"  value=<c:out value="${persona.nombre}"/>>
		                              	</div>
		                          	</div>
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Apellido</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="apellido" class="form-control"  value=<c:out value="${persona.apellido}"/>>
		                              	</div>
		                          	</div>
			                     	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">DNI</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="dni" class="form-control"  value=<c:out value="${persona.dni}"/>>
		                              	</div>
		                          	</div>		
		                          	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Habilitado</label>
		                              	<div class="col-sm-10">
		                                  	<input type="checkbox" class="form-control"  name="<c:out value="${persona.habilitado}"/>" 
											id="habilitado" value="<c:out value="${persona.habilitado}"/>" ${persona.habilitado == 'true' ? 'checked' : ''}>
		                              	</div>
		                          	</div>         
		                          	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Usuario</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text"  name="usuario" class="form-control"  value=<c:out value="${persona.usuario}"/>>
		                              	</div>
		                          	</div>   
		                          	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Contrase�a</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text"  name="contrase�a" class="form-control"  value=<c:out value="${persona.contrase�a}"/>>
		                              	</div>
		                          	</div>          
		                          	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Email</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text"  name="email" class="form-control"  value=<c:out value="${persona.email}"/>>
		                              	</div>
		                          	</div>       
									<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Categoria</label>
		                              	<div class="col-sm-10">
		                                  	<select name="id_categoria" id="tipo" class="form-control">
												<c:forEach items="${categorias}" var="categoria">
       											 <option value="${categoria.id_categoria}" ${categoria.id_categoria == selectedCat.id_categoria ? 'selected="selected"' : ''}>${categoria.descripcion}</option>
    
									   			 </c:forEach>
											</select>
		                              	</div>
		                          	</div>
		                          	<div class="centrar-cont">
									<button type="input" name="modificar" class="btn btn-primary" >Aceptar</button>
		                          		<input type="button" name="btnCancelar" value="Cancelar" class="btn btn-primary" onClick="location.href='personas.jsp'">	
		                          	</div></fieldset>
		</form>
		</div>
      </div>
    </div>
  </div>
</body>
</html>