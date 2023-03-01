//右侧的订阅功能
$(function () {
    $("#subbtn").click(function () {
        $.post("/isLogin",null,function (data) {
            if(data == "true"){
                location.reload();
                $.post("/isSubscribe",null,function (data1) {
                    if(data1 == "false"){
                        $.post("/subscribe",null,function (data2) {
                            if(data2 == "true"){
                                alert("订阅成功！");
                            }else {
                                alert("订阅失败，请稍后再试。");
                            }
                        },"text")
                    }else {
                        if(confirm("您当前已订阅，是否取消订阅？")){
                            $.post("/nosubscribe",null,function (data3) {
                                if(data3=="true"){
                                    alert("取消订阅成功！");
                                }else {
                                    alert("取消订阅失败，请稍后再试。");
                                }
                            },"text")
                        }
                    }
                },"text")
            }else {
                alert("用户未登录，请登陆后订阅。");
                location.href = "/login.html";
            }
        },"text")
    })
})