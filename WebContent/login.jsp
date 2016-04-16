<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户登录</title>
<link rel="stylesheet" type="text/css" href="images/styles.css">
<script type = "text/javascript" src = "jquery-2.2.0.min.js">
function login(form){
	if(form.username.value == ""){
	alert("用户不能为空哦！！！");
	return false;
}
if(form.password.value == ""){
	alert("密码不能为空！！！");
	return false;
}
}
</script>
</head>
<body>
	  <div align="center">
		  	<div class="div1">
		  		<div class="top">用户登录</div>
		  		<div class="bottom">
					<div class="div2">
				  		<ul>
				  			<li><a href="reg.jsp">用户注册</a></li>
				  			<li><a href="login.jsp">用户登录</a></li>
				  			<li><a href="message.jsp">当前用户</a></li>
				  			<li><a href="ExitServlet">用户退出</a></li>
				  		</ul>
				  	</div>
				  	 <div class="div3"> 
					    <form action="LoginServlet" method="post" onSubmit="return login(this);">
						    <table align="center" width="300" border="0" class="tb1">
						    	<tr>
						    		<td align="right">用户名：</td>
						    		<td>
						    			<input type="text" name="username">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td align="right">密 码：</td>
						    		<td>
						    			<input type="password" name="password">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td colspan="2" align="center" height="50">
						    			<input type="submit" value="登 录">
						    			<input type="reset" value="重 置">
						    		</td>
						    	</tr>
						    </table>
						</form>
				  	 </div>
				</div>
		  	</div>
	  </div>
  </body>
</html>
