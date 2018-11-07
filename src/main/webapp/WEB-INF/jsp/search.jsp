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
		<title>追溯查询</title>
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
		<%@include file="/WEB-INF/jsp/common/header.jsp"%>
		<div id="contentType_id" class="mess" style="text-align: center">
			
			<form id="searchForm" action="search.do" method="post" onsubmit="return checkForm()">
				请填写IP地址：
				<input type="text" size="50" name="ipaddr" id="ipaddr" value="" />
				<c:if test="${usertype == 0}">
					<input id="dayButton_id" type="submit" class="button" value="查询"/>&nbsp;&nbsp;
					<input id="dayButton_id" type="button" class="button" value="同步数据" onclick="javascript:location.href='synchronous.do'"/>
				</c:if>
				<c:if test="${usertype == 1}">
					<input id="dayButton_id" type="submit" class="button" value="申请追溯"/>
				</c:if>
				例如：2001:da8:24d:0:0257:7d40:744e:eba0   
				<%--<input id="dayButton_id" type="button" class="button" value="退出" onclick="javascript:location.href='loginOut.do'"/> --%>
			</form>
			<c:if test="${null != messString && messString != ''}"><p style="color:red;">${messString}<p></c:if>
			<table>
				<c:if test="${user != null}">
					<tr>
						<td class="alignright" style="width:50%;">登录类型：</td>
						<td>
							<c:if test="${loginType == 'in'}">域内登录</c:if>
							<c:if test="${loginType == 'out'}">域间登录</c:if>
						</td>
					</tr>
					<tr><td class="alignright" style="width:50%;">NID所属组织：</td><td>${nidGroupName}</td></tr>
					<c:if test="${loginType == 'out'}">
						<tr><td class="alignright" style="width:50%;">IP所属组织：</td><td>${ipGroupName}</td></tr>
					</c:if>
					<tr>
						<td class="alignright" style="width:50%;">登录方式：</td>
						<td>
							<c:if test="${user.clientType != '1' && user.clientType != '2'}">NID</c:if>
							<c:if test="${user.clientType =='1'}">学号</c:if>
							<c:if test="${user.clientType =='2'}">手机号</c:if>
						</td>
					</tr>
					<tr><td class="alignright" style="width:50%;">NID：</td><td>${lastNid}</td></tr>
					<tr><td class="alignright" style="width:50%;">DID：</td><td>${user.userName}</td></tr>
					<tr><td class="alignright" style="width:50%;">身份证：</td><td>${user.identityId}</td></tr>
					<c:if test="${user.clientType =='1'}">
						<tr><td class="alignright" style="width:50%;">学号：</td><td>${user.clientName}</td></tr>
						<tr><td class="alignright" style="width:50%;">手机号：</td><td>${user.mobile}</td></tr>
					</c:if>
					<c:if test="${user.clientType != '1'}">
						<tr><td class="alignright" style="width:50%;">手机号：</td><td>${user.mobile}</td></tr>
					</c:if>
					<tr><td class="alignright" style="width:50%;">姓名：</td><td>${user.didName}</td></tr>
					<tr><td class="alignright" style="width:50%;">籍贯：</td><td>${user.didAddr}</td></tr>
					<tr><td class="alignright" style="width:50%;">入网时间：</td><td>${aidTimeString}</td></tr>
					<c:if test="${flag == '2'}">
						<tr><td class="alignright" style="width:50%;">MAC地址：</td><td>${user.macAddr}</td></tr>
					</c:if>
					<c:if test="${user.apName == ''}">
						<c:if test="${user.port == 0}">
							<tr><td class="alignright" style="width:50%;">Port：</td><td></td></tr>
						</c:if>
						<c:if test="${user.port != 0}">
							<tr><td class="alignright" style="width:50%;">Port：</td><td>${user.port}</td></tr>
						</c:if>
					</c:if>
					<c:if test="${user.apName != ''}">
						<c:if test="${user.apName != 0}">
						    <tr><td class="alignright" style="width:50%;">apName：</td><td>${user.apName}</td></tr>
					   </c:if>
					</c:if>
					<c:if test="${user.apName == ''}">
					   <tr><td class="alignright" style="width:50%;">交换机IP：
					   </td><td>${user.ipAddr}</td></tr>
				    </c:if>
				    <c:if test="${user.apName == ''}">
				     <tr><td class="alignright" style="width:50%;">接入类型：</td><td>有线接入</td></tr>
				    </c:if>
				      <c:if test="${user.apName != ''}">
				     <tr><td class="alignright" style="width:50%;">接入类型：</td><td>无线接入</td></tr>
				    </c:if>
				</c:if>
			</table>
			
			<%--  <% String aa = EncryptUtils.getIdeaEncrypt("80002a110804ade4","6b48c2bd883461dc866e64bc5b40650b"); %>
			 <% String bb = EncryptUtils.getIdeaDecrypt("80002a110804ade4","6b48c2bd883461dc866e64bc5b40650b"); %>
			<input type="text" size="50"  value="<%=aa%>" /> 
			<input type="text" size="50"  value="<%=bb%>" /> --%>
			
		</div>
		<div class="main">
		</div>
	</body>
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</html>							