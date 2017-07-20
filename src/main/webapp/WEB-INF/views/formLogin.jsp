<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!-- Page Content -->
<div class="container">
	<form:form servletRelativeAction="/login" class="well form-horizontal"  method="post" id="contact_form">
		<fieldset>

			<!-- Form Name -->
			<legend>Login</legend>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label">E-Mail</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-envelope"></i></span> <input name="username"
							placeholder="E-Mail" class="form-control" type="text">
					</div>
				</div>
			</div>

			<!-- Text input-->
			<div class="form-group">
				<label class="col-md-4 control-label">Senha</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"><i
							class="glyphicon glyphicon-lock"></i></span> 
							<input name="password" placeholder="Senha" class="form-control" type="password">
					</div>
				</div>
			</div>

			<!-- Button -->
			<div class="form-group">
				<label class="col-md-4 control-label"></label>
				<div class="col-md-4">
					<button type="submit" class="btn btn-primary">
						Logar <span class="glyphicon glyphicon-send"></span>
					</button>
				</div>
			</div>

		</fieldset>
	</form:form>

<hr>

<%@ include file="/WEB-INF/views/rodape.jsp"%>