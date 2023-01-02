<%-- 
    Document   : display
    Created on : 19-07-2021, 16:27:22
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
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="head-bar">
                <div class="next-prev">
                    <form action="Change" method="POST">
                        <input type="hidden" name="month" value="${cm-1}">
                        <input type="hidden" name="year" value="${cy}">
                        <input class="button" type="submit" value="<<">
                    </form>
                </div>
                <div class="current">${month}</div>
                <div class="next-prev">
                    <form action="Change" method="POST">
                        <input type="hidden" name="month" value="${cm+1}">
                        <input type="hidden" name="year" value="${cy}">
                        <input class="button" type="submit" value=">>">
                    </form>
                </div>
            </div>
            <div class="calendar">
                <table border="1" style="border-collapse: collapse">
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
                        <c:forEach var='i' begin='1' end='42'>
                            <c:choose>
                                <c:when test="${i % 7 ==1}">
                                    <c:if test="${!calendar.get(i-1).isCellDisplay() && !calendar.get(i-1).isRowDisplay()}">

                                    </c:if>
                                    <c:if test="${calendar.get(i-1).isCellDisplay() && calendar.get(i-1).isRowDisplay()}">
                                        <c:if test="${calendar.get(i-1).isToday()}">
                                            <tr><td class="today">${calendar.get(i-1).getDay()}</td>
                                            </c:if>
                                            <c:if test="${!calendar.get(i-1).isToday()}">
                                            <tr><td class="normal sunday">${calendar.get(i-1).getDay()}</td>
                                            </c:if>        
                                        </c:if>
                                        <c:if test="${!calendar.get(i-1).isCellDisplay() && calendar.get(i-1).isRowDisplay()}">
                                        <tr><td class="hidden"></td>
                                        </c:if>        
                                    </c:when>

                                   
                                    <c:when test="${i % 7 ==0}">

                                        <c:if test="${!calendar.get(i-1).isCellDisplay() && !calendar.get(i-1).isRowDisplay()}">

                                        </c:if>
                                        <c:if test="${calendar.get(i-1).isCellDisplay() && calendar.get(i-1).isRowDisplay()}">
                                            <c:if test="${calendar.get(i-1).isToday()}">
                                                <td class="today">${calendar.get(i-1).getDay()}</td></tr>
                                            </c:if>
                                            <c:if test="${!calendar.get(i-1).isToday()}">
                                        <td class="normal">${calendar.get(i-1).getDay()}</td></tr>
                                    </c:if>        
                                </c:if>
                                <c:if test="${!calendar.get(i-1).isCellDisplay() && calendar.get(i-1).isRowDisplay()}">
                                    <td class="hidden"></td></tr>
                                </c:if>       
                            </c:when>
                
                            <c:otherwise>
                                <c:if test="${!calendar.get(i-1).isCellDisplay() && !calendar.get(i-1).isRowDisplay()}">

                                </c:if>
                                <c:if test="${calendar.get(i-1).isCellDisplay() && calendar.get(i-1).isRowDisplay()}">
                                    <c:if test="${calendar.get(i-1).isToday()}">
                                        <td class="today">${calendar.get(i-1).getDay()}</td>
                                    </c:if>
                                    <c:if test="${!calendar.get(i-1).isToday()}">
                                        <td class="normal">${calendar.get(i-1).getDay()}</td>
                                    </c:if>        
                                </c:if>
                                <c:if test="${!calendar.get(i-1).isCellDisplay() && calendar.get(i-1).isRowDisplay()}">
                                    <td class="hidden"></td>
                                </c:if>       
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                    </tbody>
                </table>

            </div>
        </div>
    </body>
</html>
