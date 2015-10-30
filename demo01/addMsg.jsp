<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
  </head>
  <script type="text/javascript" src="js/ajax.js"></script>
  <script type="text/javascript" src="js/prototype-1.6.0.3.js"></script>
  <script type="text/javascript">
  	function check_name(){
  		$('name_msg').innerHTML='';
  		/*
			检查昵称是否为空，
			如果为空，返回false，否则，
			返回true,
		*/
		if($F('name').strip().length == 0){
			$('name_msg').innerHTML = '昵称不能为空';
			return false;
		}
				/*
					检查用户名是否被占用，如果占用
					了，返回false,否则返回true。
				*/
				var flag = false;
				var xhr = getXhr();
				xhr.open('get','check_name.do?name='+$F('name'),false);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4 && 
					xhr.status == 200){
						var txt = xhr.responseText;
						if(txt == 'ok'){
							//$('name_msg').innerHTML = '';
							flag = true;
						}else{
							//$('name_msg').innerHTML = '昵称不能为空';
							flag = false;
						}
					}
				};
				xhr.send(null);
				return flag;
  	}
  	function check_email(){
  		$('email_msg').innerHTML='';
  		/*
			检查邮箱是否为空，
			如果为空，返回false，否则，
			返回true,
		*/
		if($F('email').strip().length == 0){
			$('email_msg').innerHTML = '邮箱不能为空';
			return false;
		}
				/*
					检查用户名是否被占用，如果占用
					了，返回false,否则返回true。
				*/
				var flag = false;
				var xhr = getXhr();
				xhr.open('get','check_email.do?email='+$F('email'),false);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4 && xhr.status == 200){
						var txt = xhr.responseText;
						if(txt == 'ok'){
							//$('email_msg').innerHTML = '';
							flag = true;
						}else{
							//$('email_msg').innerHTML = '邮箱不能为空';
							flag = false;
						}
					}
				};
				xhr.send(null);
				return flag;
  	}
  	  	function check_subject(){
  		$('subject_msg').innerHTML='';
  		/*
			检查邮箱是否为空，
			如果为空，返回false，否则，
			返回true,
		*/
		if($F('subject').strip().length == 0){
			$('subject_msg').innerHTML = '主题不能为空';
			return false;
		}
				/*
					检查用户名是否被占用，如果占用
					了，返回false,否则返回true。
				*/
				var flag = false;
				var xhr = getXhr();
				xhr.open('get','check_subject.do?subject='+$F('subject'),false);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4 && 
					xhr.status == 200){
						var txt = xhr.responseText;
						if(txt == 'ok'){
							//$('subject_msg').innerHTML = '';
							flag = true;
						}else{
							//$('subject_msg').innerHTML = '主题不能为空';
							flag = false;
						}
					}
				};
				xhr.send(null);
				return flag;
  	}
  	function check_message(){
  		$('email_msg').innerHTML='';
  		/*
			检查信息是否为空，
			如果为空，返回false，否则，
			返回true,
		*/
		if($F('message').strip().length == 0){
			$('message_msg').innerHTML = '信息不能为空';
			return false;
		}
				/*
					检查信息是否被占用，如果占用
					了，返回false,否则返回true。
				*/
				var flag = false;
				var xhr = getXhr();
				xhr.open('get','check_message.do?message='+$F('message'),false);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4 && xhr.status == 200){
						var txt = xhr.responseText;
						if(txt == 'ok'){
							$('message_msg').innerHTML = '';
							flag = true;
						}else{
							//$('message_msg').innerHTML = '信息不能为空';
							flag = false;
						}
					}
				};
				xhr.send(null);
				return flag;
  	}
  	function check_number(){
				$('number_msg').innerHTML = '';
				/*
					检查验证码是否为空，
					如果为空，返回false,否则，
					返回true。 
				*/
				if($F('number').strip().length == 0){
					$('number_msg').innerHTML = 
					'验证码不能为空';
					return false;
				}
				/*
					检查验证码是否正确，如果不正确
					，返回false,否则返回true。
				*/
				var flag = false;
				var xhr = getXhr();
				xhr.open('get','check_number.do?number='+ $F('number'),false);
				xhr.onreadystatechange=function(){
					if(xhr.readyState == 4 && xhr.status == 200){
						var txt = xhr.responseText;
						if(txt == 'ok'){
							//$('number_msg').innerHTML = '';
							flag = true;
						}else{
							$('number_msg').innerHTML = '验证码错误';
							flag = false;
						}
					}
				};
				xhr.send(null);
				return flag;
			}
  	function beforeSubmit(){
  		var flag = check_name()&&check_email()&&check_subject()&&check_message()&&check_number();
  		return flag;
  	}
  </script>
  <body>
    <h2>添加留言消息</h2>
    <form action="add.do" method="post" onsubmit="return beforeSubmit();">
        name:<input type="text" class="name" name="name" id="name" onblur="check_name();"/>
        <span id="name_msg" style="color:red;"></span>
        <br/>
		email:<input type="text" class="email" name="email" id="email" onblur="check_email();"/>
		<span id="email_msg" style="color:red;"></span>
		<br/>
	    subject:<input type="text" class="subject" name="subject" id="subject" onblur="check_subject();"/>
	    <span id="subject_msg" style="color:red;"></span>
	    <br/>
		message:<input type="text" class="message" name="message" id="message" onblur="check_message();"/>
		<span id="message_msg" style="color:red;"></span>
		<br/>
		验证码:<input name="number" id="number" onblur="check_number();"/>
		     <span id="number_msg" style="color:red;"></span>
		     <br/>
		    <img  id="img1" src="checkcode" border="1"/>
	    	 	<a href="javascript:;" onclick="document.getElementById('img1').src='checkcode?' + Math.random();">
	    	 	看不清，换一个</a>
    	<p><input type="submit" class="button" value="submit" id="submit"/></p>
    </form>

  </body>
</html>
