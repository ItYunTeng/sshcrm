package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.bean.Visit;
import com.ithc.util.PageBean;

public interface VisitService {
	/**
	 *  分页查询
	 * @param criteria
	 * @param pageCode
	 * @param pageSize
	 * @return
	 */
	PageBean<Visit> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);
	/**
	 *  保存
	 * @param visit
	 */
	void save(Visit visit);

}
