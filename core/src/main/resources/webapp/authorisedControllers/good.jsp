<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.controller.GoodServlet"%>
<%@ page import = "java.util.*"%>


<html>
<body>
<div>
<b>Список всех товаров</b>
<br>
<table>
<c:forEach var="good" items= "${goods}">
<tr>
<td> ID: ${good.id}</td>
</tr>
<tr>
<td> Тип: ${good.type}</td>
</tr>
<tr>
<td> Наименование: ${good.name}</td>
</tr>
<tr>
<td> Код: ${good.code}</td>
</tr>
<tr>
<td> Цена: ${good.price}</td>
</tr>
<tr>
<td> Количество: ${good.quantity}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>