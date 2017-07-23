<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet"/>

    <!-- Page Content -->
    <div class="container">
   	
        <!-- Portfolio Item Heading -->
        <div class="row">
            <div class="col-lg-12">
                <h1 class="page-header">${evento.nome}
                    <small><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.data.time}" /></small>
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
                <p>${evento.descricao}</p>
                <h3>Mais informações</h3>
                <ul>
                    <li><b>Site:</b> ${evento.site}</li>
                    <li><b>Local:</b> ${evento.local}</li>
                    <li>
                    	<b>Envio de Palestras:</b> <input type="checkbox" name="fechamento" data-toggle="toggle" data-on="Aberta" 
										data-off="Fechada" data-onstyle="success" data-offstyle="danger" data-size="mini" 
										<c:if test = "${evento.fechamento}">checked</c:if> 
										disabled readonly/>
						<c:if test = "${evento.fechamento}"><a href="${s:mvcUrl('PC#form').build() }" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-plus"></i></a></c:if><br />
                    </li>
                    <li>
						<b>Data:</b> <fmt:formatDate pattern="dd/MM/yyyy" value="${evento.data.time}" />
					</li>
                </ul>
            </div>

        </div>
        <!-- /.row -->

        <!-- Related Projects Row -->
        <div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Palestras do evento</h3>
            </div>
			<c:forEach items="${palestras}" var="palestra">
            <div class="col-sm-3 col-xs-6">
                <a href="${s:mvcUrl('HC#palestraDetalhe').arg(0, palestra.id).build()}">
                	<h4>${palestra.titulo}</h4>
                    <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                </a>
                <b>Palestrante: </b>${palestra.palestrante.nome}
                <b>Descrição: </b>${palestra.descricao}
            </div>
			</c:forEach>
        </div>
        <!-- /.row -->

        <hr>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<%@ include file="/WEB-INF/views/rodape.jsp" %>