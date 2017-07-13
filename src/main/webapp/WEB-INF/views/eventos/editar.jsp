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
            	<form:form action="${s:mvcUrl('EC#gravar').build() }" method="post">
					<div for="nome" class="form-group">
						<label for="nome">Nome</label> 
						<input type="text" name="nome" class="form-control" id="nome" placeholder="Nome" value="${evento.nome}" autofocus />
						<form:errors path="evento.nome" />
					</div>
					<div for="descricao" class="form-group">
						<label>Descrição</label>
						<input type="text" name="descricao" class="form-control" id="descricao" placeholder="Descrição" value="${evento.descricao}" />
						<form:errors path="evento.descricao" />
					</div>
					<div for="site" class="form-group">
						<label>Site</label>
						<input type="text" name="site" class="form-control" id="site" placeholder="Site" value="${evento.site}" />
						<form:errors path="evento.site" />
					</div>
					<div for="organizador" class="form-group">
						<label>Organizador</label>
						<select name="organizador" class="form-control" id="organizador">
						      <option value="0">-- Selecione um usuario --</option>
						      <c:forEach items="${usuarios}" var="usuario">
						            <option value="${usuario.id}" 
						            
						            <c:if test="${usuario.id eq evento.organizador.id}">selected="selected"</c:if>
						            
						            >${usuario.nome}</option>
						        </c:forEach>
						</select>
						<form:errors path="evento.organizador" />
					</div>
					<div for="local" class="form-group">
						<label>Local</label>
						<input type="text" name="local" class="form-control" id="local" placeholder="Local" value="${evento.local}" />
						<form:errors path="evento.local" />
					</div>
					<div for="logo" class="form-group">
						<label>Logo</label>
						<input type="text" name="logo" class="form-control" id="logo" placeholder="Logo" value="${evento.logo}" />
						<form:errors path="evento.logo" />
					</div>
					<div for="data" class="form-group">
						<label>Data</label><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.data.time}" var="dataEvento" />
						<input type="text" name="data" class="form-control" id="data" placeholder="Data dd/mm/aaaa" value="${dataEvento}" />
						<form:errors path="evento.data" />
					</div>
					<button type="submit" class="btn btn-primary">Alterar</button>
				</form:form>
            </div>

        </div>
        <!-- /.row -->

        <hr>

<%@ include file="/WEB-INF/views/rodape.jsp" %>