<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>系统登录</title>
<script language="javascript" type="text/javascript" src="<%=request.getContextPath()%>/scripts/jquery-1.3.2.js"></script>
<link href="styles/login.css" type="text/css" rel="stylesheet" />

<script type="text/javascript">
	function login(){
		$("#error").empty();
		$("#username").val($.trim($("#username").val()));
		$("#passwd").val($.trim($("#passwd").val()));
		var userName =$("#username").val();
		var passWord = $("#passwd").val();
		var error = "";
		var flag = true;
		if(userName==""){
			$("#error").append("用户名不能为空  ");
			flag = false;
		}
		if(passWord==""){
			$("#error").append("密码不能为空");
			flag = false;
		}
		return flag;
		
	}
</script>
</head>
<body>
<div class="login_title position"><img src="images/login_title.jpg"></div>
<div class="login_main position">
<div  class="login_box">
<form id="loginForm" action="login.do" method="post" onsubmit="return login();">
  <table>
    <tr>
      <td class="alignright">用户名：</td>
      <td>
        <input type="text" id="username" name="username" class="text"></td>
    </tr>
    <tr>
      <td class="alignright">密码：</td>
      <td>
        <input type="password" class="text" id="passwd" name="passwd"></td>
    </tr>
    <tr>
      <td></td>
      <td class="red" id="error"><s:property value="message"/></td>
    </tr>
    <!--<tr>
      <td></td>
      <td><input type="checkbox">
        记住用户名密码</td>
    </tr>-->
    <tr>
      <td></td>
      <td><input type="submit" class="button" value="确定" ></td>
    </tr>
  </table>
</form>
</div>
</div>
</body>
</html>
