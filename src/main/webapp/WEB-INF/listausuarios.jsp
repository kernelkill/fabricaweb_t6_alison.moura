<%@page import="com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista de Usuários</title>

<script type="text/javascript">	
	
	function confirmar(){
		return window.confirm("Tem certeza que deseja excluir?");
		
	}

</script>

</head>
<body>

<% 
	List<Usuario> lista = (List)request.getAttribute("lista");
%>

<%@ include file="/WEB-INF/menu.jsp" %>
<br/>
<br/>
<br/>
<form method="post" action="usucontroller" onsubmit="return confirmar()">

<input type="hidden" name="acao" value="exc" />

<table style="border:1px solid black;">
	<thead>
		<tr>	
			<td>ID</td>
			<td>Nome</td>
			<td>Login</td>
			<td>Senha</td>
			<td>Selecione</td>
		</tr>
	</thead>
	<tbody style="background-color:rgba(0,0,0,.3);">
	
	<% for(Usuario usu : lista) { %>
	
		<tr>
			<td><%= usu.getId() %></td>
			<td><%= usu.getNome() %></td>
			<td><%= usu.getLogin() %></td>
			<td><%= usu.getSenha() %></td>
			<td>
				<input type="checkbox" name="id" value="<%= usu.getId() %>">
				<!-- Link para alteração -->
				<a href="usucontroller?acao=alt&id=<%= usu.getId()%>">Alterar</a>
			</td>
		</tr>
	
	<% } %>
	
	</tbody>

</table>

<input type="submit" value="Excluir"/>
<input type="button" value="Novo" onclick="location.href='usucontroller?acao=form'"/>

</form>

</body>
</html>