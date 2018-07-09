/**
 * 
 */
package com.xh.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xh.dao.CompanyMapper;
import com.xh.pojo.Company;
import com.xh.pojo.CompanyExample;

/**
 * @author S5343
 * @date 2018-07-09下午9:35:31
 */
@Transactional
@Service
public class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyMapper companyMapper;

	/**
	 * @return
	 */
	@Override
	public List<Company> getCompanyList() {
		List<Company> list = companyMapper.selectByExample(null);
		return list;
	}

	@Override
	public String getCompanyById(Integer parentId) {
		Company c = companyMapper.selectByPrimaryKey(parentId);
		if (c == null) {
			return "无";
		}
		return c.getName();
	}

	@Override
	public List<Company> getCompanyByParentName(String parentName) {
		CompanyExample example = new CompanyExample();
		CompanyExample.Criteria criteria = example.createCriteria();
		List<Company> companyByName = getCompanyByName(parentName);
		List<Integer> ids = new ArrayList<>();
		for (Company c : companyByName) {
			ids.add(c.getId());
		}
		criteria.andParentidIn(ids);
		List<Company> selectByExample = companyMapper.selectByExample(example);
		return selectByExample;
	}

	@Override
	public List<Company> getCompanyByName(String name) {

		CompanyExample example = new CompanyExample();
		CompanyExample.Criteria criteria = example.createCriteria();
		criteria.andNameLike("%" + name + "%");
		List<Company> list = companyMapper.selectByExample(example);
		return list;
	}

}
