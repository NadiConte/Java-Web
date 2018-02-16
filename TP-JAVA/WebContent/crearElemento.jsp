<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Nuevo Elemento</title>
    <link href="style/css/bootstrap.css" rel="stylesheet">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
		<form class="form-horizontal" method="post" action="Elemento">
			 <fieldset>
                 <legend class="text-center header">Crear Elemento</legend>
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Nombre</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="nombre" class="form-control">
		                              	</div>
		                          	</div>
			                       
			                     			                        
									<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Tipos de Elementos</label>
		                              	<div class="col-sm-10">
		                                  	<select name="id_tipo" id="tipo" class="form-control">
												<c:forEach items="${tipos}" var="t">
									       		 <option value="${t.id_tipo}">${t.nombre}</option>
									    			
									   			 </c:forEach>
											</select>
		                              	</div>
		                          	</div>
		                          	<div class="centrar-cont">
									<button type="input" name="crear" class="btn btn-primary" >Aceptar</button>
		                          		<input type="button" name="btnCancelar" value="Cancelar" class="btn btn-primary" onClick="location.href='elementos.jsp'">	
		                          	</div></fieldset>
		</form>
		</div>
      </div>
    </div>
</div><!--<a href="elementos.jsp"><button>Volver</button></a>-->

</body>
</html>