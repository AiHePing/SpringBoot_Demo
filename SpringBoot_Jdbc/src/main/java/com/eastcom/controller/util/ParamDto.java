package com.eastcom.controller.util;

import com.eastcom.sql.bean.Dept;

public class ParamDto {
	private Integer id;
	
	private Dept dept;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "UpdateParamDto [id=" + id + ", dept=" + dept + "]";
	}
}
