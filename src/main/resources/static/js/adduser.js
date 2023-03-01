//注册用户
$(function(){
    $("#addUserBtn").click(function () {
        //验证用户名密码
        var username = $("#username").val();
        var password = $("#password").val();
        var truename=$("#truename").val();
        var email=$("#email").val();

        //账户密码判空
        if(!username){
            alert("用户名为空，请输入。");
            return;
        }
        if(!password){
            alert("密码为空，请输入。");
            return;
        }
        if(!truename){
            alert("昵称为空，请输入。");
            return;
        }
        if(!email){
            alert("邮箱为空，请输入。");
            return;
        }
        var myreg = /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
        if(!myreg.test(email)) {
            alert('请输入有效的E_mail！');
            return;
        }
        //发送AJAX请求（客户端与服务器异步通信，局部刷新）
        //参数1，url
        //参数2，发送的表单
        //参数3，回调函数，处理响应,data参数为服务器发来的响应数据
        //参数4，字符串，代表响应数据的类型,"text","json"等等
        $.post("/addUser",{username:username,password:password,power:0,name:truename,email:email,subscribe:0},function (data){
            //处理响应数据
            if(data == "true"){
                //成功
                alert("注册成功");
                location.href="login.html";
            }else{
                //失败
                alert("输入信息有误，请重新注册。")
            }
        },"text");

    })


    $("#goback").click(function () {
        history.back(-1);
    })
});