<%-- 
    Document   : viewnews
    Created on : 20-05-2021, 21:31:25
    Author     : Kien
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Detail</title>
    </head>
    <body>
        <div class="container">
            <jsp:include page="header.jsp" />
            <div class="content">
                <div class="left pd-left-80">
                    <p class="title">${current.title}</p>
                    <img src="${current.image}"/>
                    <p class="information">${current.content}</p>
                    <div class="author">
                        <img src="images\comment.gif" />
                        <img src="images\timeicon.gif"/>
                        ${current.author} | ${current.getFormattedTime()}
                    </div>
                </div>
                <jsp:include page="rightbar.jsp" />
            </div>
            <div class="footer"></div>
        </div>
    </body>
</html>
