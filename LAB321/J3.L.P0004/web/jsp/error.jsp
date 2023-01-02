<%-- 
    Document   : error
    Created on : 15-05-2021, 21:29:11
    Author     : Kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <title>Error</title>
    </head>
    <body>
        <div class="container">
        <jsp:include page="header.jsp" />
        <div class="content">
            <div class="left pd-left-80">
                <h3>${error}</h3>
            </div>
            <jsp:include page="rightbar.jsp" />
        </div>
        <div class="footer"></div>
        </div>
    </body>
</html>
