//用户登录
$(function(){
    $("#loginbtn").click(function () {
        //验证用户名密码
        var username = $("#uname").val();
        var password = $("#upswd").val();
        var userpower = document.getElementById("userpower").checked;
        //账户密码判空
        if(!username){
            alert(userpower);
            return;
        }
        if(!password){
            alert("密码为空，请输入。");
            return;
        }
        //发送AJAX请求（客户端与服务器异步通信，局部刷新）
        //参数1，url
        //参数2，发送的表单
        //参数3，回调函数，处理响应,data参数为服务器发来的响应数据
        //参数4，字符串，代表响应数据的类型,"text","json"等等
        if(userpower == false){
            $.post("/login",{uname:username,pswd:password},function (data){
                //处理响应数据
                if(data == "true"){
                    //成功
                    location.href="index2.html";
                }else{
                    //失败
                    alert("用户名或密码错误，请重新登陆。")
                }
            },"text");
        }else if(userpower == true){
            $.post("/login2",{uname:username,pswd:password},function (data){
                //处理响应数据
                if(data == "true"){
                    //成功
                    location.href="manage.html";
                }else{
                    //失败
                    alert("用户名或密码错误，或该用户没有管理员权限，请重新登陆。")
                }
            },"text");
        }
    })

});
