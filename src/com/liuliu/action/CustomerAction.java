package com.liuliu.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.liuliu.entity.Customer;
import com.liuliu.service.CustomerService;

@Controller
@Scope("prototype")
@SuppressWarnings("all")
public class CustomerAction {
	@Resource
	private CustomerService customerService;
	private Customer customer;
	
	
	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	public String useradd(){
		customerService.save(customer);
		System.out.println("注册获取页面传过来的姓名：" + customer.getUsername());
		return "SUCCESS";
	}
}
