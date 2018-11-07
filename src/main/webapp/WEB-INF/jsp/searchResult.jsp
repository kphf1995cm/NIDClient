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
			function clearCreateTime(){
				document.getElementById("createTime").value="";
			}
		</script>
	</head>
	<body>
		<%@include file="/WEB-INF/jsp/common/header.jsp"%>
		<%@include file="/common/messages.jsp"%>
		<div class="mess">
			<form id="queryForm" action="searchresult.do" method="post">
			创建时间：
				<input type="text" id="createTime" name="createTime" size="10" readonly="readonly" value="<fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd"/>"/>
				<img width="16" height="16" src="<c:url value='/images/iconCalendar.gif'/>" alt="" onclick="displayCalendar(document.getElementsByName('createTime')[0],'yyyy-mm-dd',this);"/>
				<input type="submit" class="button" value="查询" />
				<input type="button" class="button" value="清空" onclick="clearCreateTime()"/>
			</form>
		</div>
		<div class="main">
			<display:table name="plist" export="false" id="traceResult" requestURI="" class="main_table" pagesize="${pagesize}">
				<display:column property="tracedIp" sortable="true" title="IP地址" />
				<display:column property="addOpr" sortable="true" title="申请人" />
				<display:column property="port" sortable="true" title="端口号" />
				<display:column property="traceType" sortable="true" title="登录类型">
					<c:if test="${traceResult.traceType == 'in'}">域内登录</c:if>
					<c:if test="${traceResult.traceType == 'out'}">域间登录</c:if>
				</display:column>
				<display:column property="timeDate" sortProperty="timeDate" sortable="true" title="入网时间"/>

				<display:column property="nid" sortable="true" title="NID" />
				<display:column property="didstr" sortable="true" title="DID" />
				<display:column property="nidGroupName" sortable="true" title="NID所属组织" />
				<display:column property="ipGroupName" sortable="true" title="IP所属组织" />
				<display:column property="mac" sortable="true" title="MAC" />
				<display:column sortProperty="createTime" sortable="true" title="创建时间">
					<fmt:formatDate value="${traceResult.createTime }" pattern="yyyy-MM-dd HH:mm:ss"/>
				</display:column>
				<display:column property="auditOpr" sortable="true" title="审核人" />
				<display:column   title="审核状态">
					<c:if test="${traceResult.auditOpr == null}">未审核</c:if>
					<c:if test="${traceResult.auditOpr != null}">已审核</c:if>
				</display:column>
				<display:column   title="操作">
					<c:if test="${usertype == 0}">
						<c:if test="${traceResult.auditOpr == null}">
							<input id="dayButton_id" type="button" class="button" value="审核" onclick="javascript:location.href='auditTrace.do?traceResultid=${traceResult.id}'"/>
						</c:if>
					</c:if>
					<input id="dayButton_id" type="button" class="button" value="查看" onclick="javascript:location.href='searchResultPro.do?traceResultid=${traceResult.id}'"/>
				</display:column>
				<display:setProperty name="paging.banner.item_name">追溯查询</display:setProperty>
	    		<display:setProperty name="paging.banner.items_name">追溯查询</display:setProperty>
			</display:table>
		</div>
	</body>
	<%@include file="/WEB-INF/jsp/common/footer.jsp"%>
</html>							