<%-- 
    Document   : rooms
    Created on : Mar 9, 2022, 3:29:20 PM
    Author     : haiph
--%>

<%@page import="java.text.SimpleDateFormat"%>
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
        %>
    </head>
    <body>
        
        <div class="rooms">
            
            <% for (Room r : rooms) {%>
            <div class="row">
                
            <div class="room1 column" id="<%=r.getRid()%>">   
                
                <h3 class="Title">Room <%=r.getName()%></h3>
                <%if (r.isIsUsed()) {%>
                <h4>Room is used</h4>
                <h4>Starting time: </h4>
                <h4><%=r.getTimestarted().getHours()%>:<%=r.getTimestarted().getMinutes()%></h4>              
                <form action="addinvoice" method="GET" class="occupied">
                    <input type="hidden" value="<%=r.getRid()%>" id="roomid" name="roomid">
                    <button style="color: red">Create invoice</button>
                </form>

                <%} else {%>             
                <h4>Room is vacant</h4>
                <h4>Starting time: </h4> 
                <h4>N/A</h4>
                <form action="rooms" method="POST" class="vacant">
                    <input type="hidden" value="<%=r.getRid()%>" id="roomid" name="roomid">
                    <button style="color: #73AD21">Vacant</button>
                </form>
                <%}%>
                <form action="/KaraManager/room/update" method="GET" class="update">
                    <input type="hidden" value="<%=r.getRid()%>" id="roomid" name="roomid">
                    <input type="submit" value="Update room"/>
                </form>
            
            </div>
            <%if (!r.isIsUsed()) {%>    
            <script>document.getElementById(<%=r.getRid()%>).style.backgroundColor = "limegreen";</script>
            <%}%>
            <%}%>

            <div style="clear: both; margin-bottom: 10px;"></div>
                </div>
            </div>
            <div class="container form">
        <form class="btn1" action="menu" method="GET">
            <input style="color:red;font-size:20px;" type="submit" value="Return"/>
        </form>
            
        <form class="btn2" action="/KaraManager/room/insert" method="GET">
            <input style="color:red;font-size:20px;" type="submit" value="Add rooms" />
        </form>
            </div>
    </body>
</html>
