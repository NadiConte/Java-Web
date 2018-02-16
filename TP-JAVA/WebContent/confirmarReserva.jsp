<!-- <%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%> -->
<%@page import="controlers.CtrlABMTipo"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Reserva</title>
    <link href="style/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
		<form class="form-horizontal" method="post" action="Elemento">
			 <fieldset>
                 <legend class="text-center header">Crear Reserva</legend>
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Fecha - Hora Desde</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="fecha_hora" class="form-control" placeholder="AAAA/MM/DD HH:mm:ss">
		                              	</div>
		                          	</div>
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Fecha - Hora Hasta</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="fecha_hora_hasta" class="form-control" placeholder="AAAA/MM/DD HH:mm:ss">
		                              	</div>
		                          	</div>
			                     	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Descripcion</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="descripcion" class="form-control">
		                              	</div>
		                          	</div>		                        
									<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Elementos</label>
		                              	<div class="col-sm-10">
		                                  	<select name="id_ele" id="elemento" class="form-control">
												<c:forEach items="${allElements}" var="e">
												<option value="${e.id_elemento}">${e.nombre}</option>
												  </c:forEach>
											</select>
		                              	</div>
		                          	</div>
		                          	<div class="centrar-cont">
									<button type="input" name="crear" class="btn btn-primary" >Aceptar</button>
		                          		<input type="button" name="btnCancelar" value="Cancelar" class="btn btn-primary" onClick="location.href='reservas.jsp'">	
		                          	</div>
		</form>
		</div>
      </div>
    </div>
</div>
</body>
</html>