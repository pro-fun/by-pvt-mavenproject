<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.controller.GoodServlet"%>
<%@ page import = "java.util.*"%>

<html>
<body>
<div>
<b>Найденный товар по id</b>
<br>

<c:out value = "${good}" />


</div>
</body>
</html>