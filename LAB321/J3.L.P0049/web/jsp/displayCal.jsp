<%-- 
    Document   : displayCal
    Created on : 20-06-2021, 14:40:55
    Author     : Kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Calendar</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <div class="container">
            <div class="header"></div>
            <div class="main">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Sun</th>
                            <th>Mon</th>
                            <th>Tue</th>
                            <th>Wed</th>
                            <th>Thu</th>
                            <th>Fri</th>
                            <th>Sat</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var = "i" begin = "1" end = "6">
                            <tr>
                                <c:forEach var = "j" begin = "1" end = "7">
                                    <td>${j}</td>
                                    </c:forEach>
                            </tr>                    
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
