<%-- 
    Document   : rooms
    Created on : Mar 9, 2022, 3:29:20 PM
    Author     : haiph
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="css/rooms.css">
    </head>
    <body>
        <div class="rooms">
            <div class="room1">
                <h4>Room #1</h4>
                <button class="occupation">Occupied</button>
            </div>

            <div class="room2">
                <h4>Room #2</h4>
                <button class="occupation">Occupied</button>
            </div>

            <div class="room3">
                <h4>Room #3</h4>
                <button class="occupation">Occupied</button>
            </div>

            <div class="room4">
                <h4>Room #4</h4>
                <button class="occupation">Occupied</button>
            </div>

            <div class="room5">
                <h4>Room #5</h4>
                <button class="occupation">Occupied</button>
            </div>

            <div class="room6">
                <h4>Room #6</h4>
                <button class="occupation">Occupied</button>
            </div>

            <div style="clear: both; margin-bottom: 10px;"></div>

        </div>
        <form action="rooms" method="POST">
            <input type="submit" value="Return"/>
        </form>
    </body>
</html>
