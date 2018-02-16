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
<div class="container">
    <div class="row">
        <div class="col-md-12">
            <div class="well well-sm">	
		<form class="form-horizontal" method="post" action="Elementos">
			 <fieldset>
                 <legend class="text-center header">Modificar Elemento</legend>
			                      <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">ID</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="id_ele" class="form-control" readonly="readonly" value=<c:out value="${elemento.id_elemento}" />>
		                              	</div>
		                          	</div>                   
			                      
			                       <div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Nombre</label>
		                              	<div class="col-sm-10">
		                                  	<input type="text" name="nombre" class="form-control" value=<c:out value="${elemento.nombre}"/>>
		                              	</div>
		                          	</div>
			                       
			                     			                        
									<div class="form-group">
		                              	<label class="col-sm-2 col-sm-2 control-label">Tipos de Elementos</label>
		                              	<div class="col-sm-10">
		                                  	<select name="id_tipo" id="tipo" class="form-control">
												<c:forEach items="${tipos}" var="t">
									       		 <option value="${t.id_tipo}" ${t.id_tipo == miTipo.id_tipo ? 'selected="selected"' : ''}>${t.nombre}</option>
									    			
									   			 </c:forEach>
											</select>
		                              	</div>
		                          	</div>
		                          	<div class="centrar-cont">
									<button type="input" name="modificar" class="btn btn-primary" >Aceptar</button>
		                          		<input type="button" name="btnCancelar" value="Cancelar" class="btn btn-primary" onClick="location.href='elementos.jsp'">	
		                          	</div>
		                          	</fieldset>
		</form>
		</div>
      </div>
    </div>
</div>

</body>
</html>