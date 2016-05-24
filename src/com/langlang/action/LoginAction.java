package com.langlang.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.langlang.dao.UserDao;
import com.langlang.model.User;

/**     
 * 类名称：LoginAction   
 * 类描述：用户控制器的实现
 * 创建人：lang   
 * 修改人：lang  
 * 修改备注：   
 * @version        
 * */
@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class LoginAction extends BaseAction {
	@SuppressWarnings("unused")
	private static final long serialVersionUID = -2266695172069461659L;
	@Resource(type=UserDao.class)
	private UserDao userDao;
	private User user;
	private String yanzhengma;
	
	private int userId;
	private String userName;
	
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getYanzhengma() {
		return yanzhengma;
	}

	public void setYanzhengma(String yanzhengma) {
		this.yanzhengma = yanzhengma;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String login(){
		Object yanidc =getSession2().get("rand");
		System.out.println(yanidc);
		String uname=getRequest().getParameter("user.userName");
		System.out.println(uname);
		System.out.println("====");
		if(null!=yanzhengma && null!=yanidc){
			if(yanzhengma.equals(yanidc)){
				boolean flag = userDao.isExitByNameAndPass(user);
//				getSession().setAttribute("userId", userId);//用户id
				getSession().setAttribute("userName", uname);//用户名
				System.out.println("username="+getSession().getAttribute("userName"));
				if(flag){
					System.out.println("登录名：" + user.getUserName());
					return "SUCCESS";
				}
			}
		}
		return "ERROE";
	}
}
