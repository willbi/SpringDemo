<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
			<td><a href="###" onclick="update(${d.cateID})">修改</a><a
				href="###" onclick="del(${d.cateID})">删除</a></td>
		</tr>
	</c:forEach>
</table>