/**
 * 
 */
package com.xh.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xh.dto.CompanyVO;
import com.xh.pojo.Company;
import com.xh.service.impl.CompanyService;

/**
 * @author S5343
 * @date 2018-07-09下午9:32:27
 */
@Controller
public class CompanyController {
	@Autowired
	private CompanyService companyService;

	@GetMapping("/index")
	@ResponseBody
	public List<CompanyVO> showCompanyList() {
		List<Company> companyList = companyService.getCompanyList();
		List<CompanyVO> resultList = new ArrayList<>();
		for (Company company : companyList) {
			CompanyVO companyVO = new CompanyVO();
			BeanUtils.copyProperties(company, companyVO);
			// 查询父公司名字
			String companyById = companyService.getCompanyById(company.getParentid());
			companyVO.setParentName(companyById);
			resultList.add(companyVO);
		}
		return resultList;
	}

	@PostMapping("/search")
	@ResponseBody
	public List<CompanyVO> searchParentName(@RequestParam(value = "name") String parentName) {
		List<Company> list = companyService.getCompanyByParentName(parentName);
		List<CompanyVO> resultList = new ArrayList<>();
		for (Company company : list) {
			CompanyVO companyVO = new CompanyVO();
			BeanUtils.copyProperties(company, companyVO);
			String companyById = companyService.getCompanyById(company.getParentid());
			companyVO.setParentName(companyById);
			resultList.add(companyVO);
		}
		return resultList;
	}
}
