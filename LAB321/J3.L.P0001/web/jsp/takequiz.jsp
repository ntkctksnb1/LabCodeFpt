<%-- 
    Document   : takequiz
    Created on : 11-07-2021, 15:54:30
    Author     : Kien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
                        Welcome <span>${user.username}</span>
                    </div>
                    <br>
                    <div>                       
                        <form action="StartQuiz" method="post">
                            <span>Enter number of question: </span><br>
                            <input type="text" name="number" pattern="[0-9]{1,2}" required>
                            <br>
                            <input class="button-mid" type="submit" value="Start">
                        </form>
                    </div>
                </div>
            </div>
            <div class="footer"></div>  
        </div>
    </body>
</html>

