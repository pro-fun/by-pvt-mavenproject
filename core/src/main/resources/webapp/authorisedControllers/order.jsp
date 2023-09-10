<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.controller.orders.OrderServlet"%>
<%@ page import = "java.util.*"%>


<html>
<body>
<div>
<b>Список всех заказов</b>
<br>
<table>
<c:forEach var="order" items= "${orders}">
<tr>
<td> ID: ${order.id}</td>
</tr>
<tr>
<td> Цена: ${order.cost}</td>
</tr>
<tr>
<td> Статус: ${order.state.toString()}</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>