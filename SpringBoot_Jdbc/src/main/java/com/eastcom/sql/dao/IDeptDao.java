package com.eastcom.sql.dao;

import com.eastcom.sql.bean.Dept;

public interface IDeptDao {
	
	public Dept selectById(Integer id);
	
	public Integer insert(Dept dept);
	
	public Integer updateById(Integer id,Dept dept);
	
	public Integer deleteById(Integer id);
}
