<%-- 
    Document   : roomupdate
    Created on : Mar 18, 2022, 2:18:03 AM
    Author     : haiph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            int rid = (Integer) request.getAttribute("rid");
            int errorCode = (Integer) request.getAttribute("errorCode");
        %>
    </head>
    <body style="background-color: gainsboro;">       
        <%if (errorCode == -1) {%>
        <h5 style="color: red">Invalid price per hour value, please re-enter</h5>
        <%} else if (errorCode == 1) {%>
        <h5 style="color: red">Invalid room name, please re-enter</h5>
        <%}%>
        <form action="/KaraManager/room/update" method="POST">
            <input type="hidden" name="rid" value="<%=rid%>"/>
            Enter room name: <input type="text" name="roomname"/><br/>
            Enter price per hour: <input type="text" name="priceperhour"/><br/>
            <input type="submit" value="Update room">
        </form>
    </body>
</html>
