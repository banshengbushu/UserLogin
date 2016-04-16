<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>用户注册</title>
<link rel="stylesheet" type="text/css" href="images/styles.css">
<script type = "text/javascript" src = "jquery-2.2.0.min.js">
function reg(form){
	if(form.username.value == ""){
		alert("用户不能为空！");
		return false;
	}
	if(form.password.value == ""){
		alert("密码不能为空！");
		return false;
	}
	if(form.repassword.value == ""){
		alert("确认密码不能为空！");
		return false;
	}
	if(form.password.value != form.repassword.value){
		alert("两次密码输入不一致！");
		return false;
	}
	if(form.tel.value == ""){
		alert("联系电话不能为空！");
		return false;
	}
	if(form.email.value == ""){
		alert("电子邮箱不能为空！");
		return false;
	}
}
function change(){
	var photo = document.getElementById("photo");
	var photoImg = document.getElementById("photoImg");
	photoImg.src = photo.value;
}

</script>
</head>
<div align="center">
		  	<div class="div1">
		  		<div class="top">用户注册</div>
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
					    <form action="RegServlet" method="post" onsubmit="return reg(this);">
						    <table align="center" width="450" border="0">
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
						    		<td align="right">确认密码：</td>
						    		<td>
						    			<input type="password" name="repassword">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td align="right">性 别：</td>
						    		<td>
						    			<input type="radio" name="sex" value="男" checked="checked">男
						    			<input type="radio" name="sex" value="女">女
						    		</td>
						    	</tr>
						    	<tr>
						    		<td align="right">头 像：</td>
						    		<td>
						    			<select name="photo" id="photo" onchange="change();">
						    				<option value="images/boy.png" selected="selected">头像boy</option>
						    				<option value="images/girl.png">头像girl</option>
						    			</select>
						    			<img id="photoImg" src="images/boy.png">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td align="right">联系电话：</td>
						    		<td>
						    			<input type="text" name="tel">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td align="right">电子邮箱：</td>
						    		<td>
						    			<input type="text" name="email">
						    		</td>
						    	</tr>
						    	<tr>
						    		<td colspan="2" align="center">
						    			<input type="submit" value="注 册">
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
