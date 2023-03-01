$(function () {
    $.post("/getArticleNum",null,function (data) {
        $("#artnum").html(data);
    },"text")
    $.post("/getUserNum",null,function (data1) {
        $("#usernum").html(data1);
    },"text")
    $.post("/getSubNum",null,function (data2) {
        $("#subnum").html(data2);
    },"text")
})