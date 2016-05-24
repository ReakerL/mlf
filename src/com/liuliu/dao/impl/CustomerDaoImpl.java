package com.liuliu.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import com.liuliu.dao.CustomerDao;
import com.liuliu.entity.Customer;
import com.util.MyHibernateDaoSupport;

@Repository("customerDao")
public class CustomerDaoImpl extends MyHibernateDaoSupport implements CustomerDao{
	
	//注册用户信息
	public void addCustomer(Customer customer) {
		Session session = this.getSession(true);
		Transaction tc = (Transaction) session.beginTransaction();
		session.save(customer);
		try {
			tc.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		session.close();
	}

}
