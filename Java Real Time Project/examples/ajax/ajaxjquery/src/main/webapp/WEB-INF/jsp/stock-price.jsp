<!DOCTYPE html>
<html>
    <head>
        <title>Stock Price</title>
    </head>
    <body>
        <h2>Stock Price</h2>
        <form>
            <label for="stockName">Stock Name :</label>
            <input type="text" name="stockName" id="stockName"/><br/>
            <button type="button" id="stockPriceBtn">Get Stock Price</button>
        </form>
        <div id="contents">
        </div>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script type="text/javascript">
            var baseURL = "http://localhost:8080/ajaxjquery/stock/";

            $(document).ready(function(){
                $("#stockPriceBtn").click(function(){
                    const stockName = $("#stockName").val();
                    const requestUri = baseURL + stockName;
                    $.ajax({
                        url: requestUri,
                        type: "GET",
                        dataType: "json",
                        success: function(response) {
                            $("#contents").html("StockName: <b>"+response.stockName+"</b>, Price: <b>"+response.price+"</b>");
                        },
                        async: true,
                        error: function(xhr, status, error) {
                            $("#contents").html("error while getting the stock details, cause:" + error);
                        }
                    });
                });
            });
        </script>
    </body>
</html>