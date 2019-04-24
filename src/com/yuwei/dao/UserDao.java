package com.yuwei.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.yuwei.db.DataSourceUtils;
import com.yuwei.model.User;

public class UserDao {

	private JdbcTemplate jdbcTemplate  = new JdbcTemplate(DataSourceUtils.getDataSource());
	
	//新增,修改,删除,调用同一个方法
	public int update(String sql,Object [] args) throws Exception{
		
		return jdbcTemplate.update(sql, args);
	}
	
	//查询一条实体记录
	public User queryById(String sql,Object [] args) throws Exception{
		//映射
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.queryForObject(sql,rowMapper, args);
	}
	
	//查询多条条实体记录
	public List<User> queryList(String sql,Object [] args) throws Exception{
		//映射
		RowMapper<User> rowMapper = new BeanPropertyRowMapper<User>(User.class);
		return jdbcTemplate.query(sql,rowMapper, args);
	}
}
