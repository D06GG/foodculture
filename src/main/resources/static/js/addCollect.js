//用户添加收藏
$(function () {
    $("#addcollect").click(function () {
        $.post("/isLogin",null,function (data) {
            if(data == "true"){
                var aid = $("#aid").val();
                $.post("/isCollected",{aid:aid},function (data1) {
                    if(data1 == "true"){
                        alert("已收藏，请勿重复收藏。")
                    }else{
                        $.post("/addCollect",{aid:aid},function (data2) {
                            if (data2 == "true"){
                                alert("收藏成功！")
                            } else {
                                alert("收藏失败，请稍后再试。")
                            }
                        },"text")
                    }
                },"text")
            }else {
                alert("用户未登录，请登陆后再收藏。");
                location.href="/login.html";
            }
        },"text")
    })
})