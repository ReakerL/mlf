package com.langlang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.langlang.dao.PetdogDao;
import com.langlang.model.Petdog;
import com.langlang.model.User;
import com.langlang.service.PetdogService;

@Service
public class PetdogServiceImpl implements PetdogService{
	
	@Resource
	private PetdogDao petDao;
	//增加宠物信息
	public boolean save(Petdog petdog){
		petDao.addPetdog(petdog);
		return true;
	}
	//删除宠物信息
	public boolean del(int dogId) {
		boolean bool = false;
		bool=petDao.delPetdog(dogId);
		return bool;
	}
	
	//修改宠物信息
	public void update(Petdog petdog) {
		petDao.updatePetdog(petdog);
	}
	
	//查询宠物信息
	public List<Petdog> getPetdgos() {
		List<Petdog> petdogs =petDao.selectPetdog();
		return petdogs;
	}
	
	
}
