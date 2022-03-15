<%-- 
    Document   : invoice
    Created on : Mar 13, 2022, 8:51:39 PM
    Author     : haiph
--%>

<%@page import="model.Invoice"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            ArrayList<Invoice> invoices = (ArrayList<Invoice>) request.getAttribute("invoices");
            ArrayList<String> roomnames = (ArrayList<String>) request.getAttribute("roomnames");

        %>
    </head>
    <body>
        <div class = "invoices">        
        <table border ="1px">

            <tr>
                <td>Room#</td>
                <td>Date created</td>
                <td>Time started</td>
                <td>Time ended</td>
                <td>Time elapsed</td>
                <td>Others</td>
                <td>Total</td>
                <td> </td>

            </tr>
            <%
                if (!invoices.isEmpty()) {
                    for (int i = 0; i < invoices.size(); i++) {
            %>
            <tr>
                <td><%=roomnames.get(i)%></td>
                <td><%=invoices.get(i).getDatecreated().getDate()%>/<%=invoices.get(i).getDatecreated().getMonth() + 1%>/<%=invoices.get(i).getDatecreated().getYear() + 1900%></td>
                <td><%=invoices.get(i).getTimestarted().getHours()%> : <%=invoices.get(i).getTimestarted().getMinutes()%></td>
                <td><%=invoices.get(i).getTimeended().getHours()%> : <%=invoices.get(i).getTimeended().getMinutes()%></td>
                <td><%=invoices.get(i).getTimeelapsed().getHours()%> : <%=invoices.get(i).getTimeelapsed().getMinutes()%></td>
                <td><%=invoices.get(i).getOthercost()%></td>
                <td><%=invoices.get(i).getTotalcost()%></td>
                <td><a href="delete" value="<%=invoices.get(i).getBid()%>" id="deleteid" name ="deleteid">Delete</a></td>

            </tr>
            <%  }
            }else{
            %>
            <tr>
                <td>No record to display</td>
            </tr>
            <%}%>
        </table>
        <form action="menu" method="GET">
            <input type="submit" value="Return"/>
        </form>
        </div>
    </body>
</html>
