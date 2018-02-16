	</form><%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <!-- Bootstrap core CSS -->
    <link href="style/bootstrap.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="style/start.css" rel="stylesheet"><title>Crear Elemento</title>
        <link href="style/css/bootstrap.css" rel="stylesheet">
    
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
		<form class="form-horizontal" method="post" action="TipoElemento">
			 <fieldset>
                 <legend class="text-center header">Crear Tipo de Elemento</legend>
                					 <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Nombre</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="nombre" class="form-control">
		                              	</div>
		                          	</div>
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Cantidad maxima</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="cantMax" class="form-control">
		                              	</div>
		                          	</div>
			                        <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Dias anticipacion</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="diasAnt" class="form-control">
		                              	</div>
		                          	</div>
			                     	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Tiempo maximo</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="tiempoMax" class="form-control">
		                              	</div>
		                          	</div>		
		                          	<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Solo Encargado</label>
		                              	<div class="col-sm-10">
		                              		<input type="checkbox"  name="soloEncargado" class="form-control">
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