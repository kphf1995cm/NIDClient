<!DOCTYPE html PUBLIC 
	"-//W3C//DTD XHTML 1.1 Transitional//EN"
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@ page pageEncoding="utf-8"%>
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
			
		</script>
	</head>
	<body>
		<%@include file="/WEB-INF/jsp/common/header.jsp"%>
		<%@include file="/common/messages.jsp"%>
		
		<div class="main">
			<table class="main_table">
				<tr>
					<td class="alignright" style="width:50%">登录类型：</td>
					<c:if test="${traceResult.traceType == 'in'}">
						<td>域内登录</td>
					</c:if>
					<c:if test="${traceResult.traceType == 'out'}">
						<td>域间登录</td>
					</c:if>
					<c:if test="${traceResult.traceType == null || traceResult.traceType == ''}">
						<td></td>
					</c:if>
				</tr>
				<tr>
					<td class="alignright">NID所属组织：</td>
					<td>${traceResult.nidGroupName}</td>
				</tr>
				<c:if test="${traceResult.traceType == 'out'}">
					<tr>
						<td class="alignright">IP所属组织：</td>
						<td>${traceResult.ipGroupName}</td>
					</tr>
				</c:if>
				<tr>
					<td class="alignright">登录方式：</td>
					<c:if test="${traceResult.loginStyle != '1' && user.clientType != '2'}"><td>NID</td></c:if>
					<c:if test="${traceResult.loginStyle =='1'}"><td>学号</td></c:if>
					<c:if test="${traceResult.loginStyle =='2'}"><td>手机号</td></c:if>
				</tr>
				<tr>
					<td class="alignright">NID：</td>
					<td>${traceResult.nid}</td>
				</tr>
				<tr>
					<td class="alignright">DID：</td>
					<td>${traceResult.didstr}</td>
				</tr>
				<tr>
					<td class="alignright">身份证：</td>
					<td>${traceResult.identityId}</td>
				</tr>
				<c:if test="${traceResult.loginStyle =='1'}">
					<tr>
						<td class="alignright">学号：</td>
						<td>${traceResult.clientName}</td>
					</tr>
					<tr>
						<td class="alignright">手机号：</td>
						<td>${traceResult.mobile}</td>
					</tr>
				</c:if>
				<c:if test="${traceResult.loginStyle != '1'}">
					<tr>
						<td class="alignright">手机号：</td>
						<td>${traceResult.mobile}</td>
					</tr>
				</c:if>
				<tr>
					<td class="alignright">姓名：</td>
					<td>${traceResult.didName}</td>
				</tr>
				<tr>
					<td class="alignright">籍贯：</td>
					<td>${traceResult.didAddr}</td>
				</tr>
				<tr>
					<td class="alignright">入网时间：</td>
					<td>${traceResult.timeDate}</td>
				</tr>
				<c:if test="${traceResult.idearType == 'mac'}">
					<tr>
						<td class="alignright">MAC地址：</td><td>${user.macAddr}</td>
					</tr>
				</c:if>
				<c:if test="${traceResult.apName == ''}">
					<tr>
						<td class="alignright" >Port：</td><td>${traceResult.port}</td>
					</tr>
				</c:if>
				<c:if test="${traceResult.apName != ''}">
					<tr>
						<td class="alignright">apName：</td><td>${traceResult.apName}</td>
					</tr>
				</c:if>
				<c:if test="${traceResult.apName == ''}">
				   <tr>
				   		<td class="alignright">交换机IP：</td><td>${traceResult.switchIp}</td>
				   </tr>
			    </c:if>
			    
			    <c:if test="${traceResult.apName == ''}">
			     	<tr>
			     		<td class="alignright">接入类型：</td><td>有线接入</td>
			     	</tr>
			    </c:if>
			    <c:if test="${traceResult.apName != '' && traceResult.apName != null}">
			     	<tr>
			     		<td class="alignright">接入类型：</td><td>无线接入</td>
			     	</tr>
			    </c:if>
			</table>
			<div class="btn" style="text-align:center">
		    	<input type="button" style="text-align:center;" class="button" value="返回" onclick="history.go(-1)"/>
		    </div>
		</div>
	</body>
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</html>							