<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../jsReference.jsp"></jsp:include>
<script type="text/javascript"
	src="<c:url value='/Resource/JavaScript/Module/Blog.js' />"></script>

<title>文章列表</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
<a href="add">新增</a>
	<table border="1" style="width: 100%">
		<c:forEach items="${bloglist}" var="d">
			<tr>
				<td colspan="3">
					<h3><a href="detail?id=${d.blogID}" target="_blank">${d.blogTitle}</a> </h3>
				</td>
			</tr>
			<tr>
				<td>作者：${d.userName}</td>
				<td>分类：${d.cateName}</td>
				<td>时间：${d.createDateTime}</td>
			</tr>
			<tr>
				<td colspan="3">${d.blogDesc}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>