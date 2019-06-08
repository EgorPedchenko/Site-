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
    <body>
        <%! private int x = 0;%>
        <%! private int ig = 0;%>
        Число обращений к странице: <%= ++x %>

        <h2>Авторизация</h2>
        <form id=<%=ig%> name="LoginShop" method="get">
        <p>Логин:<input type="text" name="login" /></p>
        <p>Пароль:<input type="password" name="pass" /></p>
        <p><input type="submit" name="submit" value="Вход" /></p>
        </form>

        <% if (request.getAttribute("msgAut") != null) {%>
        <% String messageAut = (String) request.getAttribute("msgAut"); %>
        <c:set var="msgAutView" value="<%=messageAut.toString()%>"/>
        <h3>${msgAutView}</h3>
        <%}%>

    <br>

        <h2>Регистрация</h2>
        <form id=<%=ig%> name="RegUser" method="post">
            <p>Логин:<input type="text" name="loginReg" /></p>
            <p>Пароль:<input type="password" name="passReg" /></p>
            <p>Возраст:<input type="text" name="ageReg" /></p>
            <p><input type="submit" name="submit" value="Регистрация" /></p>
        </form>

        <% if (request.getAttribute("msgReg") != null) {%>
            <% String messageReg = (String) request.getAttribute("msgReg"); %>
            <c:set var="msgRegView" value="<%=messageReg.toString()%>"/>
            <h3>${msgRegView}</h3>
        <%}%>


    </body>
</html>
