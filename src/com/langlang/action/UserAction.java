package com.langlang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;



import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;


import com.langlang.model.User;
import com.langlang.service.UserService;
import com.util.JSONUtils;

@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class UserAction extends BaseAction{
	@Resource
	private UserService userService;
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	private Integer usersId;
	private String usersName;
	private String passWord;
	
//	@Action(value = "userAction", results = { @Result(name = "yes", location = "/index.jsp") })
	public void toList() throws IOException{
		List<User> list = new ArrayList<User>();
		list = userService.getUsers();
		
		String results =JSONUtils.listToJson(list);
		System.out.println(results);
	    HttpServletResponse response=ServletActionContext.getResponse();
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();  
	    out.println(results);  
	    out.flush();
	    out.close();
	}
	public String add(){
		userService.save(user);
		System.out.println("添加获取页面传过来的姓名：" + user.getUserName());
			return "SUCCESS";
		}
	public void delete() throws IOException{
		System.out.println("id="+usersId);
		try{
			userService.del(usersId);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
			
	}
	//根据id查询数据
	public String userupdatedo(){
		userService.getUserById(usersId);
		return null;
	}
	//修改
	public String userupdate(){
		System.out.println("userId="+user.getUserId()+",userName="+user.getUserName());
		userService.update(user);
		return "SUCCESS";
	}
	/*
	 * 退出
	 */
	public String  exitlogin(){
		getSession().removeAttribute("userName");
		return "SUCCESS";
	}
	//获取session中的用户名
	public void getUserInfo(){
		String userName = (String) getSession().getAttribute("userName");
		if("" != userName && !"".equals(userName)){
			outStringData(userName);
		}else{
			outStringData("-1");
		}
		
	}
	
	public String booleq(boolean bool){
		String tr="-1";
		
		if(bool){
			tr="1";
			return tr;
		}
		else{
			return tr;
		}
	}
	public Integer getUserId() {
		return usersId;
	}
	public void setUserId(Integer userId) {
		this.usersId = userId;
	}
	public String getUserName() {
		return usersName;
	}
	public void setUserName(String userName) {
		this.usersName = userName;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	
	
}
