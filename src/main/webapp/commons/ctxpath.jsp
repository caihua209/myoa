<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String ctxPath = request.getContextPath();
	request.setAttribute("ctxPath", ctxPath);
%>
<script type="text/javascript">
	//定义js的全局变量 ctxPath：项目名
	var ctxPath = '${ctxPath}'; 
</script>
