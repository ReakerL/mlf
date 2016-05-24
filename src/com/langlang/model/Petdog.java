package com.langlang.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="petdog")
public class Petdog {
	/*
	 * 宠物狗id
	 */
	@Id
	@Column(name="dogId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer dogId;
	
	
	/*
	 * 宠物名称
	 */
	@Column(name="dogName",length=50)
	private String dogName;
	/*
	 * 宠物性别
	 */
	@Column(name="dogSex",length=50)
	private String dogSex;
	/*
	 * 宠物生日
	 */
	@Column(name="dogBirthday",length=50)
	private String dogBirthday;
	/*
	 * 宠物价格
	 */
	@Column(name="dogPrice",length=50)
	private String dogPrice;
	
	
	
	
	//get set方法
	public Integer getDogId() {
		return dogId;
	}
	public void setDogId(Integer dogId) {
		this.dogId = dogId;
	}
	public String getDogName() {
		return dogName;
	}
	public void setDogName(String dogName) {
		this.dogName = dogName;
	}
	public String getDogSex() {
		return dogSex;
	}
	public void setDogSex(String dogSex) {
		this.dogSex = dogSex;
	}
	
	public String getDogBirthday() {
		return dogBirthday;
	}
	public void setDogBirthday(String dogBirthday) {
		this.dogBirthday = dogBirthday;
	}
	public String getDogPrice() {
		return dogPrice;
	}
	public void setDogPrice(String dogPrice) {
		this.dogPrice = dogPrice;
	}
	public Petdog(Integer dogId,String dogName,String dogSex,String dogBirthday,String dogPrice){
		this.dogId=dogId;
		this.dogName=dogName;
		this.dogSex=dogSex;
		this.dogBirthday=dogBirthday;
		this.dogPrice=dogPrice;
	}
	
	public Petdog(String dogName,String dogSex,String dogBirthday,String dogPrice){
		this.dogName=dogName;
		this.dogSex=dogSex;
		this.dogBirthday=dogBirthday;
		this.dogPrice=dogPrice;
	}
	
	public Petdog(Integer dogId){
		this.dogId=dogId;
	}
	
	public Petdog(){
			
		}
}
