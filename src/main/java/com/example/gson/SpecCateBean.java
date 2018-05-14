package com.example.gson;

import java.util.HashMap;
import java.util.List;

import com.google.gson.annotations.Expose;
//鱼类别
public class SpecCateBean {
	@Expose
	private String name;
	@Expose
	private long id;
	@Expose
	private List<HashMap<String,String>> child;

	public SpecCateBean() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<HashMap<String, String>> getChild() {
		return child;
	}

	public void setChild(List<HashMap<String, String>> child) {
		this.child = child;
	}

	
}
