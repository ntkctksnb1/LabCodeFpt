<%-- 
    Document   : home
    Created on : May 11, 2021, 11:23:16 AM
    Author     : ADMIN
--%>

<%@page import="model.New"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <jsp:useBean id="n" class="dal.DAO" scope="request"></jsp:useBean>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>JSP Page</title>
            <link href="css/css.css" rel="stylesheet" type="text/css"/>
        </head>
        <body>

            <div class="container">
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
                        <div class="search-result">${number} results about "${txtSearch}"</div>
                    <ol style="font-weight: bold"type="1" start="${currentPage*3-2}"class="list-search">
                        <%
                            int i = 0;
                        %>
                        <c:forEach var="list" items="${list}">
                            <li>
                                <a class="title" href="detail?id=${list.id}">
                                    <%
                                        String txtSearch = request.getParameter("txtSearch");
                                        ArrayList<New> list = (ArrayList<New>) request.getAttribute("list");
                                        String txtList[] = list.get(i).getTitle().toUpperCase().split(txtSearch.toUpperCase());
                                        for (int j = 0; j < txtList.length; j++) {
                                            if (j < txtList.length - 1) {
                                    %><span><%= txtList[j]%></span><span style="background-color: yellow "><%= txtSearch.toUpperCase()%></span><%}
                                        if (j == txtList.length - 1) {
                                    %><span><%= txtList[j]%></span><%
                                            }
                                        }
                                        i++;
                                    %>
                                </a>
                                <br>
                                <div class="search-info">
                                    <div>
                                        <img src="images/${list.image}"/>
                                    </div>
                                    <div style="font-weight: normal" class="search-des">
                                        <p>${list.shortDescription}</p>
                                    </div>
                                </div>
                                <br><br>
                            </li>
                        </c:forEach>
                        <div class="paging">
                            <c:if test="${number>3}">
                                <c:forEach begin="1" end="${end}" var="i">
                                    <c:if test="${currentPage == i}">
                                        <a class="page-current">${i}</a>
                                    </c:if>
                                    <c:if test="${currentPage != i}">
                                        <a class="paging-box" href="search?index=${i}&txtSearch=${txtSearch}" >${i}</a>
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </div>
                    </ol>
                </div>    
                <div class="main-right">
                    <div class="title">
                        Digital News
                    </div>
                    <div class="new-des">
                        ${n.firstNew.shortDescription}
                    </div>
                    <div class="title">
                        Search
                    </div>
                    <form action="search?index=1" method="post">
                        <div class="search">
                            <input class="search-input" type="text" name="txtSearch" value="${txtSearch}">
                            <input class="search-submit" type="submit" value="Go">
                        </div>
                    </form>
                    <div class="title">
                        Last Articles
                    </div>
                    <c:forEach var="i" items="${n.top5News}">
                        <div class="list">
                            <a href="detail?id=${i.id}">${i.title}</a>
                        </div>
                        <br>
                    </c:forEach>
                </div>
            </div>
            <div class="footer">
            </div>
        </div>
    </body>
</html>
