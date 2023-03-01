//管理员修改文章信息
$(function () {


    var idstr=window.location.search.toString();
    var arr=idstr.split("=");
    var id=arr[1]*1;

    $.post("/getArticleById",{id:id},function (data) {
        $("#artid").val(data.id);
        $("#title").val(data.title);
        $("#info").val(data.info);
        $("#author").val(data.author);
        $("#local").val(data.local);
        $("#cover").val(data.cover);
        $("#time").val(data.time);
        $("#tag").val(data.tag);
        $("#type").val(data.type);
    },"json")

    $("#submit").click(function () {
        $.post("/updateArticle2",$("[name]"),function (data1) {
            if(data1 == "true"){
                alert("修改成功");
            }else {
                alert("修改失败");
            }
        },"text")
    })

    $("#goback").click(function () {
        history.back(-1);
    })
})