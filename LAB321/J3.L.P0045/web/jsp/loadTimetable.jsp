<%-- 
    Document   : loadTimetable
    Created on : 16-06-2021, 18:55:18
    Author     : Kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Time table</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <link rel="stylesheet" href="../css/style.css" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h3><img class="big" src="img\calendar.PNG" />Time Table</h3>
            </div>
            <div class="main">
                <div class="form">
                    <form action="TimeTable" method="GET">
                        <div class="box">
                            <label>From Date</label><br><input class="date-pick" type="date" name="fromD" value="${minDate}">
                        </div>                        
                        <div class="box">
                            <label>To Date</label><br><input class="date-pick" type="date" name="toD" value="${maxDate}">
                        </div>
                        <div class="box"><br>
                            <input class="button" type="submit" value="Search"></div>
                        <div class="box" id="link">
                            <br>
                            <a href="AddTimeTable"><img class="small" src="..\img\addtimetable.PNG"/>Add Timetable</a></div>
                    </form>

                </div>
                <div class="table">
                    <table>
                        <thead>
                            <tr>
                                <th><img class="small" src="img\calendar.PNG" />Date</th>
                                <th><img class="small" src="img\time.PNG" />Slot</th>
                                <th><img class="small" src="img\time.PNG" />Time</th>
                                <th>Class</th>
                                <th>Teacher</th>
                                <th>Room</th>
                                <th>Subject</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${timetableList}" var="item">
                                <tr>
                                    ${item.toString()}
                                </tr>

                            </c:forEach>

                        </tbody>
                    </table>

                </div>
                <div class="paging">
                    <c:choose>
                        <c:when test="${totalPage == 1}">
                        </c:when>
                        <c:otherwise>
                            <c:forEach begin="1" end="${totalPage}" var="i">
                                <c:if test="${currentPage == i}">
                                    <a class="page-current">${i}</a>
                                </c:if>
                                <c:if test="${currentPage != i}">
                                    <a class="page-link" href="TimeTable?page=${i}&fromD=${minDate}&toD=${maxDate}">${i}</a>
                                </c:if>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>

            </div>
            <div class="footer"></div>

        </div>
    </body>
</html>
