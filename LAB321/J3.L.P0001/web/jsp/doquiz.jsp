<%-- 
    Document   : doquiz
    Created on : 11-07-2021, 20:54:56
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
        <!--<script type="text/javascript" src="js/timerScript.js"></script>-->
        <script>
            var endTime = new Date("${endTime}").getTime();

            var x = setInterval(function () {


                // Get today's date and time
                var now = new Date().getTime();

                // Find the distance between now and the count down date
                var distance = endTime - now;

                if (distance <= 0) {
                    clearInterval(x);
                    location.href = 'Finish';
                }
                else{
                var minutes = Math.floor((distance / (1000 * 60)));
                var seconds = Math.floor((distance % (1000 * 60) / 1000));

                document.getElementById("time").innerHTML = minutes + ": " + seconds;
                }

            }, 1000);
        </script>
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

                    <div class="time">
                        <!--<input type="hidden" id="endT" name="endTime" value="">-->
                        Time Remaining: 
                        <span id="time"  style="color: red">

                        </span>
                    </div>
                    <br>
                    <div class="ques">
                        ${test.get(currentQues-1).problem}
                        <form action="Next" method="post">
                            <div class="ans">
                                <input type="checkbox" name="answer" value="1">
                                ${test.get(currentQues-1).option1}
                            </div>
                            <div class="ans">
                                <input type="checkbox" name="answer" value="2">
                                ${test.get(currentQues-1).option2}
                            </div>
                            <div class="ans">
                                <input type="checkbox" name="answer" value="3">
                                ${test.get(currentQues-1).option3}
                            </div>
                            <div class="ans">
                                <input type="checkbox" name="answer" value="4">
                                ${test.get(currentQues-1).option4}
                            </div>                       

                            <div class="next">
                                <input type="submit" value="${next}">
                            </div>   

                        </form>
                    </div>
                </div>

            </div>
            <div class="footer"></div>  
        </div>

    </body>
</html>

