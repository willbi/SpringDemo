<%@ page language="java" contentType="text/html; charset=gb2312"
	pageEncoding="gb2312"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<title>登录</title>
<script type="text/javascript"
	src="<c:url value='/Resource/JavaScript/Common/jquery-1.8.2.js' />"></script>
	<script type="text/javascript">
	function doLogin(){
		var data ={};
		data.userCode=$("input[name=userCode]").val();
		data.userPassword=$("input[name=userPassword]").val();
		postByJson(data, "doLogin", function(result) {
			if(result.code>0){
				window.location.href="../user/user";
			}else{
				alert(result.msg);
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
	</script>
</head>
<body>
	<table>
		<tr>
			<td>用户代码</td>
			<td><input type="text" name="userCode" /></td>
		</tr>
		<tr>
			<td>用户密码</td>
			<td><input type="password" name="userPassword" /></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="登录" onclick="doLogin()" /></td>
		</tr>
	</table>
</body>
</html>