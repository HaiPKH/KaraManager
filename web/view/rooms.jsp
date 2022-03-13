<%-- 
    Document   : rooms
    Created on : Mar 9, 2022, 3:29:20 PM
    Author     : haiph
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="model.Room"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/rooms.css">
        <%
            ArrayList<Room> rooms = (ArrayList<Room>) request.getAttribute("rooms");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        %>
    </head>
    <body>
        <div class="rooms">
            <% for (Room r : rooms) {%>
            <div class="room1">
                <h3 class="Title">Room <%=r.getName()%></h3>
                <%if (r.isIsUsed()) {%>
                <h4>Room is used</h4>
                <h4>Starting time: </h4>
                <h4><%=r.getTimestarted()%></h4>
                <%} else {%>
                <h4>Room is vacant</h4>
                <h4>Starting time: </h4> 
                <h4>N/A</h4>
                <%}%>
                <%if (r.isIsUsed()) {%>
                <button class="occupied" disabled>Occupied</button>
                <form action="addinvoice" method="GET">
                    <input type="hidden" value="<%=r.getRid()%>" id="roomid" name="roomid">
                    <button class="occupied">Create invoice</button>
                </form>
                <%} else {%>
                <form action="rooms" method="POST">
                    <input type="hidden" value="<%=r.getRid()%>" id="roomid" name="roomid">
                    <button class="vacant">Vacant</button>
                </form>
                <%}%>
            </div>
            <%}%>

            <div style="clear: both; margin-bottom: 10px;"></div>

        </div> 
        <form action="menu" method="GET">
            <input type="submit" value="Return"/>
        </form>
    </body>
</html>
