package com.example.demo.pojo;

import org.springframework.util.StringUtils;

public class FieldInfo {
	
	private String type;
	private boolean nullable;
	private String entityName;
	
	public FieldInfo() {
	}
	
	public FieldInfo(String type, boolean nullable, String entityName) {
		this.type = type;
		this.nullable = nullable;
		this.entityName = entityName;
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

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}
	
}