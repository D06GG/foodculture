//主页及单页右侧显示推荐内容
$(function () {
    $.post("/getHot3",null,function (data) {
        if(data.size>0){
            for(var i = 0 ; i <data.list.length;i++){
                var art = data.list[i];
                var a = $("<a href='"+art.local+"' class='list-group-item list-group-item-action flex-column align-items-start'></a>");
                var div = $("<div class='w-100 justify-content-between'></div>");
                var h5 = $("<h5 class='mb-1'>"+art.title+"</h5>");
                var small = $("<small>"+art.time+"</small>");
                h5.appendTo(div);
                small.appendTo(div);
                div.appendTo(a);
                a.appendTo($("#hotart"));
            }
        }
    },"json")
    $.post("/getNew3",null,function (data1) {
        if(data1.size>0){
            for(var i = 0 ; i <data1.list.length;i++){
                var art = data1.list[i];
                var a = $("<a href='"+art.local+"' class='list-group-item list-group-item-action flex-column align-items-start'></a>");
                var div = $("<div class='w-100 justify-content-between'></div>");
                var h5 = $("<h5 class='mb-1'>"+art.title+"</h5>");
                var small = $("<small>"+art.time+"</small>");
                h5.appendTo(div);
                small.appendTo(div);
                div.appendTo(a);
                a.appendTo($("#newart"));
            }
        }
    },"json")
    $.post("/getTagsHot",null,function (data2) {
        if(data2.size>0){
            var ul = $("<ul></ul>")
            for(var i = 0 ; i<data2.list.length;i++){
                var tag = data2.list[i];
                if("" != tag.text){
                    $("<li><a href='javascript:void(0)' onclick='searchtag(this)'>"+ tag.text +"</a></li>").appendTo(ul);
                }
            }
            ul.appendTo($("#hottags"));
        }
    },"json")



    // $("#tag0").click(function () {
    //     var tag = $("#tag0").html();
    //     alert(tag);
    //     // $("#searchtext").val(tag);
    //     // $("#search").click();
    // })
    $("#Hottag").click(function () {
        var tag = $("#Hottag").html();
        tag = tag.substring(3,tag.length-1);
        $("#searchtext").val(tag);
        $("#search").click();
    })
})