<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="/public/backpublic.jsp" %>
<script src="//cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
<title>后台用户登录</title>
<script>
$(function(){
	
$("#username").val($.cookie("username"));
$("#password").val($.cookie("password"));	
	
$('#login').dialog({
   title:"登录后台",
   width:300,
   height:180,
   modal:true,
   buttons:"#btn",
});


//验证
$('#username').validatebox({
  required:true,
  missingMessage:"请输入管理员账号",
});


$('#password').validatebox({
  required:true,
  validType:'length[6,30]',
  missingMessage:"请输入管理员密码",
  });
  
    if(!$('#username').validatebox('isValid')){
    $('#username').focus();
    }else if(!$('#password').validatebox('isValid')){
    $('#password').focus();
    }
    
    
  $('#btn a').click(function(){
    if(!$('#username').validatebox('isValid')){
    $('#username').focus();
    }else if(!$('#password').validatebox('isValid')){
    $('#password').focus();
    }else{
    $.ajax({
      url:'studentLogin',
      type:'post',
      data:{
      ssn:$('#username').val(),
      password:$('#password').val(),
      },
      beforeSend:function(){
         $.messager.progress({
         text:"正在登录中.....",
         });
      },
      success:function(response){
        $.messager.progress('close');
      
        if(response){
        	 $.cookie('username',
        			 $('#username').val(), {
 						expires : 7
 					})
 					&& $.cookie('password',$('#password').val(), {
 						expires : 7
 					}) 
             location.href="usermessage";
        }else if(!response){
                alert("你的管理员账号为空，或密码不正确，请确认")
        }
      },
    });
    }
  });
});

</script>
<style>
  #login {
   padding:6px 0 0 0;
   }
   p{
   height:22px;
   line-height: 22px;
   padding:4px 0 0 25px;
   }
   .textbox{
   height:22px;
   padding:0 2px;
   }
   #btn{
   text-align: center;
   }
   .easyui-linkbutton{
    padding:0 10px;
   }
</style>
</head>
<body>
	<div id="login">
	  <p>
	   学生账号：<input type="text" id="username"  class="textbox">  
	  </p>	  
	  <p>
	   学生密码：<input type="password" id="password" class="textbox">  
	  </p>
	  
	</div> 
      <div id="btn">
       <a href="#" class="easyui-linkbutton">登录</a>
      </div>

</body>
</html>