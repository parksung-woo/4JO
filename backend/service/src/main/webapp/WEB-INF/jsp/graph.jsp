<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2020-08-10
  Time: 오전 11:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        .main{
            height: 95%;
            width: 99%;
            background-position: center;
            background-size: cover;
            position: absolute;
        }
    </style>
</head>
<body class="main">
<div>
<div class="graph_left">
    <div>
        <div style="width:70%">
            <div>
                <canvas id="canvas" height="450" width="600"></canvas>
            </div>
        </div>
    </div>
    <div>
        <div class="humi">
            <div style="width:80%">
                <div>
                    <canvas id="canvas2" height="200" width="600"></canvas>
                </div>
            </div>
        </div>
    </div>
</div>
<div class="graph_img">

</div>
</div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>

    <script>
        var chartLabels = [];
        var chartData = [];
        $.getJSON("http://192.168.0.100:8383/selectOndoList", function(data){

            $.each(data, function(inx, obj){
                chartLabels.push(obj.nowDatetime);
                chartData.push(obj.temperature);
            });
            createChart();
            console.log("create Chart")
        });

        var lineChartData = {

            labels : chartLabels,

            datasets : [

                {

                    label : "온도 그래프",
                    fill: true,
                    backgroundColor : "rgba(255,167,167,0.2)",
                    borderColor : "rgb(255,167,167)",
                    data : chartData

                }
            ]
        }

        function createChart(){

            var ctx = document.getElementById("canvas").getContext("2d");
            LineChartDemo = Chart.Line(ctx,{

                data : lineChartData,

                options :{

                    scales : {

                        yAxes : [{

                            ticks :{

                                beginAtZero : true
                            }
                        }]
                    }
                }
            })
        }

    </script>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.js"></script>

    <script>
        var humidityLabels = [];
        var humidityData = [];


        $.getJSON("http://192.168.0.100:8383/selectOndoList", function(data){


            $.each(data, function(inx, obj){

                humidityLabels.push(obj.nowDatetime);
                humidityData.push(obj.humidity);

            });

            createHumidity();
            console.log("create Chart")

        });


        var lineHumidityData = {
            labels : humidityLabels,
            datasets : [

                {

                    label : "습도 그래프",
                    fill: true,
                    backgroundColor : "rgba(185,238,255,0.2)",
                    borderColor : "rgb(185,238,255)",
                    data : humidityData

                }
            ]
        }

        function createHumidity(){

            var ctx2 = document.getElementById("canvas2").getContext("2d");

            LineHumidityDemo = Chart.Line(ctx2,{

                data : lineHumidityData,

                options :{

                    scales : {

                        yAxes : [{

                            ticks :{

                                beginAtZero : true

                            }

                        }]

                    }

                }

            })

        }

    </script>

</body>
</html>
