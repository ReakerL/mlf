package com.langlang.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.langlang.dao.PetdogDao;
import com.langlang.model.Petdog;
import com.langlang.model.User;
import com.util.MyHibernateDaoSupport;

@Repository("petdogDao")
public class PetdogDaoImpl extends MyHibernateDaoSupport implements PetdogDao{
	
	//增加宠物信息
	public void addPetdog(Petdog petdog){
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.save(petdog);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		session.close();
	}
	
	/**
	 * 删除宠物信息
	 */
	public boolean delPetdog(Integer dogId) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		Petdog u = new Petdog(dogId);
		boolean bool=false;
		if(u != null){
			session.delete(u);
			bool=true;
			try {
				tc.commit();
			} catch (Exception e) {
				e.printStackTrace();
			} 
			session.close();
			return bool;
		}
		return bool;
	}
	/*
	 * 修改宠物信息
	 */
	public void updatePetdog(Petdog petdog){
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.update(petdog);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
	}
	//查询宠物信息
	public List<Petdog> selectPetdog() {
		List<Petdog> petdogs = new ArrayList<Petdog>();
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		List list = session.createQuery("From Petdog").list();
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Petdog u = (Petdog) iterator.next();
			petdogs.add(u);
		}
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
		session.close();
		return petdogs;
		
	}
	
	
	/*private PreparedStatement sta;
	public void addPetdog(Petdog petdog ){
		String sql="insert into petdog(dogName,dogSex,Birthday,Price)"+
					"values(?,?,?,?)";
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(sql!= null && sql != ""){
			this.getHibernateTemplate().save(sql);
			boolean bool=true;
			return bool;
		}else{
			boolean bool=false;
			return bool;
		}
	}*/
}
