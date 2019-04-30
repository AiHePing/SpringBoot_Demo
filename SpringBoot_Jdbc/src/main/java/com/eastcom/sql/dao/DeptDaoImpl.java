package com.eastcom.sql.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.eastcom.sql.bean.Dept;

@Repository
public class DeptDaoImpl implements IDeptDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private NamedParameterJdbcTemplate nameJdbcTemplate;

	@Override
	public Dept selectById(Integer id) {
		String sql = String.format("SELECT * FROM DEPT WHERE DEPTNO= %d",id);
//		Dept dept = (Dept) jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper(Dept.class));
		List<Dept> dept =jdbcTemplate.query(sql,new BeanPropertyRowMapper(Dept.class));
		return dept.get(0);
	}

	@Override
	public Integer insert(Dept dept) {
		String sql = String.format("insert into dept (DEPTNO,DNAME,LOCATION) values (%d,'%s','%s')",
																	dept.getDeptno(),dept.getDname(),dept.getLocation());
		int update = jdbcTemplate.update(sql);
		return update;
	}

	@Override
	public Integer update(Integer id,Dept dept) {
		String sql = String.format("UPDATE DEPT SET DEPTNO=%d , DNAME='$s',LOCATION='$s' WHERE DEPTNO=%d",
				dept.getDeptno(),dept.getDname(),dept.getLocation(),id);
		int update = jdbcTemplate.update(sql);
		return update;
	}

	@Override
	public Integer deleteById(Integer id) {
		String sql = String.format("DELETE FROM DEPT WHERE DEPTNO=%d",id);
		int update = jdbcTemplate.update(sql);
		return update;
	}


}
