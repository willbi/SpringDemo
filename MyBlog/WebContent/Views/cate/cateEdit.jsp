<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table>
	<tr>
		<td>分类代码</td>
		<td><input type="text" bind="cateCode" value="${cate.cateCode}"/> <input type="hidden"
			bind="cateID"  value="${cate.cateID}"/></td>
	</tr>
	<tr>
		<td>分类名称</td>
		<td><input type="text" bind="cateName"  value="${cate.cateName}"/></td>
	</tr>
	<tr>
		<td>分类描述</td>
		<td><input type="text" bind="cateDesc"  value="${cate.cateDesc}"/></td>
	</tr>
	<tr>
		<td>分类排序</td>
		<td><input type="text" bind="cateSort"  value="${cate.cateSort}"/></td>
	</tr>
	<tr>
		<td colspan="2"><input type="button" value="保存" onclick="save()" /></td>
	</tr>
</table>
