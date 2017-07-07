<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Palestras</title>
</head>
<body>
	<table>
		<tr>
			<td>Nome</td>
			<td>E-mail</td>
			<td>Senha</td>
		</tr>
		<c:forEach items="${usuarios}" var="usuario">
		<tr>
			<td>${usuario.nome}</td>
			<td>${usuario.email}</td>
			<td>********</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>