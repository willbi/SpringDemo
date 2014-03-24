<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../jsReference.jsp"></jsp:include>
<script type="text/javascript"
	src="<c:url value='/Resource/JavaScript/Module/Cate.js' />"></script>

<title>分类管理</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="divSearch">
		<table>
			<tr>
				<td>分类代码</td>
				<td><input type="text" bind="cateCode" /></td>
				<td>分类名称</td>
				<td><input type="text" bind="cateName" /></td>
				<td><input type="button" value="查询" onclick="search()" /><input
					type="button" value="新增" onclick="update(0)" /></td>
			</tr>
		</table>
	</div>
	<div id="divResult">
		<table border="1" style="width: 500px">
			<tr>
				<td>分类ID</td>
				<td>分类代码</td>
				<td>分类名称</td>
				<td>分类描述</td>
				<td>分类排序</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${catelist}" var="d">
				<tr cate_ID="${d.cateID}">
					<td>${d.cateID}</td>
					<td>${d.cateCode}</td>
					<td>${d.cateName}</td>
					<td>${d.cateDesc}</td>
					<td>${d.cateSort}</td>
					<td><a href="###" onclick="update(${d.cateID})">修改</a> <a
						href="###" onclick="del(${d.cateID})">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="divEditView"></div>
</body>
</html>