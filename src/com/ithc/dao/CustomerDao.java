package com.ithc.dao;

import java.util.List;

import com.ithc.bean.Customer;
import com.ithc.util.BaseDao;

public interface CustomerDao extends BaseDao<Customer>{
	/**
	 *  客户级别统计查询
	 * @return
	 */
	List<Object[]> findByLevel();
	/**
	 *  来源统计
	 * @return
	 */
	List<Object[]> findBySource();

}
