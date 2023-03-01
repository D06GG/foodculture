//管理员新增文章
$(function () {
    var root = 0;
    $.post("/getUser",null,function (data) {
        if(data.power == 1){
            root=1;
        }
        if(root == 1){
            $("#submit").click(function () {
                var title = $("#title").val();
                var info = $("#info").val();
                var author = $("#author").val();
                var time = $("#time").val();
                var tag = $("#tag").val();
                var type = $("#type").val();
                if(!title){
                    alert("标题为空，请输入。");
                    return;
                }
                if(!info){
                    alert("简介为空，请输入。");
                    return;
                }
                if(!author){
                    alert("作者为空，请输入。");
                    return;
                }
                $.post("/addArticle",$("[name]"),function (data) {
                    //处理响应数据
                    if(data == "true"){
                        //成功
                        alert("添加成功");
                        location.href="articlemanage.html";
                    }else{
                        //失败
                        alert("添加失败，请重新添加。")
                    }
                },"text")
            })

            $("#goback").click(function () {
                history.back(-1);
            })
        }else{
            alert("不具备管理员权限，无法访问。")
            location.href = "/index.html";
        }
    })

})