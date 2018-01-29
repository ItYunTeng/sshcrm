package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.Visit;
import com.ithc.dao.VisitDao;
import com.ithc.util.PageBean;

@Transactional
public class VisitServiceImpl implements VisitService{

	private VisitDao visitDao;

	public void setVisitDao(VisitDao visitDao) {
		this.visitDao = visitDao;
	}

	/**
	 *  分页查询
	 */
	public PageBean<Visit> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		return visitDao.findByPage(criteria, pageCode, pageSize);
	}

	/**
	 *  保存
	 */
	public void save(Visit visit) {
		visitDao.save(visit);
	}
	
}
