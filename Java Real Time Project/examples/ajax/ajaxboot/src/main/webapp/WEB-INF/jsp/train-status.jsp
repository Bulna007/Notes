<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Train Status</title>
</head>
<body>
    <h2>Live Train Status</h2>
    <label for="trainNo">Train No : </label>
    <input type="number" name="trainNo" id="trainNo" required min="10000" max="99999"/><br/>
    <button onclick="liveStatus();">Live Status</button>

    <div id="liveStatus" style="border: 1px solid black; font-family: Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif; font-size: 14px;">
        Not Available
    </div>

    <script type="text/javascript">
        function liveStatus() {
            console.log("liveStatus");
            const inpTrainNo = document.getElementById("trainNo");

            const url = "http://localhost:8080/trainStatus?trainNo="+inpTrainNo.value;
            console.log("url :" +url);

            var http = new XMLHttpRequest();
            http.onreadystatechange = function() {
                if(http.readyState == 4 && http.status == 200) {
                    var trainStatus = http.responseText;
                    const liveStatusDiv = document.getElementById("liveStatus");
                    liveStatusDiv.innerHTML = trainStatus;
                }
            };
            http.open("GET", url, true);
            http.send();
        }
    </script>

</body>
</html>