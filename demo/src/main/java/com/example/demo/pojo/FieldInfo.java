package com.example.demo.pojo;

public class FieldInfo {
	
	private String type;
	private boolean nullable;
	
	public FieldInfo() {
	}
	
	public FieldInfo(String type, boolean nullable) {
		this.type = type;
		this.nullable = nullable;
	}


	public String getType() {
		return type;
	}
	
	public void setType( String type) {
		this.type = type;
	}

	public boolean isNullable() {
		return nullable;
	}
	
	public void setNullable(boolean nullable) {
		this.nullable = nullable;
	}
	
}