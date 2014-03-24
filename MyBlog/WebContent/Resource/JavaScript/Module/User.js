function search() {
	var data = {};
	data.userCode = $("#divSearch input[bind=userCode]").val();
	data.userName = $("#divSearch input[bind=userName]").val();
	postByJson(data, "search", function(result) {
		if (result.code > 0)
			$("#divResult").html(result.content);
		else
			alert(result.msg);
	});
}
function update(userID) {
	postByJson(userID, "get", function(result) {
		if (result.code > 0)
			$("#divEditView").html(result.content);
		else
			alert(result.msg);
	});
}
function save() {
	var data = {};
	data.userID = $("#divEditView input[bind=userID]").val();
	data.userCode = $("#divEditView input[bind=userCode]").val();
	data.userName = $("#divEditView input[bind=userName]").val();
	data.userPassword = $("#divEditView input[bind=userPassword]").val();
	postByJson(data, "save", function(result) {
		if (result.code > 0) {
			$("#divEditView").html("");
			search();
		} else
			alert(result.msg);
	});
}
function del(userID) {
	postByJson(userID, "del", function(result) {
		if (result.code > 0) {
			alert("É¾³ý³É¹¦");
			search();
		} else {
			alert(result.msg);
		}
	});
}