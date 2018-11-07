<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding="utf-8" import="com.cernet.util.EncryptUtils" %>
<%@ include file="/common/taglibs.jsp"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<html>
	<head>
	   <%@ include file="/common/meta.jsp" %>
      <link href="styles/common.css" type="text/css" rel="stylesheet" />
		<title>追溯机构注册</title>
		<%@ include file="/common/title.jsp"%>
		<script type="text/javascript">
			var mainMenu = "retrospect";
			var subMenu = "${sessionScope.menuName}";
			function checkForm() {
				var ipv6Addr = document.getElementById("ipaddr").value;
				//alert(ipv6Addr);
				//alert(ipv6Addr.length);
				if('' == ipv6Addr && ipv6Addr.length == 0){
					alert("IPV6地址不能为空");
					return false;
				}
				return true;
			}
		</script>
	</head>
	<body>
		
		<div class="header">
			<img src="images/logo.jpg" class="logo"/><span class="getout"></span>
  			<div class="nav" >
  			
  				
  			</div>
  			
		</div>
		<div id="contentType_id" class="mess" style="text-align: center">
			
			<form id="searchForm" action="search.do" method="post" onsubmit="return checkForm()">
				<table>
					<tr>
						<td style="text-align:center;font-size:14pt;" colspan="2">追溯机构注册</td>
					</tr>
						<tr>
							<td class="alignright" style="width:50%;">机构帐号：</td>
							<td>
								<input type="text"  style="width:140px;"  id="instName" name="instName" class="text">
							</td>
						</tr>
						<tr>
							<td class="alignright" style="width:50%;">机构密码：</td>
							<td>
								 <input type="password"  style="width:140px;" id="instPasswd" name="instPasswd">
							</td>
						</tr>
						<tr>
							<td class="alignright" style="width:50%;">机构名称：</td>
							<td>
								 <input type="text" style="width:140px;" id="instAccount" name="instAccount">
							</td>
						</tr>
						<tr>
							<td class="alignright" style="width:50%;">机构法人代表：</td>
							<td>
								 <input type="text" style="width:140px;" id="legalRepre" name="legalRepre">
							</td>
						</tr>
						<tr>
							<td class="alignright" style="width:50%;">本账号管理员：</td>
							<td>
								 <input type="text" style="width:140px;" id="instAdmin" name="instAdmin">
							</td>
						</tr>
						<tr>
							<td class="alignright" style="width:50%;">
								<input id="dayButton_id" type="submit" class="button" value="确定"/>&nbsp;&nbsp;
							</td>
							<td>
								<input type="button" class="button" value="取消" onclick="location.href='loginOut.do'" />
							</td>
						</tr>
				</table>
			</form>
		</div>
		
	</body>
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</html>							