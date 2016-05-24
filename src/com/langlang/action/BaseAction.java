package com.langlang.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;



import org.apache.struts2.ServletActionContext;


import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 当前第几页
	 */
	private int currPage = 1;
	/**
	 * 当前页显示记录数
	 */
	private int pageSize = 24;
	/**
	 * 总记录数
	 */
	private int totalCount = 0;
	
	private int pagePre;  //上一页
	private int pageNext;   //下一页
	private int pageTotal;  //总页数
	private int selectedDiv;
	private int id;
	
//	private Map<String, String> map;
	
	private Map<String, String> base64Map = new HashMap<String, String>();
	public String toJson;
	/**
	 * request
	 * 
	 * @return
	 */
	public HttpServletRequest getRequest() {
		return ServletActionContext.getRequest();
	}

	/**
	 * response
	 * 
	 * @return
	 */
	public HttpServletResponse getResponse() {
		return ServletActionContext.getResponse();
	}

	/**
	 * session
	 * 
	 * @return
	 */
	public HttpSession getSession() {
		return ServletActionContext.getRequest().getSession();
	}
	public Map<String, Object> getSession2() {
		return ActionContext.getContext().getSession();
	}
	
	/**
	 * servlet
	 * 
	 * @return
	 */
	public ServletContext getServletContext() {
		return ServletActionContext.getServletContext();
	}
	
	public void outputString(String result) {
		PrintWriter out = null;
		try {
			getResponse().setContentType("text/html; charset=UTF-8");
			out = getResponse().getWriter();
			out.write(result);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
	
	public Integer getFirstResult(){
		return (currPage-1)* pageSize;
	}
	
	//控制下一页
	public int getPageNext() {
		if(getCurrPage()< getPageTotal()){
			return getCurrPage()+1;
		}else if(getCurrPage()==getPageTotal()){
			return 1;	
		}
		return getPageTotal();
	}
	//	控制上一页
	public int getPagePre() {
		if(getCurrPage()>1){
			return getCurrPage()-1;
		}else if(getCurrPage()==1){
			return 1;
		}else{
			return getPageTotal();
		}
	}
	
	//计算总页数
	public int getPageTotal() {
		if(getTotalCount()%getPageSize()==0){
			return getTotalCount()/getPageSize();
		}else{
			return getTotalCount()/getPageSize()+1;
		}
	}
	
	protected void outJSONData(Object obj){
		PrintWriter out = null;
		try{
			getResponse().setContentType("text/javascript;charset=UTF-8");
			out = getResponse().getWriter();
			out.print(obj);
		}catch (Exception e) {
			
		}finally{
			if(out != null){
				out.flush();
				out.close();
			}
		}
	}
	
	protected void outStringData(String result){
		PrintWriter out = null;
		try {
			getResponse().setContentType("text/html; charset=utf-8");   
			getResponse().setHeader("Cache-Control", "no-cache");   
	        out = getResponse().getWriter();   
	        out.write(result);
			out.flush();   
		} catch (Exception e) {
			
		}finally{
			if(out != null){
				out.close();
			}
		}
	}
	
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setPagePre(int pagePre) {
		this.pagePre = pagePre;
	}

	public void setPageNext(int pageNext) {
		this.pageNext = pageNext;
	}

	public void setPageTotal(int pageTotal) {
		this.pageTotal = pageTotal;
	}

	public int getSelectedDiv() {
		return selectedDiv;
	}

	public void setSelectedDiv(int selectedDiv) {
		this.selectedDiv = selectedDiv;
	}

//	public Map<String, String> getMap() {
//		return map;
//	}
//
//	public void setMap(Map<String, String> map) {
//		this.map = map;
//	}

	public Map<String, String> getBase64Map() {
		return base64Map;
	}
	
}
