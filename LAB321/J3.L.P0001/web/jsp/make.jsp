<%-- 
    Document   : make
    Created on : 12-07-2021, 22:42:23
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
                <div class="login-form" id="make-ques">
                    <form action="MakeQuiz" method="post">
                        <h3>Add New Quiz</h3>
                        <div class="form-line">
                            <label>Question: </label>
                            <textarea name="question" required></textarea>
                        </div>
                        <div class="form-line">
                            <label>Option 1: </label>
                            <textarea name="option1" ></textarea>
                        </div>
                        <div class="form-line">
                            <label>Option 2: </label>
                            <textarea name="option2" ></textarea>
                        </div>
                        <div class="form-line">
                            <label>Option 3: </label>
                            <textarea name="option3"></textarea>
                        </div>
                        <div class="form-line">
                            <label>Option 4: </label>
                            <textarea name="option4"></textarea>
                        </div>
                        <div class="form-line">
                            <label>Answer(s): </label>
                            <input type="checkbox" name="answer" value="1">Option 1
                            <input type="checkbox" name="answer" value="2">Option 2
                            <input type="checkbox" name="answer" value="3">Option 3
                            <input type="checkbox" name="answer" value="4">Option 4
                        </div>

                        <div class="form-line">
                            <label></label>
                            <input type="submit" value="Save">

                        </div>


                    </form>
                    <div class="msg">${msg}</div>
                </div>
            </div>
            <div class="footer"></div>  
        </div>
    </body>
</html>
