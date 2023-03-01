$(document).ready(function () {
    var lineChart = $('#line-chart');

    var m = new Array(12);
    for(var i = 0 ; i<12;i++){
        m[i]=0;
    }
    $.post("/getPatientNumPerYear",null,function (data1) {
        for(var i = 0;i<data1.length;i++){
            var count=data1[i];
            for(var j=0;j<12;j++){
                var time=count.time+"";
                if( time.charAt(time.length-1) == (j).toString() ){
                    m[j-1]=count.num;
                    break;
                }
            }
        }
        if (lineChart.length > 0) {
            new Chart(lineChart, {
                type: 'line',
                data: {
                    labels: ["一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月", "十月", "十一月", "十二月"],
                    datasets: [{
                        label: '入院人数',
                        data: [m[0], m[1], m[2], m[3], m[4], m[5], m[6], m[7], m[8], m[9], m[10], m[12]],
                        backgroundColor: 'rgba(66, 165, 245, 0.5)',
                        borderColor: '#2196F3',
                        borderWidth: 1
                    }]
                },
                options: {
                    legend: {
                        display: false
                    },
                    scales: {
                        yAxes: [{
                            ticks: {
                                beginAtZero: true
                            }
                        }]
                    }
                }
            });
        }
    },"json")

});
