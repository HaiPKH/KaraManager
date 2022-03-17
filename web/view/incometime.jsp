<%-- 
    Document   : incometime
    Created on : Mar 17, 2022, 10:55:14 PM
    Author     : haiph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
                String error = String.valueOf(request.getAttribute("error"));
        %>
    </head>
    <body>
        <%if(error != "null"){%>
        <h4 style="color: red"><%=error%></h4>
        <%}%>
        <form action="income" method="POST">
            Enter starting date<input type="Date" name = "startdate"><br/>
            Enter ending date<input type="Date" name = "enddate"><br/>
            <input type="submit" value="Check income">
        </form>
    </body>
</html>
