function save() {
	var data = {};
	data.blogID = $("input[bind=blogID]").val();
	data.blogTitle = $("input[bind=blogTitle]").val();
	data.blogTitleEn = $("input[bind=blogTitleEn]").val();
	data.cateID = $("select[bind=cateID]").val();
	data.blogDesc = $("textarea[bind=blogDesc]").val();
	data.blogContent = editor.getData();
	postByJson(data, "save", function(result) {
		if (result.code > 0) {
			alert("保存成功");
			window.location.href = "index";
		} else
			alert(result.msg);
	});
}
function del(blogID) {
	postByJson(blogID, "del", function(result) {
		if (result.code > 0) {
			alert("删除成功");
			window.location.href = "index";
		} else
			alert(result.msg);
	});
}