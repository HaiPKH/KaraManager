<%-- 
    Document   : insert
    Created on : Mar 13, 2022, 10:12:21 PM
    Author     : haiph
--%>

<%@page import="java.time.Duration"%>
<%@page import="java.time.Instant"%>
<%@page import="java.sql.Time"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="model.Room"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <style>
            .invoice {
                margin: auto;
                width: 30%;
                border: 3px solid #73AD21;
                padding: 10px;
                text-align: center;
                background-color: #ff6666
            }
        </style>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%
            Room room = (Room) request.getAttribute("room");
            Timestamp now = new Timestamp(System.currentTimeMillis());
            Instant current = now.toInstant();
            Instant timestarted = room.getTimestarted().toInstant();
            Duration elapsed = Duration.between(timestarted, current);
            Long l = elapsed.getSeconds();
            int secondsElapsed = l.intValue();
            Time time = new Time(secondsElapsed / 3600,
                                (secondsElapsed % 3600) / 60,
                                secondsElapsed % 60);
        %>
    </head>
    <body>
        <div class="invoice">
            <h2>Invoice:</h2>
            <form action="addinvoice" method="POST">              
                <input type="hidden" value="<%=room.getRid()%>" id="roomid" name="roomid">
                <input type="hidden" value="<%=room.getTimestarted()%>" id="timestarted" name="timestarted">
                <input type="hidden" value="<%=now%>" id="timeended" name="timeended">
                <input type="hidden" value="<%=time%>" id="timeelapsed" name="timeelapsed">
                <table class="invoicetable">    
                    <tr>
                        <th>RoomID</th>
                        <td><%= room.getRid()%></td>
                    </tr>
                    <tr>
                        <th>Name:</th>
                        <td><%= room.getName()%></td>
                    </tr>
                    <tr>
                        <th>Date created:</th>
                        <td><%= room.getTimestarted().getDate()%>/<%= room.getTimestarted().getMonth()%>/<%= room.getTimestarted().getYear()+ 1900%></td>
                    </tr>
                    <tr>
                        <th>Time Started:</th>
                        <td><%= room.getTimestarted().getHours()%> : <%= room.getTimestarted().getMinutes()%> : <%= room.getTimestarted().getSeconds()%></td>
                    </tr>
                    <tr>
                        <th>Time Ended:</th>
                        <td><%= now.getHours()%> : <%=now.getMinutes()%> : <%=now.getSeconds()%></td>
                    </tr>           
                    <tr>
                        <th>Time Elapsed:</th>
                        <td><%=time.getHours()%>:<%=time.getMinutes()%>:<%=time.getSeconds()%></td>
                    </tr> 
                    <tr>
                        <th>Others:</th>
                        <td><input type="text" name = "others" id="others"></td>
                    </tr>     
                    <tr>
                        <th></th>
                        <td><input type="submit" value="Save"/></td>
                    </tr>                      
                </table>
            </form>          
        </div>
           <form action="rooms" method="GET">
                <input type="submit" value="Return"/>
            </form>         
    </body>
</html>
