<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet"/>

    <!-- Page Content -->
    <div class="container">
   	
        <!-- Portfolio Item Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${palestra.titulo}
                    <small>by ${palestra.palestrante.nome}</small>
                </h1>
            </div>
        </div>
        <!-- /.row -->

        <!-- Portfolio Item Row -->
        <div class="row">

            <div class="col-md-8">
                <img class="img-responsive" src="http://placehold.it/750x500" alt="">
            </div>

            <div class="col-md-4">
                <h3>Descrição</h3>
                <p>${palestra.descricao}</p>
                <h3>Mais informações</h3>
                <ul>
                    <li><b>Palestrante:</b> ${palestra.palestrante.nome}</li>
                    <li>
                    	<b>Evento:</b> 
                    		<a href="${s:mvcUrl('HC#detalhes').arg(0, palestra.evento.id).build()}">
                    			${palestra.evento.nome}
                    		</a>
                    </li>
                </ul>
                
                <h3>Votação</h3>
                <b>Votos: </b> ${votacao.votos} (${votacao.positivos} Positivos <i class="glyphicon glyphicon-thumbs-up"></i> ${(100*votacao.positivos/votacao.votos)}%  - ${votacao.negativos} Negativos  <i class="glyphicon glyphicon-thumbs-down"></i> ${(100*votacao.negativos/votacao.votos) }% )<br /><br />
                <form:form action="${s:mvcUrl('VC#votar').build() }" method="post">
                	<input type="hidden" name="palestra" value="${palestra.id}">
	  				<input type="hidden" name="usuario" value="${palestra.palestrante.id}">
	  				<input type="hidden" name="voto" value="SIM">
                	<button type="submit" class="btn btn-success img-circle"><i class="glyphicon glyphicon-thumbs-up"></i> Gostei</button>
                </form:form>
                <form:form action="${s:mvcUrl('VC#votar').build() }" method="post">
                	<input type="hidden" name="palestra" value="${palestra.id}">
	  				<input type="hidden" name="usuario" value="${palestra.palestrante.id}">
	  				<input type="hidden" name="voto" value="NAO"> 
                	<button type="submit" class="btn btn-danger img-circle"><i class="glyphicon glyphicon-thumbs-down"></i> Não Gostei</button>
                </form:form>
                <h3>Comentários</h3>
                <security:authorize access="hasRole('ROLE_ADMIN')">
                <form:form action="${s:mvcUrl('CC#gravar').build() }" method="post">
	  				<textarea class="form-control" rows="2" id="mensagem" name="mensagem"></textarea><br />
	  				<input type="hidden" name="palestra" value="${palestra.id}">
	  				<input type="hidden" name="usuario" value="${palestra.palestrante.id}">
	  				<input type="hidden" name="data" value="">
	                <button type="submit" class="btn btn-success img-circle"><i class="glyphicon glyphicon-pencil"></i> Escrever</button>
                </form:form>
                </security:authorize>
                <security:authorize access="!hasRole('ROLE_ADMIN')">
                	<textarea class="form-control" rows="2" id="mensagem" name="mensagem" disabled>Necessário estar logado para comentar as palestras</textarea><br />
                	<a href="${pageContext.servletContext.contextPath}/login" class="btn btn-success" role="button"><i class="glyphicon glyphicon-lock"></i> Logar</a>
                </security:authorize>
            </div>
                
        </div>
        <!-- /.row -->

		<div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Comentários</h3>
            </div>
			
			<c:forEach items="${comentarios}" var="comentario">
            <div class="col-sm-12 col-xs-12">
                <p>"${comentario.mensagem}"</p>
                <b><em>${comentario.usuario.nome}</em></b> em <fmt:formatDate pattern="dd/MM/yyyy" value="${comentario.data.time}" /><br /><br />
            </div>
			</c:forEach>
            
        </div>
        
        <hr>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<%@ include file="/WEB-INF/views/rodape.jsp" %>