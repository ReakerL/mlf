package com.langlang.dao;

import java.util.List;

import com.langlang.model.User;

/**     
 * 类名称：UserDao   
 * 类描述：用户控制dao实现数据库操作接口
 * 创建人：lang   
 * 修改人：lang  
 * 修改备注：   
 * @version        
 * */
public interface UserDao {
	public void addUser(User user);

	public boolean delUser(Integer userId);

	public void updateUser(User user);

	public List<User> selectUser();

	public User getUserByUserId(int userId);

	public boolean isExitByName(String userName);

	public boolean isExitByNameAndPass(User user);
}
