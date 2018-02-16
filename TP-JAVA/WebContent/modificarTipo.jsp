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
    <link href="style/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
		<form class="form-horizontal" method="post" action="TipoElemento">
			 <fieldset>
                 <legend class="text-center header">Modificar Tipo de Elemento</legend>
                					<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">ID</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="id_tipo" class="form-control"  readonly="readonly" value=<c:out value="${tipo.id_tipo}" />>
		                              	</div>
		                          	</div>
		                          	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Nombre</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="nombre" class="form-control" value=<c:out value="${tipo.nombre}" />>
		                              	</div>
		                          	</div>
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Cantidad maxima</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="cantMax" class="form-control" value=<c:out value="${tipo.cantMaxima}" />>
		                              	</div>
		                          	</div>
			                        <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Dias anticipacion</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="diasAnt" class="form-control" value=<c:out value="${tipo.diasAnticipacion}" />>
		                              	</div>
		                          	</div>
			                     	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Tiempo maximo</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="tiempoMax" class="form-control" value=<c:out value="${tipo.tiempoMax}" />>
		                              	</div>
		                          	</div>		
		                          	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Solo Encargado</label>
		                              	<div class="col-sm-10">
		                              		<input type="checkbox" name="<c:out value="${tipo.soloEncargado}"/>" 
											id="soloEncargado" value="<c:out value="${tipo.soloEncargado}"/>" ${tipo.soloEncargado== 'true' ? 'checked' : ''}>
		                              	</div>
		                          	</div>	            
		                          	<div class="centrar-cont">
									<button type="input" name="crear" class="btn btn-primary" >Aceptar</button>
		                          		<input type="button" name="btnCancelar" value="Cancelar" class="btn btn-primary" onClick="location.href='tipoElementos.jsp'">	
		                          	</div></fieldset>
		</form>
		</div>
      </div>
    </div>
</div>
</body>
</html>