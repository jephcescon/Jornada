<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <!-- Page Content -->
    <div class="container">
        <!-- Portfolio Item Row -->
        <div class="row">
            <div class="col-md-12">
	            <table class="table table-inverse">
					<thead>
						<tr>
							<th>Nome</th>
							<th>Site</th>
							<th>Organizador</th>
							<th>Local</th>
							<th>Data</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${eventos}" var="evento">
							<tr>
								<td>${evento.nome}</td>
								<td>${evento.site}</td>
								<td>${evento.organizador.nome}</td>
								<td>${evento.local}</td>
								<td><fmt:formatDate pattern="dd/MM/yyyy" value="${evento.data.time}" /></td>
								<td>
									<button type="button" class="btn btn-success" aria-label="Left Align">
  										<a href="${s:mvcUrl('EC#editar').arg(0, evento.id).build()}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
									</button>
									<a href="#myModal_${evento.id}" role="button" class="btn btn-danger" data-toggle="modal"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
									
									<div id="myModal_${evento.id}" class="modal fade">
									    <div class="modal-dialog">
									        <div class="modal-content">
									            <div class="modal-header">
									                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
									                <h4 class="modal-title">Excluir evento</h4>
									            </div>
									
									            <div class="modal-body">
									                <p>Tem certeza que deseja apagar esse evento?? </p>
									            </div>
									            <div class="modal-footer">
									
									                <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
									                <a href="/jornada/evento/apagar?id=${evento.id}" title="Apagar" class="btn btn-danger"><i class="fa fa-trash-o"></i>Apagar</a>
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
        <!-- /.row -->

        <hr>

<%@ include file="/WEB-INF/views/rodape.jsp" %>