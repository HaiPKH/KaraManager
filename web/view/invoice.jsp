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
            Integer pageindex = (Integer) request.getAttribute("pageindex");
            Integer totalpage = (Integer) request.getAttribute("totalpage");
        %>
        <script>
            function deleteInvoice(bid)
            {
                var result = confirm("Are you sure?");
                if (result)
                {
                    window.location.href = 'delete?bid=' + bid;
                }
            }
        </script>
        <script src="js/paging.js" type="text/javascript"></script>
        <link href="css/paging.css" rel="stylesheet" type="text/css"/>
        <link href="css/invoices.css" rel="stylesheet" type="text/css"/>
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
                    <td> </td>
                </tr>
                <%                if (!invoices.isEmpty()) {
                        for (int i = 0; i < invoices.size(); i++) {
                %>
                <input type="hidden">
               
                <tr>
                    <td><%=roomnames.get(i)%></td>
                    <td><%=invoices.get(i).getDatecreated().getDate()%>/<%=invoices.get(i).getDatecreated().getMonth() + 1%>/<%=invoices.get(i).getDatecreated().getYear() + 1900%></td>
                    <td><%=invoices.get(i).getTimestarted().getHours()%> : <%=invoices.get(i).getTimestarted().getMinutes()%></td>
                    <td><%=invoices.get(i).getTimeended().getHours()%> : <%=invoices.get(i).getTimeended().getMinutes()%></td>
                    <td><%=invoices.get(i).getTimeelapsed().getHours()%> : <%=invoices.get(i).getTimeelapsed().getMinutes()%></td>
                    <td><%=invoices.get(i).getOthercost()%></td>
                    <td><%=invoices.get(i).getTotalcost()%></td>
                    <td>
                        <a href="#" onclick="deleteInvoice(<%=invoices.get(i).getBid()%>)"><button>Delete</button></a>
                    </td>
                    <td>
                        <a href="update?bid=<%=invoices.get(i).getBid()%>"><button>Update</button></a>
                    </td>
                </tr>
                <%  }
                } else {
                %>
                <tr>
                    <td>No record to display</td>
                </tr>
                <%}%>
            </table>
            <div id="container" class="paging"> </div>
            <script>
                paging("container",<%=pageindex%>,<%=totalpage%>, 1);
            </script>
            <form action="menu" method="GET">
                <input type="submit" value="Return"/>
            </form>
        </div>
    </body>
</html>
