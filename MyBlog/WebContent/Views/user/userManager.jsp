<%@ page language="java" contentType="text/html; charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>用户管理</title>
<jsp:include page="../jsReference.jsp"></jsp:include>
<script type="text/javascript"
	src="<c:url value='/Resource/JavaScript/Module/User.js' />"></script>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="divSearch">
		<table>
			<tr>
				<td>用户代码</td>
				<td><input type="text" bind="userCode" /></td>
				<td>用户名称</td>
				<td><input type="text" bind="userName" /></td>
				<td><input type="button" value="查询" onclick="search()" /><input
					type="button" value="新增" onclick="update(0)" /></td>
			</tr>
		</table>
	</div>
	<div id="divResult">
		<table border="1" style="width: 500px">
			<tr>
				<td>用户ID</td>
				<td>用户代码</td>
				<td>用户名称</td>
				<td>用户密码</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${userlist}" var="d">
				<tr>
					<td>${d.userID}</td>
					<td>${d.userCode}</td>
					<td>${d.userName}</td>
					<td>${d.userPassword}</td>
					<td><a href="###" onclick="update(${d.userID})">修改</a></td>
					<td><a href="###" onclick="del(${d.userID})">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="divEditView"></div>
</body>
</html>