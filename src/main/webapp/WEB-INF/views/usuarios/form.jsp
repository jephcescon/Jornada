<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

    <!-- Page Content -->
    <div class="container">
        <!-- Portfolio Item Row -->
        <div class="row">
            <div class="col-md-12">
            	<form:form action="${s:mvcUrl('UC#gravar').build() }" method="post">
					<div class="form-group">
						<label for="nome">Nome</label> 
						<input type="text" name="nome" class="form-control" id="nome" placeholder="Nome" value="" />
						<form:errors path="usuario.nome" />
					</div>
					<div for="email" class="form-group">
						<label>E-mail</label>
						<input type="text" name="email" class="form-control" id="email" placeholder="E-mail" value="" />
						<form:errors path="usuario.email" />
					</div>
					<div for="senha" class="form-group">
						<label>Senha</label> 
						<input type="password" name="senha" class="form-control" id="senha" placeholder="Senha" value="" />
						<form:errors path="usuario.senha" />
					</div>
					<button type="submit" class="btn btn-primary">Cadastrar</button>
				</form:form>
            </div>

        </div>
        <!-- /.row -->

        <hr>

<%@ include file="/WEB-INF/views/rodape.jsp" %>