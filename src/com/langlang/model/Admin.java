package com.langlang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="admin")
public class Admin {
	/**
	 * 用户id
	 */
	@Id
	@Column(name="adminId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;
	
	/*
	 * 用户名
	 */
	@Column(name="name", length=50)
	private String name;
	/*
	 * 密码
	 */
	@Column(name="password", length=50)
	private String password;
	/*
	 * 登录时间
	 */
	@Column(name="logintime", length=50)
	private String logintime;
	
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getLogintime() {
		return logintime;
	}
	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	
	public Admin(int adminId,String name,String password,String logintime){
		this.adminId=adminId;
		this.name=name;
		this.password=password;
		this.logintime=logintime;
	}
	public Admin(String name,String password,String logintime){
		this.name=name;
		this.password=password;
		this.logintime=logintime;
	}
	public Admin(int adminId){
		this.adminId=adminId;
	}
	public Admin(){
		
	}
}
