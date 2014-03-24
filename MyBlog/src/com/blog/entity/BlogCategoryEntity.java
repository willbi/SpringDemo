package com.blog.entity;

public class BlogCategoryEntity {
	
	private int _cateID;
	private String _cateCode;
	private String _cateName;
	private String _cateDesc;
	private int _cateSort;
	
	public int getCateID(){
		return this._cateID;
	}
	public String getCateCode(){
		return this._cateCode;
	}
	public String getCateName(){
		return this._cateName;
	}
	public String getCateDesc(){
		return this._cateDesc;
	}
	public int getCateSort(){
		return this._cateSort;
	}
	
	public void setCateID(int _cateID){
		this._cateID = _cateID;
	}
	public void setCateCode(String _cateCode){
		this._cateCode = _cateCode;
	}
	public void setCateName(String _cateName){
		this._cateName = _cateName;
	}
	public void setCateDesc(String _cateDesc){
		this._cateDesc = _cateDesc;
	}
	public void setCateSort(int _cateSort){
		this._cateSort = _cateSort;
	}
}
