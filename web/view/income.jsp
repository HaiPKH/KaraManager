<%-- 
    Document   : income
    Created on : Mar 17, 2022, 11:10:21 PM
    Author     : haiph
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="model.Invoice"%>
<%@page import="java.text.SimpleDateFormat"%>
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
            int total = (Integer) request.getAttribute("total");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            ArrayList<Invoice> invoices = (ArrayList<Invoice>) request.getAttribute("invoices");
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer totalpage = (Integer) request.getAttribute("totalpage");
        %>
        <script src="js/paging.js" type="text/javascript"></script>
        <link href="css/paging.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <h4>All invoices from <%=sdf.format(d1)%> to <%=sdf.format(d2)%></h4>
        <table border ="1px">
            <tr>
                <td>Date created</td>
                <td>Time elapsed</td>
                <td>Others</td>
                <td>Total cost</td>
            </tr>
            <%for (Invoice inv : invoices) {%>
            <tr>
                <td><%=inv.getDatecreated()%> </td>
                <td><%=inv.getTimeelapsed()%></td>
                <td><%=inv.getOthercost()%></td>
                <td><%=inv.getTotalcost()%></td>                
            </tr>
            <%}%>
        </table>
            <div id="container" class="paging"> </div>
            <script>
                paging("container",<%=pageindex%>,<%=totalpage%>, 1);
            </script>
        <h4>Total income from <%=sdf.format(d1)%> to <%=sdf.format(d2)%></h4>
        <table border ="1px">
            <tr>
                <th>Total</th>
                <td><%=total%></td>
            </tr>
        </table>
            <form action="menu" method="GET">
                <input type="submit" value="Return"/>
            </form>
    </body>
</html>
