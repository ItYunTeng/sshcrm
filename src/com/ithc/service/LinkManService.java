package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;

import com.ithc.bean.LinkMan;
import com.ithc.util.PageBean;

public interface LinkManService {
	/**
	 * 分页查询
	 * @param criteria
	 * @param pageCode
	 * @param pageSize
	 * @return
	 */
	PageBean<LinkMan> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize);
	/**
	 *  添加
	 * @param linkMan
	 */
	void save(LinkMan linkMan);
	/**
	 *  用id 查询
	 * @param lkm_id
	 * @return
	 */
	LinkMan findById(Long lkm_id);
	/**
	 *  修改
	 * @param linkMan
	 */
	void update(LinkMan linkMan);
	/**
	 *  删除
	 * @param lm
	 */
	void delete(LinkMan lm);

}
