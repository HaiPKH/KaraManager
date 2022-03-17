<%-- 
    Document   : roominsert
    Created on : Mar 16, 2022, 10:05:55 PM
    Author     : haiph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            int priceperhour = (Integer) request.getAttribute("invalidprice");
        %>
    </head>
    <body>
        <%if(priceperhour == -1){%>
        <h5 style="color: red">Invalid price per hour value, please re-enter</h5>
        <%}%>
        <form action="/KaraManager/room/insert" method="POST">
            Enter room name: <input type="text" name="roomname"/><br/>
            Enter price per hour: <input type="text" name="priceperhour"/><br/>
            <input type="submit" value="Create new room">
        </form>
    </body>
</html>
