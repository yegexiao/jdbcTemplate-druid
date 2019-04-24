package com.yuwei.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Controller;

import com.alibaba.druid.support.logging.Log;
import com.alibaba.druid.support.logging.LogFactory;
import com.yuwei.dao.UserDao;
import com.yuwei.model.User;

@Controller
public class TestController {
	private static final Log log =  LogFactory.getLog(TestController.class);
	private UserDao userDao = new UserDao();
	private String uuid = UUID.randomUUID().toString().toLowerCase().replace("-", "");
	
	//测试新增
	public void testInsert() {
		String sql = "insert into user values(?,?,?,?)";
		Object[] objs={uuid,"sam",19,"女"};

		try {
			int count = userDao.update(sql, objs);
			log.info("新增成功，返回值："+count);
		} catch (Exception e) {
			//e.printStackTrace();
			log.error("新增失败",e);
		}
	}
	
	//测试修改
	public void testUpdate() {
		String sql = "update user set name = ?,age = ?,sex = ? where id = ?";
		Object[] objs={"sam",66,"女","5"};

		try {
			int count = userDao.update(sql, objs);
			log.info("修改成功，返回值："+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("修改失败",e);
		}
	}
	
	//测试删除
	public void testDelete() {
		String sql = "delete from user  where id = ?";
		Object[] objs={"5"};

		try {
			int count = userDao.update(sql, objs);
			log.info("删除成功，返回值："+count);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("删除失败",e);
		}
	}
	
	//查询一条记录
	public void queryById() {
		String sql = "select id,name,age,sex from user where id = ?";
		Object[] objs={"5"};

		try {
			User user = userDao.queryById(sql, objs);
			log.info("查询实体成功，返回实体对象："+user.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询出错",e);
		}
	}
	
	//查询多条条记录
	public void queryList() {
		String sql = "select id,name,age,sex from user where id > ?";
		Object[] objs={"1"};

		try {
			List<User> userList = userDao.queryList(sql, objs);
			log.info("查询实体成功，返回实体对象："+userList.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("查询出错",e);
		}
	}
	
	public static void main(String[] args) {
		
		TestController test = new TestController();
		//test.testInsert();
		test.testUpdate();
		//test.testDelete();
		//test.queryById();
		//test.queryList();
	}
}
