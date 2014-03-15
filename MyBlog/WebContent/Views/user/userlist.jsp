<%@ page language="java" contentType="text/html; charset=GB2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html;">
<title>Blog User Manager</title>
<script type="text/javascript"
	src="<c:url value='/Resource/JavaScript/Common/jquery-1.8.2.js' />"></script>
<script type="text/javascript">
	function searchBlogUser() {
		var data = {};
		data.userCode = $("#tabSearch input[name=USER_CODE]").val();
		data.userName = $("#tabSearch input[name=USER_NAME]").val();
		postByJson(data, "searchUser", function(result) {
			if(result.code>0)
				$("#divResult").html(result.content);
			else
				alert(result.msg);
		});
	}
	function saveBlogUser() {
		var data = {};
		data.userID = $("#tabAdd input[name=USER_ID]").val();
		data.userCode = $("#tabAdd input[name=USER_CODE]").val();
		data.userName = $("#tabAdd input[name=USER_NAME]").val();
		data.userPassword = $("#tabAdd input[name=USER_PASSWORD]").val();
		var url="";
		if(data.userID>0)
			url="update";
		else
			url = "add";
		postByJson(data, url, function(rep) {
			alert("保存成功");
			searchBlogUser();
		});
	}
	function update(obj){
		var tr = $(obj).closest("tr");
		var data = {};
		data.userID = tr.attr("USER_ID]");
		data.userCode = tr.attr("USER_CODE]");
		data.userName = tr.attr("USER_NAME]");
		data.userPassword = tr.attr("USER_PASSWORD]");
		$("#tabAdd input[name=USER_ID]").val(data.userID);
		  $("#tabAdd input[name=USER_CODE]").val(data.userCode);
		  $("#tabAdd input[name=USER_NAME]").val(data.userName);
		  $("#tabAdd input[name=USER_PASSWORD]").val(data.userPassword);
	}
	
	function del(id){
		var data = {};
		data.userID = id;
		postByJson(id, "del", function(result) {
			if(result.code>0){
				alert("删除成功");
				searchBlogUser();
			}else{
				alert(result.msg);
			}
		});
	}

	function get(data, url, callback) {
		$.ajax({
			type : 'GET',
			data : JSON.stringify(data),
			url : url,
			success : function(response) {
				callback(response);
			}
		});
	}
	function postByJson(data, url, callback) {
		$.ajax({
			type : 'POST',
			url : url,
			contentType : 'application/json',
			mimeType : 'application/json',
			data : JSON.stringify(data),
			success : function(response) {
				callback(response);

			},
			error : function(error) {
				alert("出错了");
			}
		});
	}
	function post(data, url, callback) {
		$.ajax({
			type : 'POST',
			url : url,
			data : JSON.stringify(data),
			success : function(response) {
				callback(response);

			},
			error : function(error) {
				alert("出错了");
			}
		});
		  
	}
</script>
</head>
<body>
	<table id="tabSearch">
		<tr>
			<td>用户代码</td>
			<td><input type="text" name="USER_CODE" /></td>
			<td>用户名称</td>
			<td><input type="text" name="USER_NAME" /></td>
			<td><input type="button" value="查询" onclick="searchBlogUser()" /></td>
		</tr>
	</table>
	<div id="divResult">
		<table border="1" style="width: 500px">
			<tr>
				<td>用户ID</td>
				<td>用户代码</td>
				<td>用户名称</td>
				<td>用户密码</td>
				<td>操作</td>
			</tr>
			<c:forEach items="${userlist}" var="d">
				<tr USER_ID="${d.userID}" USER_CODE="${d.userCode}" USER_NAME="${d.userName}" USER_PASSWORD="${d.userPassword}">
					<td>${d.userID}</td>
					<td>${d.userCode}</td>
					<td>${d.userName}</td>
					<td>${d.userPassword}</td>
					<td><a href="###" onclick="update(this)">修改</a></td>
					<td><a href="###" onclick="del(${d.userID})">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<form action="add" method="post">
		<table id="tabAdd" border="1" style="width: 500px">
			<tr>
				<td>用户代码</td>
				<td>
				<input type="hidden" name="USER_ID"/>
				<input type="text" name="USER_CODE" /></td>
			</tr>
			<tr>
				<td>用户名称</td>
				<td><input type="text" name="USER_NAME" /></td>
			</tr>
			<tr>
				<td>用户密码</td>
				<td><input type="text" name="USER_PASSWORD" /></td>
			</tr>
			<tr>
				<td colspan='2'><input type="button" value="保存"
					onclick="saveBlogUser()" /></td>
			</tr>
		</table>
	</form>
</body>
</html>