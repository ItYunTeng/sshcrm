package com.ithc.service;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import com.ithc.bean.LinkMan;
import com.ithc.dao.LinkManDao;
import com.ithc.util.PageBean;
@Transactional
public class LinkManServiceImpl implements LinkManService{

	private LinkManDao linkManDao;

	public void setLinkManDao(LinkManDao linkManDao) {
		this.linkManDao = linkManDao;
	}

	/**
	 * 分页查询
	 */
	public PageBean<LinkMan> findByPage(DetachedCriteria criteria, Integer pageCode, Integer pageSize) {
		return linkManDao.findByPage(criteria, pageCode, pageSize);
	}

	/**
	 *  添加
	 */
	public void save(LinkMan linkMan) {
		linkManDao.save(linkMan);
	}

	/**
	 *  用id查询
	 */
	public LinkMan findById(Long lkm_id) {
		
		return linkManDao.findById(lkm_id);
	}
	/**
	 *  修改
	 */
	public void update(LinkMan linkMan) {
		linkManDao.update(linkMan);
		
	}
	/**
	 *  删除
	 */
	public void delete(LinkMan lm) {
		linkManDao.delete(lm);
	}
	
}
