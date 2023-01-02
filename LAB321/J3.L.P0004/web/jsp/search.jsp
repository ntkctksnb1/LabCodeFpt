<%-- 
    Document   : search
    Created on : 20-05-2021, 21:30:10
    Author     : Kien
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>

        <title>Search</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
            <div class="content">
                <div class="left pd-left-80">
                    <ul class="list-reset">
                        <c:choose>
                            <c:when test="${empty listSearch}">
                                <p>No result was found!</p>
                            </c:when>
                            <c:otherwise>
                                <p>Found ${totalNumber} news!</p>
                            </c:otherwise>
                        </c:choose>

                        <c:forEach var="news" items="${listSearch}">
                            <li>
                                <a class="title" href="View?id=${news.id}">${news.title}</a>
                                <br>
                                <div class="search-info">
                                    <div>
                                        <img src="${news.image}"/>
                                    </div>
                                    <div class="search-des">
                                        <p>${news.description}</p>
                                    </div>
                                </div>
                                <br><br>
                            </li>
                        </c:forEach>
                        <div class="paging">
                            <c:choose>
                                <c:when test="${endPage==1}">
                                </c:when>
                                <c:otherwise>
                                    <c:forEach begin="1" end="${endPage}" var="i">
                                        <c:if test="${currentPage == i}">
                                            <a class="page-current">${i}</a>
                                        </c:if>
                                        <c:if test="${currentPage != i}">
                                            <a class="page-link" href="Search?index=${i}&txtSearch=${txtSearch}">${i}</a>
                                        </c:if>
                                    </c:forEach>
                                </c:otherwise>
                            </c:choose>

                        </div>
                    </ul>
                </div>
                <jsp:include page="rightbar.jsp" />
            </div>
            <div class="footer">
            </div>
        </div>
    </body>
</html>
