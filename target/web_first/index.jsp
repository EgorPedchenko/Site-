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
        <%! private int ig = 0;%>
        <%! private int g = 0;%>
        <%! private List<Long> GtrOrd;%>

        <% String name = (String) request.getSession().getAttribute("name"); %>
        <c:set var="myName" value="<%=name%>"/>
        <h2>Пользователь:</h2>
        <h3>${myName}</h3>

        <%! ArrayList<Guitar> guitarsView = new ArrayList<Guitar>();%>
        <%guitarsView = Data.getInstance().getGuitars();%>
        <%g=guitarsView.size();%>

        <h1>Список гитар:</h1>
        <% if (request.getAttribute("list") == null) {%>
            <% request.setAttribute("list", new ArrayList());%>
        <%}%>

        <% ((List)request.getAttribute("list")).clear(); %>

        <% for (int i=1; i<=g; i++) {%>
        <% ((List)request.getAttribute("list")).add (Data.getInstance().getGuitarById(i)); %>
        <%}%>

        <table>
            <col width="150" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <tr>
                <th>Наименование</th>
                <th>Цвет</th>
                <th>Цена</th>
                <th>Тип</th>
                <th>Купить</th>
            </tr>
            <c:forEach items="${list}" var="item">
                <% ++ig; %>
                <tr>
                    <td align="center">
                        ${item.name}
                    </td>
                    <td align="center">
                        ${item.color}
                    </td>
                    <td align="center">
                        ${item.price}
                    </td>
                    <td align="center">
                        ${item.type}
                    </td>
                    <td align="center">
                        <form id=<%=ig%> name="BuyGtrButton" method="post" action="/hello">
                            <input id="btn" type="submit" value=<%=ig%> name="button";/>
                        </form>
                    </td>
                </tr>
            </c:forEach>
        </table>

        <%((List)request.getAttribute("list")).clear(); %>
        <% ig=0; %>

        <h1>Корзина:</h1>
        <%-- if (Data.getInstance().isBuy()==true) { --%>
        <%--=Data.getInstance().getOrderById(1).getCustomer_id()--%>
        <% Long id = (Long) request.getSession().getAttribute("idUser"); %>

        <% GtrOrd = Data.getInstance().getOrderByCustomer(id).getGuitars(); %>
        <table>
            <col width="150" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <col width="100" valign="top">
            <tr>
                <th>Наименование</th>
                <th>Цвет</th>
                <th>Цена</th>
                <th>Тип</th>
        <%for (int j=0; j<GtrOrd.size(); j++){ %>
            <tr>
                <td align="center">
                    <%=Data.getInstance().getGuitarById(GtrOrd.get(j)).getName()%>
                </td>
                <td align="center">
                    <%=Data.getInstance().getGuitarById(GtrOrd.get(j)).getColor()%>
                </td>
                <td align="center">
                    <%=Data.getInstance().getGuitarById(GtrOrd.get(j)).getPrice()%>
                </td>
                <td align="center">
                    <%=Data.getInstance().getGuitarById(GtrOrd.get(j)).getType()%>
                </td>
            </tr>
        <% } %>
        </table>
        <%-- } --%>

    </body>
</html>
