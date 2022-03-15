<%-- 
    Document   : update
    Created on : Mar 16, 2022, 4:57:29 AM
    Author     : haiph
--%>

<%@page import="model.Room"%>
<%@page import="model.Invoice"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Invoice inv = (Invoice) request.getAttribute("invoice");
            Room r = (Room) request.getAttribute("room");
        %>
    </head>
    <body>
        <form action="update" method="POST">
            <input type="hidden" name="bid" value="<%=inv.getBid()%>"/>
            <input type="hidden" name="priceperhour" value="<%=r.getPriceperhour()%>"/>
            <input type="hidden" name="timeelapsed" value="<%=inv.getTimeelapsed()%>"/> 
            <table>
                <tr>
                    <th>Room#</th>
                    <td><%=r.getName()%></td>
                </tr>
                <tr>
                    <th>Price per hour</th>
                    <td><%=r.getPriceperhour()%></td>
                </tr>
                <tr>
                    <th>Time elapsed</th>
                    <td><%=inv.getTimeelapsed()%></td>
                </tr>
                <tr>
                    <th>Other costs:</th>
                    <td><input type="text" name="othercost" value="<%=inv.getOthercost()%>" /></td>
                </tr>               
            </table>
                <input type="submit" value="Save"/>   
        </form>
    </body>
</html>
