<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.controller.orders.OrderChangingServlet"%>
<%@ page import = "java.util.*"%>

<html>
<body>
<div>
<b>Найденный заказ по id</b>
<br>

<c:out value = "${order}" />


</div>
</body>
</html>