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
		success : function(event, xhr, settings) {
			if (callback) {
				if (settings.getResponseHeader("sessionstatus") == "timeout") {
					alert("��¼��ʱ�������µ�¼");
					if (settings.getResponseHeader("timeoutpage")) {
						window.location.replace(settings
								.getResponseHeader("timeoutpage"));
					} else {

					}
				}
				callback($.parseJSON(settings.responseText));
			} else {
				// ajax����
			}
		},
		error : function(error) {
			alert("������:" + error.responseText);
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
			alert("������");
		}
	});

}