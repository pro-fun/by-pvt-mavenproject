<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.*"%>
<%@ page import = "java.util.*"%>

<html>
<body>
<form>
<div>
<c:out value = "${message}"/>
</div>
<br>

<p>Пройти Регистрацию: <a href="/registration.jsp">Регистрация</a>.</p>
<br>
<p>Пройти Авторизацию: <a href="/authorisation.jsp">Авторизация</a>.</p>

</form>
</html>