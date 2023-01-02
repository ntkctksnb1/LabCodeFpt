<%-- 
    Document   : add
    Created on : 16-06-2021, 23:44:34
    Author     : Kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Add new Time Table</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="css/style.css" type="text/css">
    </head>
    <body>
        <div class="container">
            <div class="header">
                <h3><img class="big" src="img\calendar.PNG" /> Add Time Table</h3>
            </div>
            <div class="main">
                <div class="formadd">
                    <form action="AddTimeTable" method="POST">

                        <div class="add">
                            <label> Date</label>
                            <input class="formadd-input" type="date" name="date" value="${datep}">
                        </div>
                        <div class="add">
                            <label>Slot</label>

                            <select class="formadd-input" name="slot">
                                <c:forEach items="${slotList}" var="i">
                                    <c:choose>
                                        <c:when test="${i.slotNo == slotp}">
                                            <option value="${i.slotNo}" selected>${i.slotNo}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i.slotNo}" >${i.slotNo}</option>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </c:forEach>
                                
                            </select>
                        </div>

                        <div  class="add">
                            <label>Room</label>
                            <select class="formadd-input" name="room">
                                
                                <c:forEach items="${roomList}" var="i">
                                    <c:choose>
                                        <c:when test="${i.roomName.equals(roomp)}">
                                            <option value="${i.roomName}" selected>${i.roomName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i.roomName}" >${i.roomName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                    
                                </c:forEach>
                            </select>
                        </div>
                        <div class="add">
                            <label>Teacher</label>

                            <input class="formadd-input" type="text" name="teacher" value="${teacherp}" required>
                        </div>
                        <div class="add">
                            <label>Class/Course</label>
                            <select class="formadd-input" name="class">
                                <c:forEach items="${classList}" var="i">
                                    <c:choose>
                                        <c:when test="${i.className.equals(classp)}">
                                            <option value="${i.className}" selected>${i.className}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option value="${i.className}">${i.className}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="add">
                            <label> Subject</label>
                            <input class="formadd-input" type="text" name="subject" value="${subjectp}">
                        </div>
                        <div class="add">
                            <label></label>
                            <input class="button" type="submit" value="Save">
                        </div>
                        

                    </form>
                        <div class="form2"></div>
                </div>
            </div>
            <div class="footer">${mess}</div>
        </div>
    </body>
</html>
