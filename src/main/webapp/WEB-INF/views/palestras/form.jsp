<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <!-- Page Content -->
    <div class="container">
        <!-- Portfolio Item Row -->
        <div class="row">
            <div class="col-md-12">
            	<form:form action="${s:mvcUrl('PC#gravar').build() }" method="post">
					<div for="titulo" class="form-group">
						<label for="titulo">titulo</label> 
						<input type="text" name="titulo" class="form-control" id="titulo" placeholder="titulo" value="" autofocus />
						<form:errors path="evento.titulo" />
					</div>
					<div for="descricao" class="form-group">
						<label>Descrição</label>
						<input type="text" name="descricao" class="form-control" id="descricao" placeholder="Descrição" value="" />
						<form:errors path="evento.descricao" />
					</div>
					<div for="palestrante" class="form-group">
						<label>palestrante</label>
						<select name="palestrante" class="form-control" id="palestrante">
						      <option value="0">-- Selecione um usuario --</option>
						      <c:forEach items="${usuarios}" var="usuario">
						            <option value="${usuario.id}">${usuario.nome}</option>
						        </c:forEach>
						</select>
						<form:errors path="evento.palestrante" />
					</div>
					<div for="evento" class="form-group">
						<label>evento</label>
						<select name="evento" class="form-control" id="evento">
						      <option value="0">-- Selecione um evento --</option>
						      <c:forEach items="${eventos}" var="evento">
						            <option value="${evento.id}">${evento.nome}</option>
						        </c:forEach>
						</select>
						<form:errors path="evento.evento" />
					</div>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form:form>
            </div>

        </div>
        <!-- /.row -->

        <hr>

<%@ include file="/WEB-INF/views/rodape.jsp" %>