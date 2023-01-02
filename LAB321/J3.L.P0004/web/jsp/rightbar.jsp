<%-- 
    Document   : rightbar
    Created on : 20-05-2021, 21:30:37
    Author     : Kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!--<link href="css/style.css" rel="stylesheet" type="text/css"/>-->
    </head>
    <body>
        <div class="right">
            <p class="title pd-left-20">Digital News</p>
            <p class="description">${topOne.description}</p>
            <p class="title pd-left-20">Search</p>
            <form class="search" action="Search" method="POST">
                <input class="text-search" type="text" name="txtSearch" value="${txtSearch}" required="" pattern="^\s*(.*\S)\s*$"/>
                <input class="go" type="submit" value="Go"/>
            </form>
            <p class="title pd-left-20">Last Articles</p>
            <ul class="list-reset">
                <c:forEach var="list" items="${topFive}">
                    <li><a class="link" href="View?id=${list.id}">${list.title}</a></li>
                    <br>
                    </c:forEach>
            </ul>
        </div>
    </body>
</html>

