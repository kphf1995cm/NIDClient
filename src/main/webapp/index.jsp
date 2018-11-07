<%@ include file="/common/taglibs.jsp"%>
<%
String useHTTPS = getServletContext().getInitParameter("useHTTPS");
if("true".equals(useHTTPS)){
	String serverName = request.getServerName();
	String url = "https://"+serverName+"/search.do";
	request.setAttribute("url",url);
%>
<c:redirect url="${url}"/>
<%
}else{
%>	
<c:redirect url="/search.do"/>
<%	
}
%>