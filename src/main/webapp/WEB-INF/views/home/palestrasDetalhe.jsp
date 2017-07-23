<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>

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
                <b>Votos: </b> 0 (0 Positivos <i class="glyphicon glyphicon-thumbs-up"></i> 0%  - 0 Negativos  <i class="glyphicon glyphicon-thumbs-down"></i> 0% )<br /><br />
                <button type="button" class="btn btn-primary img-circle"><i class="glyphicon glyphicon-thumbs-up"></i> Gostei</button> 
                <button type="button" class="btn btn-danger img-circle"><i class="glyphicon glyphicon-thumbs-down"></i> Não Gostei</button>
                
                <h3>Comentar</h3>
                <button type="button" class="btn btn-success img-circle"><i class="glyphicon glyphicon-pencil"></i> Escrever</button>
            </div>
                
        </div>
        <!-- /.row -->

		<div class="row">

            <div class="col-lg-12">
                <h3 class="page-header">Comentários</h3>
            </div>
			
            <div class="col-sm-12 col-xs-12">
                <p>"Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum."</p>
                <b>Jepherson Cescon</b> 22/07/2017
                 
            </div>
			
            
        </div>
        
        <hr>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
		<script src="https://gitcdn.github.io/bootstrap-toggle/2.2.2/js/bootstrap-toggle.min.js"></script>
<%@ include file="/WEB-INF/views/rodape.jsp" %>