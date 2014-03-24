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

<title>�������</title>
</head>
<body>
	<jsp:include page="../header.jsp"></jsp:include>
	<div id="divSearch">
		<table>
			<tr>
				<td>�������</td>
				<td><input type="text" bind="cateCode" /></td>
				<td>��������</td>
				<td><input type="text" bind="cateName" /></td>
				<td><input type="button" value="��ѯ" onclick="search()" /><input
					type="button" value="����" onclick="update(0)" /></td>
			</tr>
		</table>
	</div>
	<div id="divResult">
		<table border="1" style="width: 500px">
			<tr>
				<td>����ID</td>
				<td>�������</td>
				<td>��������</td>
				<td>��������</td>
				<td>��������</td>
				<td>����</td>
			</tr>
			<c:forEach items="${catelist}" var="d">
				<tr cate_ID="${d.cateID}">
					<td>${d.cateID}</td>
					<td>${d.cateCode}</td>
					<td>${d.cateName}</td>
					<td>${d.cateDesc}</td>
					<td>${d.cateSort}</td>
					<td><a href="###" onclick="update(${d.cateID})">�޸�</a> <a
						href="###" onclick="del(${d.cateID})">ɾ��</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div id="divEditView"></div>
</body>
</html>