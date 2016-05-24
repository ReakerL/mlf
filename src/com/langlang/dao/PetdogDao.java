package com.langlang.dao;

import java.util.List;

import com.langlang.model.Petdog;
import com.langlang.model.User;


/**
 * 宠物控制dao实现数据库操作接口
 * @author Administrator
 *
 */
public interface PetdogDao {
	
	public List<Petdog> selectPetdog();
	
	/*
	 * 增加宠物信息
	 */
	public void addPetdog(Petdog petdog);
	
	/*
	 * 删除宠物信息
	 */
	public boolean delPetdog(Integer dogId);
	
	/*
	 * 修改宠物信息
	 */
	public void updatePetdog(Petdog petdog);
	/*public void addPetdog(Petdog petdog);
	public boolean delPetdog(Integer dogId);
	public void updatePetdog(Petdog petdog);
	public List<Petdog> selectPetdog();*/

}
