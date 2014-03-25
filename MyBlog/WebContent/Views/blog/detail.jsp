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

<title>${blog.blogTitle}</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<table border="1" style="width: 100%">

		<tr>
			<td colspan="3">
				<h3>${blog.blogTitle}</h3>
			</td>
		</tr>
		<tr>
			<td>作者：${blog.userName}</td>
			<td>分类：${blog.cateName}</td>
			<td>时间：${blog.createDateTime}</td>
		</tr>
		<tr>
			<td colspan="3">${blog.blogContent}</td>
		</tr>

	</table>
</body>
</html>