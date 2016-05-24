package com.liuliu.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuliu.dao.CustomerDao;
import com.liuliu.entity.Customer;
import com.liuliu.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Resource
	private CustomerDao customerDao;
	
	//注册
	public boolean save(Customer customer) {
		customerDao.addCustomer(customer);
		return true;
	}
	
}
