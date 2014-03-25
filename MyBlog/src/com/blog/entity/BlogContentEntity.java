package com.blog.entity;

import java.util.Date;

public class BlogContentEntity {

	private int blogID;
	private int cateID;
	private int userID;
	private String blogTitle;
	private String blogTitleEn;
	private String blogContent;
	private String blogDesc;
	private Date createDateTime;
	
	private String cateName;
	private String userName;
	
	
	public int getBlogID(){
		return this.blogID;
	}
	public int getCateID(){
		return this.cateID;
	}
	public int getUserID(){
		return this.userID;
	}
	public String getBlogTitle(){
		return this.blogTitle;
	}
	public String getBlogTitleEn(){
		return this.blogTitleEn;
	}
	public String getBlogContent(){
		return this.blogContent;
	}
	public String getBlogDesc(){
		return this.blogDesc;
	}
	public Date getCreateDateTime(){
		return this.createDateTime;
	}
	
	public String getCateName(){
		return this.cateName;
	}
	public String getUserName(){
		return this.userName;
	}
	
	public void setBlogID(int blogID){
		this.blogID=blogID;
	}
	public void setCateID(int cateID){
		this.cateID =cateID;
	}
	public void setUserID(int userID){
		this.userID = userID;
	}
	public void setBlogTitle(String blogTitle){
		this.blogTitle = blogTitle;
	}
	public void setBlogTitleEn(String blogTitleEn){
		this.blogTitleEn = blogTitleEn;
	}
	public void setBlogContent(String blogContent){
		this.blogContent = blogContent;
	}
	public void setBlogDesc(String blogDesc){
		this.blogDesc = blogDesc;
	}
	public void setCreateDateTime(Date createDateTime){
		this.createDateTime = createDateTime;
	}
	
	public void setCateName(String cateName){
		this.cateName = cateName;
	}
	public void setUserName(String userName){
		this.userName = userName;
	}
}
