<%@ page import="java.util.List" %>
<%@ page import="java.util.Date" %>
<%@ page import="com.ystu.web_first.Model.*" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.ystu.web_first.Main" %>
<%@ page import="com.ystu.web_first.servlets.HelloServlet" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<html>
    <meta charset="utf-8" />
    <link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">

    <body style="background-color: #d4dadc;">
    <div class="wrapper fadeInDown">
    <div class="formContent">
        <%! private int ig = 0;%>

        <h2>Авторизация</h2>
        <form id=<%=ig%> name="LoginShop" method="get">
        <p>Логин:<input id="login" class="fadeIn" type="text" name="login" /></p>
        <p>Пароль:<input id="password" class="fadeIn" type="text" name="pass" /></p>
        <p><input type="submit" class="fadeIn"  name="submit" value="Вход" /></p>
        </form>


        <% if (request.getAttribute("msgAut") != null) {%>
        <% String messageAut = (String) request.getAttribute("msgAut"); %>
        <c:set var="msgAutView" value="<%=messageAut.toString()%>"/>
        <h3>${msgAutView}</h3>
        <%}%>


        <h2>Регистрация</h2>
        <form id=<%=ig%> name="RegUser" method="post">
            <p>Логин:<input type="text" name="loginReg" /></p>
            <p>Пароль:<input type="text" name="passReg" /></p>
            <p>Возраст:<input type="text" name="ageReg" /></p>
            <p><input type="submit" class="btn btn-primary" data-toggle="modal" data-target=".bd-example-modal-sm" name="submit" value="Регистрация" /></p>
        </form>

    </div>


        <% if (request.getAttribute("msgReg") != null) {%>
            <% String messageReg = (String) request.getAttribute("msgReg"); %>
            <c:set var="msgRegView" value="<%=messageReg.toString()%>"/>
            <h3>${msgRegView}</h3>
        <%}%>

    </body>
</html>
