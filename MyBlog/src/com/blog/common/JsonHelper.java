package com.blog.common;

import java.io.IOException;
import java.io.StringWriter;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonHelper {

	public static String toJson(Object obj) throws IOException {
		String json = "";
		JsonGenerator gen = null;
		StringWriter writer = null;
		try {
			// �����쳣��δ���д����������Ĺر�Ҳ���淶����������������д����������쳣���رղ���
			ObjectMapper mapper = new ObjectMapper();
			writer = new StringWriter();
			gen = new JsonFactory().createJsonGenerator(writer);
			mapper.writeValue(gen, obj);
			json = writer.toString();

		} catch (Exception e) {

		} finally {
			if (gen != null)
				gen.close();
			if (writer != null)
				writer.close();
		}
		return json;
	}

	public static Object fromJson(String jsonValue, Class<?> cls) {

		ObjectMapper map = new ObjectMapper();
		Object t = null;
		try {
			t = map.readValue(jsonValue, cls);
		} catch (JsonParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return t;
	}
}
