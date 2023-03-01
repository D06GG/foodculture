//每个文章页面，用此js来获取文章基本信息，正文为静态内容
$(function () {
    var id = $("#aid").val();
    $.post("/getArticleById",{id:id},function (data) {
        var cover = document.getElementById("artcover");
        $("#arttitle").html(data.title);
        $("#arttime").html(data.time);
        $("#artauthor").html(data.author);
        $("#arttype").html(data.type);
        cover.src = ".." + data.cover;
    },"json")
})