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
	<form action="/jornada/usuarios" method="post">
		<div>
			<label>Nome</label> <input type="text" name="nome" />
		</div>
		<div>
			<label>E-mail</label>
			<input type="text" name="email" />
		</div>
		<div>
			<label>Senha</label> <input type="password" name="senha" />
		</div>
		<button type="submit">Cadastrar</button>
	</form>
</body>
</html>