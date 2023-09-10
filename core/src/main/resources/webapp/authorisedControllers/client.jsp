<%@ page pageEncoding= "UTF-8" contentType= "text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import = "by.academypvt.*"%>
<%@ page import = "java.util.*"%>

<html>
<body>
<div>
<b>Здравствуйте, </b> <c:out value = "${userResponse.name}"/>
</div>
<br>

<br>
<form name="Form"
      method="GET"
      action="http://localhost:8081/goods">
      <input type=submit value="Все товары магазина">
      </form>
      <br>
<br>
<br>
<form name="Form"
      method="post"
      action="http://localhost:8081/goods">
    <div>
        <label><b>Id товара для поиска</b></label>
        <input type="text" placeholder="ID" name="idFind">

    <input type="hidden" name="action" value = "find">
    <input type=submit value="Найти товар по ID">
    </div>
</form>

<b>Показать товары в корзине</b>
<br>
<form name="Form"
      method="GET"
      action="http://localhost:8081/basket">
      <input type=submit value="Показать товары в корзине">
      </form>
      <br>
<br>
<b>Добавить товар в корзину</b>
<br>

<form name="Form"
      method="Post"
      action="http://localhost:8081/basket">
    <div>
        <label><b>Код товара</b></label>
        <input type="text" placeholder="Код" name="code">

        <label><b>Количество товара</b></label>
        <input type="text" placeholder="Количество" name="quantity">

    <input type="hidden" name="action" value = "add">
    <input type=submit value="Добавить товар">
    </div>
</form>

<br>
<b>Удалить товар из корзины</b>
<br>

<form name="Form"
      method="Post"
      action="http://localhost:8081/basket">
    <div>
        <label><b>Номер позиции в корзине</b></label>
        <input type="text" placeholder="Код" name="basketId">


    <input type="hidden" name="action" value = "delete">
    <input type=submit value="Удалить товар">
    </div>
</form>
<br>
<form name="Form"
      method="GET"
      action="http://localhost:8081/orders">
      <input type=submit value="Оформить заказ">
      </form>
      <br>
<br>
<br>
<form name="Form"
      method="POST"
      action="http://localhost:8081/orders">
      <input type=submit value="Просмотреть все мои заказы">
      </form>
      <br>
<br>

</body>
</html>


