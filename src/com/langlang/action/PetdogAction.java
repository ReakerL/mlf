package com.langlang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Controller;

import com.langlang.model.Petdog;
import com.langlang.model.User;
import com.langlang.service.PetdogService;
import com.opensymphony.xwork2.ActionContext;
import com.util.JSONUtils;

@Controller
public class PetdogAction extends BaseAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Resource
	private PetdogService petdogService;
	
	private Petdog petdog;
	
	private Integer dogId;
	
	public Integer getDogId() {
		return dogId;
	}
	public void setDogId(Integer dogId) {
		this.dogId = dogId;
	}
	public Petdog getPetdog() {
		return petdog;
	}
	public void setPetdog(Petdog petdog) {
		this.petdog = petdog;
	}
	
	/**
	 * 增加宠物信息
	 */
	public String petdogadd(){
		petdogService.save(petdog);
		System.out.println("姓名：" + petdog.getDogName());
			return "SUCCESS";
		}
	/**
	 * 删除宠物信息
	 */
	public void petdogdelete() throws IOException{
		System.out.println("id="+dogId);
		try {
			petdogService.del(dogId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 修改宠物信息
	 */
	public String petdogupdate()
	{
		System.out.println("petdogId="+petdog.getDogId()+",petdogName="+petdog.getDogName());
		petdogService.update(petdog);
		return "SUCCESS";
	}
	
	/**
	 * 查询宠物信息
	 * @throws IOException
	 */
	public void doglist() throws IOException{
		List<Petdog> list = new ArrayList<Petdog>();
		list = petdogService.getPetdgos();
		String results =JSONUtils.listToJson(list);
	    HttpServletResponse response=ServletActionContext.getResponse();  
	    response.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();  
	    out.println(results);  
	    out.flush();
	    out.close();
	}
	
}
