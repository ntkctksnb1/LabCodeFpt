<%-- 
    Document   : home
    Created on : May 11, 2021, 11:23:16 AM
    Author     : ADMIN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>JSP Page</title>
            <link href="css/css.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>
                <div class="pre-header">
                </div>
                <div class="header">
                    <h3>My Digital News</h3>
                </div>
                <div class="menu">
                    <a href="home">News</a>
                </div>
                <div class="main">
                    <div class="main-left">
                        <div class="title">
                        ${n.title}
                    </div>
                    <div class="image">
                        <img src="images/${n.image}" alt=""/>
                    </div>
                    <div class="description">
                        ${n.description}
                    </div>
                    <div class="information">
                        <img src="images/comment.gif" alt=""/>
                        <img src="images/timeicon.gif" alt=""/>
                        By ${n.author} | ${n.dateFormat}
                    </div>
                </div>    
                <div class="main-right">
                    <div class="title">
                        Digital News
                    </div>
                    <div class="new-des">
                        ${n.shortDescription}
                    </div>
                    <div class="title">
                        Search
                    </div>
                    <form action="search?index=1" method="post">
                        <div class="search">
                        <input class="search-input" type="text" name="txtSearch">
                        <input class="search-submit" type="submit" value="Go">
                    </div>
                    </form>
                    <div class="title">
                        Last Articles
                    </div>
                    <c:forEach var="i" items="${list}">
                        <div class="list">
                            <a href="detail?id=${i.id}">${i.title}</a>
                        </div>
                        <br>
                    </c:forEach>
                </div>
            </div>
            <div class="footer">
            </div>
    </body>
</html>
