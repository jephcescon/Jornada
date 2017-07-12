<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>

    <!-- Page Content -->
    <div class="container">
        <!-- Portfolio Item Row -->
        <div class="row">
            <div class="col-md-12">
            	<h3>Alterar usuário</h3>
	            <form action="${s:mvcUrl('UC#editar').arg(0, usuario.id).build() }" method="post">
					<div class="form-group">
						<label for="nome">Nome</label> 
						<input type="text" name="nome" class="form-control" id="nome" placeholder="Nome" value="${usuario.nome}"/>
					</div>
					<div for="email" class="form-group">
						<label>E-mail</label>
						<input type="text" name="email" class="form-control" id="email" placeholder="E-mail" value="${usuario.email}" />
					</div>
					<div for="senha" class="form-group">
						<label>Senha</label> 
						<input type="password" name="senha" class="form-control" id="senha" placeholder="Senha" value="${usuario.senha}"/>
					</div>
					<button type="submit" class="btn btn-primary">Alterar</button>
				</form>
            </div>

        </div>
        <!-- /.row -->

        <hr>

<%@ include file="/WEB-INF/views/rodape.jsp" %>