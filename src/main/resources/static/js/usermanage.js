//管理员获取用户列表
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
                $.post("/getAllUser",{pageNum: pageNum,pageSize: pageSize},function (data1) {
                    if(data1.size>0){
                        //分页信息
                        $("#total").html(data1.total);
                        $("#pages").html(data1.pages);
                        $("#curpage").html(data1.pageNum);
                        //删除原有表格数据
                        $("#resultTable tr:gt(0)").remove();
                        //动态生成表格数据
                        for(var i = 0;i<data1.list.length;i++){
                            var u = data1.list[i];
                            var url1="/updateUser1?id=" + u.id;
                            var url2="/deleteUser?id=" + u.id;

                            var row = $("<tr></tr>");
                            $("<td></td>").html(u.id).appendTo(row);
                            $("<td></td>").html(u.username).appendTo(row);
                            $("<td></td>").html(u.name).appendTo(row);
                            $("<td></td>").html(u.email).appendTo(row);

                            if(u.subscribe==0){
                                $("<td></td>").html("未订阅").appendTo(row);
                            }else {
                                $("<td></td>").html("订阅").appendTo(row);
                            }

                            if(u.power ==1){
                                $("<td></td>").html("管理员").appendTo(row);
                            }else{
                                $("<td></td>").html("普通用户").appendTo(row);
                            }

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