<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.controller.users.UserChangingServlet"%>
<%@ page import = "java.util.*"%>


<html>
<body>
<div>
<b>Список всех клиентов</b>
<table>
<c:forEach var="user" items= "${users}">
<tr>
<td> ID: ${user.userid}</td>
</tr>
<tr>
<td> Имя: ${user.name}</td>
</tr>
<tr>
<td> Фамилия: ${user.surname}</td>
</tr>
<tr>
<td> Логин: ${user.login}</td>
</tr>
<tr>
<td> Статус доступа: ${user.role}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>