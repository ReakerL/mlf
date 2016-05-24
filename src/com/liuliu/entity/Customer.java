package com.liuliu.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
	/**
	 * 用户id
	 */
	@Id
	@Column(name="custoId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer custoId;
	
	/*
	 * 用户名
	 */
	@Column(name="email", length=50)
	private String email;
	
	/*
	 * 用户名
	 */
	@Column(name="username", length=50)
	private String username;
	
	/*
	 * 密码
	 */
	@Column(name="password", length=50)
	private String password;
	
	/*
	 * 地址
	 */
	@Column(name="address", length=50)
	private String address;
	
	/*
	 * 性别
	 */
	@Column(name="sex", length=50)
	private String sex;
	/*
	 * 登录时间
	 */
	@Column(name="logintime", length=50)
	private String logintime;

	public Integer getCustoId() {
		return custoId;
	}

	public void setCustoId(Integer custoId) {
		this.custoId = custoId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getLogintime() {
		return logintime;
	}

	public void setLogintime(String logintime) {
		this.logintime = logintime;
	}
	public Customer(Integer custoId,String email, String username,String password,String sex,String address, String logintime){
		this.custoId=custoId;
		this.email=email;
		this.username=username;
		this.password=password;
		this.sex=sex;
		this.address=address;
		this.logintime=logintime;
	}
	public Customer(String email, String username,String password, String sex,String address,String logintime){
		this.email=email;
		this.username=username;
		this.password=password;
		this.sex=sex;
		this.address=address;
		this.logintime=logintime;
	}
	public Customer(Integer custoId){
		this.custoId=custoId;
	}
	public Customer(){
		
	}
}
