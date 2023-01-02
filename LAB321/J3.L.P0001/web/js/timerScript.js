/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

   var end = document.getElementById("endT").value;
    var endTime = new Date(end.toString()).getTime();
var x = setInterval(function () {
 
    // Get current time
    var now = new Date().getTime();
    end = document.getElementById("endT");
    // Find the distance between current and endtime
    var distance = endTime - now;

    var minutes = Math.floor((distance % (1000 * 60 * 60)) / (1000 * 60));
    var seconds = Math.floor((distance % (1000 * 60)) / 1000);

    // Output the result in an element with id="demo"
//    document.getElementById("time").innerHTML = minutes + ": " + seconds;
    document.getElementById("time").innerHTML = end;

    // If the count down is over, write some text 
    if (distance > 0) {
        clearInterval(x);
        location.href = 'Finish';
    }
}, 1000);
