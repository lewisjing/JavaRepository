<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<ul>
        <li class="user_main_text">验证码： </li>
        <li class="user_main_input">
	        <img style="width: 100px; height: 100px;" id="img" src="/test" onclick="b()" alt="">
	        <input type="text" name="yanzheng"/>
        </li>  
	</ul>      
</body>
</html>
<script type="text/javascript">
	function b() {
	    document.getElementById("img").src="/test";
	}
</script>