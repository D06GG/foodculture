//管理员获取文章列表
$("#search").hide();
$(function () {
    var root = 0;
    $.post("/getUser",null,function (data) {
        if(data.power == 1){
            root=1;
        }
        if(root==1){
            $("#search").click(function () {
                var pageNum = $("#pageNum").val();
                var pageSize = $("#pageSize").val();
                $.post("/getAllArticles",{pageNum: pageNum,pageSize: pageSize},function (data1) {
                    if(data1.size>0){
                        //分页信息
                        $("#total").html(data1.total);
                        $("#pages").html(data1.pages);
                        $("#curpage").html(data1.pageNum);
                        //删除原有表格数据
                        $("#resultTable tr:gt(0)").remove();
                        //动态生成表格数据
                        for(var i = 0;i<data1.list.length;i++){
                            var a = data1.list[i];
                            var url1="/updateArticle1?id="+a.id;
                            var url2="/deleteArticle?id="+a.id;

                            var row = $("<tr></tr>");
                            $("<td></td>").html(a.id).appendTo(row);
                            $("<td></td>").html(a.title).appendTo(row);
                            $("<td></td>").html(a.info).appendTo(row);
                            $("<td></td>").html(a.author).appendTo(row);

                            $("<td></td>").html(a.local).appendTo(row);
                            $("<td></td>").html(a.cover).appendTo(row);
                            $("<td></td>").html(a.time).appendTo(row);
                            $("<td></td>").html(a.collectnum).appendTo(row);
                            $("<td></td>").html(a.tag).appendTo(row);
                            $("<td></td>").html(a.type).appendTo(row);

                            $("<td></td>").html("<a href="+url1+">修改</a>&nbsp;|&nbsp;<a href="+url2+">删除</a>").appendTo(row);
                            row.appendTo("#resultTable");
                        }
                    }
                },"json")
            })
            $("#search").click();//显示查询结果
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
        }else{
            alert("不具备管理员权限，无法访问。")
            location.href = "/index.html";
        }
    },"json")
})