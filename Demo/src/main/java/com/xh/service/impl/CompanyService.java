package com.xh.service.impl;

import java.util.List;

import com.xh.pojo.Company;

public interface CompanyService {
	/**
	 * 无条件查询公司列表
	 * 
	 * @return
	 */
	List<Company> getCompanyList();

	/**
	 * 通过公司ParentID查询父公司名称
	 * 
	 * @param id
	 * @return
	 */
	String getCompanyById(Integer parentId);

	/**
	 * 通过父公司名字查询公司列表
	 * 
	 * @param parentName
	 * @return
	 */
	List<Company> getCompanyByParentName(String parentName);

	/**
	 * 公司名字模糊查询
	 * 
	 * @param name
	 * @return
	 */
	List<Company> getCompanyByName(String name);
}
