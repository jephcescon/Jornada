<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/cabecalho.jsp" %>

    <!-- Page Content -->
    <div class="container">
        <!-- Portfolio Item Row -->
        <div class="row">
            <div class="col-md-12">
	            <table class="table table-inverse">
					<thead>
						<tr>
							<th>Titulo</th>
							<th>Palestrante</th>
							<th>Evento</th>
							<th>Ações</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${palestras}" var="palestra">
							<tr>
								<td>${palestra.titulo}</td>
								<td>${palestra.palestrante.nome}</td>
								<td>${palestra.evento.nome}</td>
								<td>
									<button type="button" class="btn btn-success" aria-label="Left Align">
  										<a href="${s:mvcUrl('UC#editar').arg(0, usuario.id).build()}"><span class="glyphicon glyphicon-pencil" aria-hidden="true"></span></a>
									</button>
									<a href="#myModal_${usuario.id}" role="button" class="btn btn-danger" data-toggle="modal"><span class="glyphicon glyphicon-trash" aria-hidden="true"></span></a>
								</td>
							</tr>
							<div id="myModal_${usuario.id}" class="modal fade">
							    <div class="modal-dialog">
							        <div class="modal-content">
							            <div class="modal-header">
							                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
							                <h4 class="modal-title">Excluir usuário</h4>
							            </div>
							
							            <div class="modal-body">
							                <p>Tem certeza que deseja apagar esse usuário?? </p>
							            </div>
							            <div class="modal-footer">
							
							                <button type="button" class="btn btn-primary" data-dismiss="modal">Fechar</button>
							                <a href="/jornada/usuarios/apagar?id=${usuario.id}" title="Apagar" class="btn btn-danger"><i class="fa fa-trash-o"></i>Apagar</a>
							            </div>
							        </div>
							    </div>
							</div> 
						</c:forEach>
					</tbody>
				</table>
            </div>

        </div>
        <!-- /.row -->

        <hr>
<%@ include file="/WEB-INF/views/rodape.jsp" %>