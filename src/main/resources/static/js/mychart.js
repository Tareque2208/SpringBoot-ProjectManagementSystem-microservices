var jsonChartData = decodeHtml(chartData);
var jsonChartArray = JSON.parse(jsonChartData);

var valueData = [];
var labelData = [];

for(var i=0; i<jsonChartArray.length;i++){
    valueData[i] = jsonChartArray[i].value;
    labelData[i] = jsonChartArray[i].label;
}

new Chart(document.getElementById("myPieChart"), {
  type: 'pie',
  data: {
        labels: labelData,
        datasets: [{
            data: valueData,
            backgroundColor: ["#3e95cd","#3a95ed","#3eba9f"],
            borderColor: 'rgb(255, 99, 132)'
        }]
    },
	options:{}
});

//[{"value": 1, "label": "COMPLETED"},{"value": 2, "label": "INPROGRESS"},{"value": 1, "label": "NOTSTARTED"}]
function decodeHtml(html){
    var txt = document.createElement("textarea");
    txt.innerHTML = html;
    return txt.value;
}

