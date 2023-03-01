//在单页使用搜索功能
$(function () {
    $("#pagecontrol").hide();

    $("#search").click(function () {
        $("#pagecontrol").show();

        $("#searcharea div:gt(0)").remove();
        $("#titlearea").remove();

        $("<div class='blog-custom-build' id='searchresult'></div>").appendTo($("#searcharea"));

        var text = $("#searchtext").val();
        var pageNum = $("#pageNum").val();
        var pageSize = $("#pageSize").val();
        $.post("/searchArticles", {text: text,pageNum: pageNum,pageSize: pageSize}, function (data) {
            //判空
            if (data.size > 0) {
                //查询到数据
                //分页信息
                $('#curpage').html(data.pageNum);
                $("#pages").html(data.pages);
                //删除原有的查询结果
                $("#searchresult div:gt(0)").remove();
                //查询结果

                for (var i = 0; i < data.list.length; i++) {
                    var art = data.list[i];

                    var div1 = $("<div class='blog-box wow fadeIn'></div>");
                    var div2 = $("<div class='post-media'></div>");
                    var a1 = $("<a href='"+ art.local +"'></a>");
                    var img = $("<img class='img-fluid' src='" + art.cover + "'>");
                    var div3 = $("<div class='hovereffect'><span></span></div>");

                    var div4 = $("<div class='blog-meta big-meta text-center'></div>");
                    var h4 = $("<h4></h4>");
                    var a2 = $("<a href='"+ art.local +"'></a>");
                    var small11 = $("<small></small>");
                    var a11 = $("<a></a>")
                    var small22 = $("<small></small>");
                    var a22 = $("<a></a>")


                    //a1.href = art.local;
                    img.appendTo(a1);
                    div3.appendTo(a1);
                    a1.appendTo(div2);

                    //a2.href = art.local;
                    a2.html(art.title);
                    a2.appendTo(h4);

                    a11.html(art.time);
                    a11.appendTo(small11);
                    a22.html(art.author);
                    a22.appendTo(small22);
                    h4.appendTo(div4);
                    $("<p></p>").html(art.info).appendTo(div4);
                    small11.appendTo(div4);
                    small22.appendTo(div4);

                    div2.appendTo(div1);
                    div4.appendTo(div1);

                    div1.appendTo("#searchresult");
                    $("<hr class='invis'>").appendTo("#searchresult");
                }
            }else {
                $("#searchresult div:gt(0)").remove();
                $("<div>没有搜索到该内容</div>").appendTo("#searchresult")
            }
        }, "json")
    })
    //上一页
    $("#prepage").click(function () {
        //获取当前页数
        var pageNum = $("#pageNum").val();
        if(pageNum <= 1){
            alert("没有上一页了！")
        }else{
            $("#pageNum").val(pageNum*1 - 1);
            //再查询一次
            $("#search").click();
        }
    })
    //下一页
    $("#nextpage").click(function () {
        var pageNum=$("#pageNum").val();
        var pages=$("#pages").html();
        if(pageNum >= pages){
            alert("没有下一页了！")
        }else{
            $("#pageNum").val(pageNum*1  + 1);
            $("#search").click();
        }
    })
})
