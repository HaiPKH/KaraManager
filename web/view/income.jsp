<%-- 
    Document   : income
    Created on : Mar 17, 2022, 11:10:21 PM
    Author     : haiph
--%>

<%@page import="java.sql.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Date d1 = Date.valueOf(String.valueOf(request.getAttribute("startdate")));
            Date d2 = Date.valueOf(String.valueOf(request.getAttribute("enddate")));
            int total = (Integer)request.getAttribute("total");
        %>
    </head>
    <body>
        <h4>Total income from <%=d1%> to <%=d2%></h4>
        <table border ="1px">
            <tr>
                <th>Total</th>
                <td><%=total%></td>
            </tr>
            
        </table>
    </body>
</html>
