<%@ page language="java" contentType="text/html; charset=gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<table border="1" style="width: 500px">
	<tr>
		<td>�û�ID</td>
		<td>�û�����</td>
		<td>�û�����</td>
		<td>�û�����</td>
		<td>����</td>
	</tr>
	<c:forEach items="${userlist}" var="d">
		<tr USER_ID="${d.userID}" USER_CODE="${d.userCode}" USER_NAME="${d.userName}" USER_PASSWORD="${d.userPassword}">
			<td>${d.userID}</td>
			<td>${d.userCode}</td>
			<td>${d.userName}</td>
			<td>${d.userPassword}</td>
			<td><a href="###" onclick="update(${d.userID})">�޸�</a></td>
			<td><a href="###" onclick="del(${d.userID})">ɾ��</a></td>
		</tr>
	</c:forEach>
</table>
