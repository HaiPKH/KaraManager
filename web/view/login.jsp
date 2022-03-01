<%-- 
    Document   : login
    Created on : Mar 1, 2022, 7:55:24 PM
    Author     : haiph
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Account account = (Account)request.getAttribute("account");

            %>
    </head>
    <body>
        <form action="login" method="POST">
            Username: <input type="text" name="username" placeholder="Enter name" /> <br/>
            Password: <input type="password" name="password" placeholder="Enter password"/> <br/>
            <input type="submit" value="Login"/>
        </form>
        <%if(account == null){%>
        <script>alert("Invalid password, please re-enter")</script>
        <%}%>
    </body>
</html>
