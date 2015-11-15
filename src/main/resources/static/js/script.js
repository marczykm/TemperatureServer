$(document).ready(function(){
    var ctx = document.getElementById("myChart").getContext("2d");
    var options = {};
    var data;
    var myLineChart;

    document.getElementById("myChart").width = window.innerWidth-20;
    document.getElementById("myChart").height = window.innerHeight-20;

    $.get("/api/latest10", function(returnData){
        data = returnData;
        myLineChart = new Chart(ctx).Line(data, options);
    });

    setInterval(function(){
        $.get("/api/latest", function(returnData){
            var date = new Date(returnData.timestamp);
            var formattedDate = timeConverter(returnData.timestamp);
            myLineChart.addData([returnData.value], formattedDate);
            myLineChart.removeData();
            myLineChart.update();
        });
    }, 1000);

    function timeConverter(UNIX_timestamp){
      var a = new Date(UNIX_timestamp);
      var year = a.getFullYear();
      var month = a.getMonth()+1;
      if (month < 10) month = "0"+month;
      var date = a.getDate();
      if (date < 10) date = "0"+date;
      var hour = a.getHours();
      if (hour < 10) hour = "0"+hour;
      var min = a.getMinutes();
      if (min < 10) min = "0"+min;
      var sec = a.getSeconds();
      if (sec < 10) sec = "0"+sec;
      var time = year + '-' + month + '-' + date + ' ' + hour + ':' + min + ':' + sec ;
      return time;
    }


});