function search() {
	var data = {};
	data.cateCode = $("#divSearch input[bind=cateCode]").val();
	data.cateName = $("#divSearch input[bind=cateName]").val();
	postByJson(data, "search", function(result) {
		if (result.code > 0)
			$("#divResult").html(result.content);
		else
			alert(result.msg);
	});
}
function update(cateID) {
	postByJson(cateID, "get", function(result) {
		if (result.code > 0)
			$("#divEditView").html(result.content);
		else
			alert(result.msg);
	});
}
function save() {
	var data = {};
	data.cateID = $("#divEditView input[bind=cateID]").val();
	data.cateCode = $("#divEditView input[bind=cateCode]").val();
	data.cateName = $("#divEditView input[bind=cateName]").val();
	data.cateDesc = $("#divEditView input[bind=cateDesc]").val();
	data.cateSort = $("#divEditView input[bind=cateSort]").val();
	postByJson(data, "save", function(result) {
		if (result.code > 0) {
			$("#divEditView").html("");
			search();
		} else
			alert(result.msg);
	});
}
function del(cateID) {
	postByJson(cateID, "del", function(result) {
		if (result.code > 0) {
			alert("É¾³ý³É¹¦");
			search();
		} else
			alert(result.msg);
	});
}
