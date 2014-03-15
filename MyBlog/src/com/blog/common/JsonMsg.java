package com.blog.common;

public class JsonMsg {

	private int code = 1;
	private String msg;
	private String content;
	
	public int getCode(){
		return this.code;
	}
	public String getMsg(){
		return this.msg;
	}
	public String getContent(){
		return this.content;
	}
	
	public void setCode(int code){
		this.code = code;
	}
	public void setMsg(String msg){
		this.msg = msg;
	}
	
	public void setContent(String content){
		this.content = content;
	}
}
