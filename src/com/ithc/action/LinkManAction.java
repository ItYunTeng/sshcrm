package com.ithc.action;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ithc.bean.Customer;
import com.ithc.bean.LinkMan;
import com.ithc.service.LinkManService;
import com.ithc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("all")
public class LinkManAction extends ActionSupport implements ModelDriven<LinkMan>{
	private LinkMan linkMan = new LinkMan();
	@Override
	public LinkMan getModel() {
		
		return linkMan;
	}
	private LinkManService linkManService;
	public void setLinkManService(LinkManService linkManService) {
		this.linkManService = linkManService;
	}
	
	/**
	 * 从页面获取
	 *  1.第几页
	 *  2.每页显示显示多少条数据
	 * @return
	 */
	
	private Integer pageSize = 2;
	private Integer pageCode = 1;
	
	public void setPageSize(Integer pageSize) {
		
		this.pageSize = pageSize;
	}
	public void setPageCode(Integer pageCode) {
		
		if(pageCode == null || pageCode < 1){
			pageCode = 1;
			
		}
		if(pageCode > count){
			pageCode = count;
		}
		this.pageCode = pageCode;
	}
	
	/**
	 *  共count页
	 */
	private Integer count;
	public void setCount(Integer count) {
		this.count = count;
	}
	/**
	 *  分页查询
	 * @return
	 */
	public String findByPage(){
		// 创建离线条件查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(LinkMan.class);
		try {
			// 用名字查询
			String lkm_name = linkMan.getLkm_name();
			if(!lkm_name.trim().equals("")){
				criteria.add(Restrictions.ilike("lkm_name", "%"+lkm_name+"%"));
			}
			// 用所属客户查
			Customer customer = linkMan.getCustomer();
			Long cust_id = customer.getCust_id();
			if(cust_id != null){
				criteria.add(Restrictions.eq("customer.cust_id",customer.getCust_id()));
			}
		} catch (Exception e) {
		}
		
		PageBean<LinkMan> page =  linkManService.findByPage(criteria,this.pageCode,this.pageSize);
		// 压栈
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page",page);
		return "findByPage";
	}
	
	
	/**
	 *  跳转添加
	 */
	public String initAddUI(){
		
		return "initAddUI";
	}
	
	/**
	 *  添加数据
	 */
	public String save(){
		
		linkManService.save(linkMan);
		
		return "initAddUI";
	}
	
	/**
	 *  修改之前查询
	 */
	public String initUpdate(){
		Long lkm_id = linkMan.getLkm_id();
		linkMan = linkManService.findById(lkm_id);
		
		return "initUpdate";
	}
	
	/**
	 *  修改
	 */
	public String update(){
		
		linkManService.update(linkMan);
		
		return "update";
	}
	
	/**
	 *  删除
	 */
	public String delete(){
		//查询
		Long lkm_id = linkMan.getLkm_id();
		LinkMan lm = linkManService.findById(lkm_id);
		// 删除
		linkManService.delete(lm);
		return "delete";
	}
	
	

}
