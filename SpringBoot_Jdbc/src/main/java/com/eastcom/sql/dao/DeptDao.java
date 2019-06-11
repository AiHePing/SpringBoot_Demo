package com.eastcom.sql.dao;

import org.springframework.stereotype.Repository;

import com.eastcom.sql.bean.Dept;
import com.eastcom.sql.bean.DeptExample;

@Repository
public class DeptDao extends BaseDao<Dept, DeptExample> {
	
	/*@Autowired
	private JdbcTemplate jdbcTemplate;*/
	
/*	@Override
	public Dept selectById(Integer id) {
		String sql = String.format("SELECT * FROM DEPT WHERE DEPTNO= %d",id);
		List<Dept> dept =jdbcTemplate.query(sql,new BeanPropertyRowMapper(Dept.class));
		return dept.get(0);
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public int insert(Dept dept) {
		String sql = String.format("insert into dept (DEPTNO,DNAME,LOCATION) values (%d,'%s','%s')",
						dept.getDeptno(),dept.getDname(),dept.getLocation());
		int update = jdbcTemplate.update(sql);
		if (update==1) {
			throw new RuntimeException("故意的");
		}
		return update;
	}
	@Override
	@Transactional(rollbackFor=Exception.class)
	public Integer updateById(Integer id,Dept dept) {
		String sql = String.format("UPDATE DEPT SET DEPTNO=%d , DNAME='%s' ,LOCATION='%s'  WHERE DEPTNO= %d",
						dept.getDeptno(),dept.getDname(),dept.getLocation(),id);
		int update = jdbcTemplate.update(sql);
		return update;
	}

	@Override
	@Transactional(rollbackFor=Exception.class)
	public Integer deleteById(Integer id) {
		String sql = String.format("DELETE FROM DEPT WHERE DEPTNO=%d",id);
		int update = jdbcTemplate.update(sql);
		return update;
	}
*/

}
