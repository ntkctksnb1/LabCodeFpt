<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>--%>
<%-- 
    Document   : manage
    Created on : 12-07-2021, 21:58:10
    Author     : Kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <title>Quiz</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style.css">
    </head>
    <body>
        <div class="pre-header"></div>
        <div class="container">           
            <div class="header">
                <div class="head-bar">
                    <a href="Home">Home</a>
                    <a href="TakeQuiz">Take Quiz</a>
                    <a href="MakeQuiz">Make Quiz</a>
                    <a href="ManageQuiz">Manage Quiz</a>
                    <a href="Logout">Log Out</a>
                </div>

            </div>
            <div class="main">
                <div class="question-form">
                    <div class="user">
                        Number of question <span>${uQuizList.size()}</span>
                    </div>
                    <br>
                    <div class="ques-list">
                        <table>
                            <thead>
                                <tr>
                                    <th>Question</th>
                                    <th>Date Created</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${uQuizList}" var="quiz">
                                    <tr>
                                        <td>${quiz.problem}</td>
                                        <td>${quiz.getFormattedDate()}</td>
                                    </tr>
                                </c:forEach>

                            </tbody>
                        </table>

                    </div>
                </div>
            </div>
            <div class="footer"></div>  
        </div>
    </body>
</html>
