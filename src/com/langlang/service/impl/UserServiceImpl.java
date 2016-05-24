package com.langlang.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.langlang.dao.UserDao;
import com.langlang.model.User;
import com.langlang.service.UserService;
import com.opensymphony.xwork2.ActionContext;


/**     
 * 类名称：UserServiceImpl   
 * 类描述：用户信息操作业务逻辑接口实现
 * 创建人：qb   
 * 修改备注：   
 * @version        
 * */
@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;

	public boolean isExitUser(String userName) {
		return userDao.isExitByName(userName);
	}

	public boolean save(User user) {
		userDao.addUser(user);
		return true;
	}

	public List<User> getUsers() {
//		Map<String,Object> map=ActionContext.getContext().getSession();
//		map.put("empList",userDao.selectUser());
		List<User> users = userDao.selectUser();
		return users;
	}

	public boolean del(int userId) {
		boolean bool = false;
		bool=userDao.delUser(userId);
		
		return bool;
		

	}

	public void update(User user) {
		userDao.updateUser(user);

	}
	
	//根据id查询数据
	public User getUserById(int userId) {
		return userDao.getUserByUserId(userId);
	}

	public boolean isExitByNameAndPass(User user) {
		return userDao.isExitByNameAndPass(user);
	}

}
