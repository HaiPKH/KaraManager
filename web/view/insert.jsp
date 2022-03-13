<%-- 
    Document   : insert
    Created on : Mar 13, 2022, 10:12:21 PM
    Author     : haiph
--%>

<%@page import="java.sql.Time"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="model.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Room room = (Room) request.getAttribute("room");
            Timestamp now = new Timestamp(System.currentTimeMillis());
            Time time = new Time(now.getHours() - room.getTimestarted().getHours()
                            , now.getMinutes()- room.getTimestarted().getMinutes()
                            , now.getSeconds()- room.getTimestarted().getSeconds());
        %>
    </head>
    <body>
        <h2>Invoice:</h2>
        <form action="addinvoice" method="POST">
            <input type="hidden" value="<%=room.getRid()%>" id="roomid" name="roomid">
            <input type="hidden" value="<%=room.getTimestarted()%>" id="timestarted" name="timestarted">
            <input type="hidden" value="<%=now%>" id="timeended" name="timeended">
            <input type="hidden" value="<%=time%>" id="timeelapsed" name="timeelapsed">
            ID: <h4><%= room.getRid()%></h4>
            Name: <h4><%= room.getName()%></h4>
            Date created: <h4><%= room.getTimestarted() %></h4>
            Time Started: <h4><%= room.getTimestarted().getHours()%> : <%= room.getTimestarted().getMinutes()%> : <%= room.getTimestarted().getSeconds()%></h4>           
            Time Ended:  <h4><%=now.getHours()%> : <%=now.getMinutes()%> : <%=now.getSeconds()%> </h4> <br/>          
            Time Elapsed: <h4><%= now.getHours() - room.getTimestarted().getHours()%>:<%= now.getMinutes()- room.getTimestarted().getMinutes()%></h4>
            Others: <input type="text" name = "others" id="others"><br/>
            <input type="submit" value="Save"/>
        </form>
    </body>
</html>
