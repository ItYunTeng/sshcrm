package com.ithc.dao;

import java.util.List;

import com.ithc.bean.Customer;
import com.ithc.util.BaseDaoImpl;

public class CustomerDaoImpl extends BaseDaoImpl<Customer> implements CustomerDao {

	/**
	 * 客户级别统计查询
	 * sql
	 * SELECT 
	 * b.`dict_item_name`,COUNT(*) 
	 * FROM 
	 * cst_customer c 
	 * INNER JOIN
	 * base_dict b 
	 * ON 
	 * c.cust_level = b.dict_id 
	 * GROUP BY 
	 * c.cust_level;
	 * 
	 */
	public List<Object[]> findByLevel() {

		return (List<Object[]>) this.getHibernateTemplate().find(""
				+ "select"//
				+ " c.level.dict_item_name,count(*)"//
				+ " from"
				+ " Customer c"//
				+ " inner join"//
				+ " c.level"//
				+ " group by"//
				+ " c.level");
	}

	/**
	 *  来源统计
	SELECT 
	b.`dict_item_name`,COUNT(*) 
	FROM 
	cst_customer c 
	INNER JOIN 
	base_dict b 
	ON 
	c.cust_source = b.dict_id 
	GROUP BY 
	c.cust_source;
	 */
	public List<Object[]> findBySource() {
		return (List<Object[]>) this.getHibernateTemplate().find(""
				+ "select "//
				+ "c.source.dict_item_name,count(*) "//
				+ "from "//
				+ "Customer c "//
				+ "inner join "//
				+ "c.source "//
				+ "group by "//
				+ "c.source");
	}

}
