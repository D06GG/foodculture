$(function () {
    $.post("/isLogin", null, function (data) {
        if (data == "true") {
            $.post("/getUser",null,function (data2) {
                $("#userdecollect").html(data2.name+"的收藏夹");
            },"json")
            $.post("/getCollects", null, function (data1) {
                //判空
                if (data1.size>0) {
                    //查询到数据
                    //查询结果
                    for (var i = 0; i < data1.list.length; i++) {
                        var art = data1.list[i];
                        var span = $("<span></span>")
                        //文章标题
                        var a1 = $("<a href='"+art.local+"'>" + art.title + "</a>")
                        //删除按钮
                        var a3 = $("<a style='float: right' href='/deleteCollect?aid=" + art.id + "'>取消收藏</a>")
                        a1.appendTo(span);
                        a3.appendTo(span);
                        span.appendTo("#collects");
                        $("<hr>").appendTo("#collects");
                    }
                } else {
                    var aNO = $("<a href='javascript:void(0)'>您暂未收藏文章</a>")
                    aNO.appendTo("#collects");
                    $("<hr>").appendTo("#collects");
                }
            }, "json")
        } else {
            alert("用户未登录，请登陆后查看。");
            //var int=self.setInterval(function(){  // 这个方法是说在延迟两秒后执行大括号里的方法
            location.href = "/login.html";
            //},2000)                                  //这里2000代表两秒
        }
    }, "text")
})
