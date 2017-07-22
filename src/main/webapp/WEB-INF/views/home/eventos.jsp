<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<link href="https://gitcdn.github.io/bootstrap-toggle/2.2.2/css/bootstrap-toggle.min.css" rel="stylesheet"/>

    <!-- Page Content -->
    <div class="container">
   	
        <!-- Row -->
        <div class="row">
            <div class="col-lg-12">
                <h3 class="page-header">Eventos</h3>
            </div>
			<c:forEach items="${eventos}" var="evento">
            <div class="col-sm-3 col-xs-6">
                <a href="${s:mvcUrl('HC#detalhes').arg(0, evento.id).build()}">
                	<h4>${evento.nome}</h4>
                    <img class="img-responsive portfolio-item" src="http://placehold.it/500x300" alt="">
                </a>
                <b>Data:</b> <fmt:formatDate pattern="dd/MM/yyyy" value="${evento.data.time}" /><br />
                <b>Local:</b> ${evento.local}<br />
                <b>Envio de Palestra:</b> 
                <input type="checkbox" name="fechamento" data-toggle="toggle" data-on="Aberta" 
										data-off="Fechada" data-onstyle="success" data-offstyle="danger" data-size="mini" 
										<c:if test = "${evento.fechamento}">checked</c:if> 
										disabled readonly/>
				<c:if test = "${evento.fechamento}"><a href="${s:mvcUrl('PC#form').build() }" class="btn btn-info btn-xs"><i class="glyphicon glyphicon-plus"></i></a></c:if><br />
                <b>Organizado:</b> ${evento.organizador.nome}<br /><br />
                 
            </div>
			</c:forEach>
        </div>
        <!-- /.row -->

        <hr>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<%@ include file="/WEB-INF/views/rodape.jsp" %>