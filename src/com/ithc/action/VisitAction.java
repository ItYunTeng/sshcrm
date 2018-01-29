package com.ithc.action;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.ithc.bean.Visit;
import com.ithc.service.VisitService;
import com.ithc.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;

@SuppressWarnings("all")
public class VisitAction extends ActionSupport implements ModelDriven<Visit> {
	private Visit visit = new Visit();
	@Override
	public Visit getModel() {
		return visit;
	}

	private VisitService visitService;
	public void setVisitService(VisitService visitService) {
		this.visitService = visitService;
	}
	// 当前页
	private Integer pageCode = 1;
	
	// 每页显示的数量
	private Integer pageSize = 2;
	
	//页面提交过来的总页数
	private Integer count;
	
	
	public void setCount(Integer count) {
		this.count = count;
	}

	public Integer getPageCode() {
		return pageCode;
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

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	/**
	 *  日期 
	 *  	beginDate
	 *  	endDate
	 *  	提供set方法
	 * @return
	 */
	
	private String beginDate;
	private String endDate;
	public void setBeginDate(String beginDate) {
		this.beginDate = beginDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String findByPage(){
		
		// 创建离线条件查询对象
		DetachedCriteria criteria = DetachedCriteria.forClass(Visit.class);
		
		// 拼接条件查询
		try {
			// 被拜访人查询
			String interviewee = visit.getVisit_interviewee();
			System.out.println(interviewee + " ... ");
			if(!interviewee.equals("")){
				System.out.println(1);
				criteria.add(Restrictions.like("visit_interviewee", "%"+interviewee.trim()+"%"));
			}
			
			// 拼接时间查询
			if(!beginDate.equals("")){
				System.out.println(2);
				criteria.add(Restrictions.ge("visit_time", beginDate));
			}
			
			if(!endDate.equals("")){
				System.out.println(3);
				criteria.add(Restrictions.le("visit_time", endDate));
			}
		} catch (Exception e) {
			
		}
		PageBean<Visit> page  = visitService.findByPage(criteria,pageCode,pageSize);
		ValueStack vs = ActionContext.getContext().getValueStack();
		vs.set("page", page);
		return "findByPage";
		
	}
	/**
	 *  点击跳转添加页面
	 */
	public String initAddUI(){
		
		return "initAddUI";
	}
	
	/**
	 *  保存
	 */
	public String save(){
		
		visitService.save(visit);
		
		return "initAddUI";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
