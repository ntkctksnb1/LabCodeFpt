<%-- 
    Document   : register
    Created on : 09-07-2021, 15:05:14
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
                    <!--<a href="Logout">Log Out</a>-->
                </div>

            </div>
            <div class="main">
                <div class="login-form">
                    <form action="Register" method="post">
                        <h3>Registration Form</h3>
                        <div class="form-line">
                            <label>User name: </label>
                            <input type="text" name="user" required value="${u}">
                        </div>

                        <div class="form-line">
                            <label>Password: </label>
                            <input type="password" name="pass" required>
                        </div>
                        <div class="form-line">
                            <label>User Type: </label>
                            <select name="type">
                                <option>Student</option>
                                <option>Teacher</option>
                            </select>
                        </div>
                        <div class="form-line">
                            <label>Email: </label>
                            <input type="text" name="mail" required value="${e}">
                        </div>
                        <div class="form-line">
                            <label></label>
                            <input type="submit" value="Register">
                           
                        </div>


                    </form>
                    <div class="msg">${msg}</div>
                </div>
            </div>
            <div class="footer"></div>  
        </div>
    </body>
</html>
