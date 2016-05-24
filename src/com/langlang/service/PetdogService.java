package com.langlang.service;

import java.util.List;

import com.langlang.model.Petdog;
import com.langlang.model.User;

public interface PetdogService {
	/*
	 * 查询宠物信息
	 */
	public List<Petdog> getPetdgos();
	
	/*
	 * 删除宠物信息
	 */
	public boolean del(int dogId);
	
	/*
	 * 修改宠物信息
	 */
	public void update(Petdog petdog);
	
	/*
	 * 增加宠物信息
	 */
	public boolean save(Petdog petdog);
}
