<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<td><a href="###" onclick="update(${d.cateID})">�޸�</a><a
				href="###" onclick="del(${d.cateID})">ɾ��</a></td>
		</tr>
	</c:forEach>
</table>