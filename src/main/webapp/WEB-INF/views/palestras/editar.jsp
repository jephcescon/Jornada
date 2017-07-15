<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <!-- Page Content -->
    <div class="container">
        <!-- Portfolio Item Row -->
        <div class="row">
            <div class="col-md-12">
            	<form:form action="${s:mvcUrl('PC#editar').arg(0, palestra.id).build() }" method="post">
					<div for="titulo" class="form-group">
						<label for="titulo">Titulo</label> 
						<input type="text" name="titulo" class="form-control" id="titulo" placeholder="Titulo" value="${palestra.titulo}" autofocus />
						<form:errors path="palestra.titulo" />
					</div>
					<div for="descricao" class="form-group">
						<label>Descrição</label>
						<input type="text" name="descricao" class="form-control" id="descricao" placeholder="Descrição" value="${palestra.descricao}" />
						<form:errors path="evento.descricao" />
					</div>
					<div for="palestrante" class="form-group">
						<label>palestrante</label>
						<select name="palestrante" class="form-control" id="palestrante">
						      <option value="0">-- Selecione um usuario --</option>
						      <c:forEach items="${usuarios}" var="usuario">
						            <option value="${usuario.id}"
						            
						            <c:if test="${usuario.id eq palestra.palestrante.id}">selected="selected"</c:if>
						            
						            >${usuario.nome}</option>
						        </c:forEach>
						</select>
						<form:errors path="evento.palestrante" />
					</div>
					<div for="evento" class="form-group">
						<label>evento</label>
						<select name="evento" class="form-control" id="evento">
						      <option value="0">-- Selecione um evento --</option>
						      <c:forEach items="${eventos}" var="evento">
						            <option value="${evento.id}"
						            
						            <c:if test="${evento.id eq palestra.evento.id}">selected="selected"</c:if>
						            
						            >${evento.nome}</option>
						        </c:forEach>
						</select>
						<form:errors path="evento.evento" />
					</div>
					<button type="submit" class="btn btn-primary">Alterar</button>
				</form:form>
            </div>

        </div>
        <!-- /.row -->

        <hr>

<%@ include file="/WEB-INF/views/rodape.jsp" %>