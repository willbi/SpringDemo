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
<script type="text/javascript"
	src="<c:url value='/Resource/Plugin/ckeditor/ckeditor.js' />"></script>

<title>文章编辑</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>

	<table border="1" style="width: 100%">

		<tr>
			<td>标题</td>
			<td><input type="text" bind="blogTitle"
				value="${blog.blogTitle }" /> <input type="hidden" bind="blogID"
				value="${blog.blogID }" /></td>
		</tr>
		<tr>
			<td>英文标题</td>
			<td><input type="text" bind="blogTitleEn"
				value="${blog.blogTitleEn }" /></td>
		</tr>
		<tr>
			<td>分类</td>
			<td><select bind="cateID">
					<c:forEach items="${cate}" var="c">
						<c:choose>
							<c:when test="${c.cateID ==blog.cateID }">
								<option selected value="${c.cateID }">${c.cateName }</option>
							</c:when>
							<c:otherwise>
								<option value="${c.cateID }">${c.cateName }</option>
							</c:otherwise>
						</c:choose>
					</c:forEach>
			</select></td>
		</tr>
		<tr>
			<td>描述</td>
			<td><textarea style="height: 50px;width:320px;" cols="200" bind="blogDesc">${blog.blogDesc }</textarea></td>
		</tr>
		<tr>
			<td>内容</td>
			<td><textarea style="height: 60px" id="txtBlogContent"
					bind="blogContent">${blog.blogContent }</textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="提交" onclick="save()" />
			</td>
		</tr>
	</table>
	<script type="text/javascript">
		var editor = CKEDITOR.replace('txtBlogContent');
	</script>
</body>
</html>