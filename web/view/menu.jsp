<%-- 
    Document   : menu
    Created on : Mar 1, 2022, 7:18:31 PM
    Author     : haiph
--%>

<%@page import="model.Account"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

    </head>
    <body>
        <h1 style="text-align: center; color: coral">MAIN MENU</h1>
        <a href="rooms"><button style="position: fixed;left: 41.8%;top:10%;height: 50px; width: 250px; font-size: 30px">Manage rooms</button></a>
        <a href="invoice"><button style="position: fixed;left: 41.8%;top:20%;height: 50px; width: 250px; font-size: 30px">View invoices</button></a>
        <button style="position: fixed;left: 41.8%;top:30%;height: 50px; width: 250px; font-size: 30px">View income</button>
    </body>
    <footer style="position: fixed;
            height: 50px;
            background-color: darkslateblue;
            bottom: 0px;
            left: 0px;
            right: 0px;
            margin-bottom: 0px;
            text-align: center;
            color: aquamarine">
        <div style="margin-top: 10px">
        <h7>Created by HaiPKH</h7>
        </div>
    </footer>
</html>
