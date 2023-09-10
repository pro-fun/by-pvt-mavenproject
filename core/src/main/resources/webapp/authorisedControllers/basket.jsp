<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.controller.basket.BasketServlet"%>
<%@ page import = "java.util.*"%>


<html>
<body>
<div>
<b>Список всех заказов в корзине</b>
<br>
<div>
<c:out value = "${message}"/>
</div>
<br>
<table>
<c:forEach var="basket" items= "${baskets}">
<tr>
<td> Номер позиции в корзине: ${basket.id}</td>
</tr>
<tr>
<td> Код продукта: ${basket.productId}</td>
</tr>
<tr>
<td> Количество продукта: ${basket.count}</td>
</tr>

</c:forEach>
</table>
</div>
</body>
</html>