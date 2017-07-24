<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

    <!-- Page Content -->
    <div class="container">
    	<!-- Portfolio Item Row -->
        <div class="row">
            <div class="col-md-12">
            	<div class="table-responsive">
		            <table class="table table-inverse">
						<thead>
							<tr>
								<th>Usuário</th>
								<th>Palestra</th>
								<th>Mensagem</th>
								<th>Data</th>
								<th>Apagar</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${comentarios}" var="comentario">
								<tr>
									<td>${comentario.usuario.nome}</td>
									<td>${comentario.palestra.titulo}</td>
									<td>${comentario.mensagem}</td>
									<td><fmt:formatDate pattern="dd/MM/yyyy" value="${comentario.data.time}" /></td>
									<td>
										<a href="#myModal_${comentario.id}" role="button" class="btn btn-danger" data-toggle="modal"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
										
										<div id="myModal_${comentario.id}" class="modal fade">
										    <div class="modal-dialog">
										        <div class="modal-content">
										            <div class="modal-header">
										                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
										                <h4 class="modal-title">Excluir comentario</h4>
										            </div>
										
										            <div class="modal-body">
										                <p>Tem certeza que deseja apagar esse comentario?? </p>
										            </div>
										            <div class="modal-footer">
										
										                <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
										                <a href="/jornada/comentario/apagar?id=${comentario.id}" title="Apagar" class="btn btn-danger"><i class="fa fa-trash-o"></i>Apagar</a>
										            </div>
										        </div>
										    </div>
										</div>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
	            </div>
            </div>

        </div>
        <!-- /.row -->

        <hr>
		
<%@ include file="/WEB-INF/views/rodape.jsp" %>