//管理员修改用户信息
$(function () {


    var idstr=window.location.search.toString();
    var arr=idstr.split("=");
    var id=arr[1]*1;

    $.post("/getUserById",{id:id},function (data) {
        $("#userid").val(data.id);
        $("#username").val(data.username);
        $("#userpswd").val(data.password);
        $("#userdename").val(data.name);
        $("#useremail").val(data.email);
        $("#usersub").val(data.subscribe);
        $("#userpower").val(data.power);
    },"json")

    $("#submit").click(function () {
        $.post("/updateUser2",$("[name]"),function (data1) {
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