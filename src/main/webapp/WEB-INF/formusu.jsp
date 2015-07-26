<%@page import="com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Usuário</title>

<script type="text/javascript">
	
	function salvar(){
		if(validar()){
			alert('Salvo com sucesso!');
		}
	}
	
	function validar(){
		
		if(document.form.nome.value == "" || document.form.nome.value == null){
			
			alert("Preencha o nome");
			
			document.form.nome.focus();
			
			return false;
		}else
			return true;
	}
	
	</script>

</head>
<body>

	<% Usuario usu = (Usuario)request.getAttribute("usuario"); %>

	<form method="post" action="usucontroller" name="form"
		onsubmit="return validar()">

		<input type="hidden" name="acao" value="cad"> 
		
		<label for="inpId">ID</label> 
		<input id="inpId" type="text" readonly="readonly" name="id" value="<%= usu.getId()%>"/>
		<br />

		<label for="inpNome">Nome:</label>
		<input id="inpNome" type="text" name="nome" value="<%= usu.getNome()%>"/>
		<br /> 
			
		<label for="inpLogin">Login:</label> 
		<input id="inpLogin" type="text" name="login" value="<%= usu.getLogin()%>"/>
		<br /> 
		
		<label for="inpSenha">Senha:</label> 
		<input id="inpSenha" type="password" name="senha" required="Senha requerida" value="<%= usu.getSenha()%>"/>
		<br />
		 
		<input type="submit" value="Salvar" onclick="salvar()" />

	</form>

</body>
</html>