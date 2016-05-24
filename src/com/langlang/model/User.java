package com.langlang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**     
 * 类名称：User   
 * 类描述：用户信息实体
 * 创建人：langlang   
 * 修改备注：   
 * @version        
 * */
@Entity
@Table(name = "users")
public class User {
	/**
	 * 用户id
	 */
	@Id
	@Column(name = "usersId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer usersId;
	
	
	/**
	 * 用户登录密码
	 */
	@Column(name = "passWord", length = 50)
	private String passWord;

	/**
	 * 用户名
	 */
	@Column(name = "usersName", length = 50)
	private String usersName;
	
	/*
	 * 登录时间
	 */
	@Column(name="logintime", length=50)
	private String logintime;
	

	public Integer getUserId() {
		return usersId;
	}

	public void setUserId(Integer userId) {
		this.usersId = userId;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}

	public void setUserId(int userId) {
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
	

	public User(Integer userId, String passWord , String userName,String logintime) {
		this.usersId = userId;
		this.passWord = passWord;
		this.usersName = userName;
		this.logintime = logintime;
	}

	public User(String passWord, String userName, String logintime) {
		this.passWord = passWord;
		this.usersName = userName;
		this.logintime=logintime;
	}

	public User(Integer userId) {
		this.usersId = userId;
	}

	public User() {
		
	}

}
