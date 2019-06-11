package com.eastcom.sql.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.exceptions.TooManyResultsException;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.MyBatisSystemException;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *  Record：实体类，Example：generator生成的用于拼接where条件的帮助类，可以在不修改mapper文件的基础上添加where条件
 *  下面NameSpace后面 + 的是mapper文件里的标签id。
 */
public class BaseDao<Record, Example> {
	
	protected String NameSpace = this.getClass().getName() + ".";
	
	@Autowired
	protected SqlSessionTemplate sqlSessionTemplate;
	
	/**
	 * count(*)
	 */
	public int countByExample(Example example) {
		Integer count = this.sqlSessionTemplate.selectOne(NameSpace
				+ "countByExample", example);
		return count.intValue();
	}
	
	/**
	 * 删除
	 */
	@Transactional(rollbackFor=Exception.class)
	public int deleteByExample(Example example) {
		return this.sqlSessionTemplate.delete(NameSpace + "deleteByExample",
				example);
	}
	
	/**
	 * 查询，不带分页
	 */
	public List<Record> selectByExample(Example example) {
		return sqlSessionTemplate.selectList(NameSpace + "selectByExample",
				example);
	}
	
	/**
	 * 查一条数据
	 */
	@SuppressWarnings("unchecked")
	public Record selectOneByExample(Example example) {
		try{
		return sqlSessionTemplate.selectOne(NameSpace + "selectByExample",
				example);
		}catch(MyBatisSystemException e){
			if(e.getRootCause() instanceof TooManyResultsException)
				return (Record) sqlSessionTemplate.selectList(NameSpace + "selectByExample",
					example).get(0);
			else
				throw e;
		}
	}
	
	/**
	 * 根据主键查一条数据
	 */
	public Record selectByPrimaryKey(Object key){
		return sqlSessionTemplate.selectOne(NameSpace+"selectByPrimaryKey", key);
	}
	
	/**
	 * 修改record中有值的字段 
	 */
	@Transactional(rollbackFor=Exception.class)
	public int updateByExampleSelective(@Param("record") Record record,
			@Param("example") Example example) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(NameSpace
				+ "updateByExampleSelective", map);
	}
	
	/**
	 * 全量修改
	 */
	@Transactional(rollbackFor=Exception.class)
	public int updateByExample(@Param("record") Record record,
			@Param("example") Example example) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("record", record);
		map.put("example", example);
		return this.sqlSessionTemplate.update(NameSpace + "updateByExample",
				map);
	}
	
	/**
	 * 全量新增
	 */
	@Transactional(rollbackFor=Exception.class)
	public int insert(Record record) {
		return sqlSessionTemplate.insert(NameSpace + "insert", record);
	}
	
	/**
	 * 仅新增record中有值的列
	 */
	@Transactional(rollbackFor=Exception.class)
	public int insertList(List<Record> record) {
		SqlSession session = sqlSessionTemplate.getSqlSessionFactory().openSession(ExecutorType.BATCH, false);
		for(Record rec : record)
			sqlSessionTemplate.insert(NameSpace + "insertSelective", rec);
		session.commit();		
		return 1;
	}
	
	/**
	 * 同上，新增
	 */
	@Transactional(rollbackFor=Exception.class)
	public int insertSelective(Record record) {
		return sqlSessionTemplate.insert(NameSpace + "insertSelective", record);
	}
}
