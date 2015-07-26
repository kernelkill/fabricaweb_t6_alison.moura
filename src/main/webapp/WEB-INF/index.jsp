<%@page import="com.fabricadeprogramador.persistencia.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%  Usuario usu = (Usuario)session.getAttribute("usuario"); %>

<%@ include file="/WEB-INF/menu.jsp" %>
<br/>
<h4>Usuario: <%= usu.getLogin() %></h4>
<br/>
<br/>

<h1>Página inicial</h1>

</body>
</html>