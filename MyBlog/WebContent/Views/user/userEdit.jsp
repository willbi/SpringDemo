<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1" style="width: 500px">
	<tr>
		<td>用户代码</td>
		<td><input type="hidden" bind="userID" value="${user.userID}" />
			<input type="text" bind="userCode" value="${user.userCode}" /></td>
	</tr>
	<tr>
		<td>用户名称</td>
		<td><input type="text" bind="userName" value="${user.userName}" /></td>
	</tr>
	<tr>
		<td>用户密码</td>
		<td><input type="text" bind="userPassword"
			value="${user.userPassword}" /></td>
	</tr>
	<tr>
		<td colspan='2'><input type="button" value="保存" onclick="save()" /></td>
	</tr>
</table>