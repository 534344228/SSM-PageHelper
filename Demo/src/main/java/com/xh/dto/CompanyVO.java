/**
 * 
 */
package com.xh.dto;

/**
 * @author S5343
 * @date 2018-07-09下午9:25:25
 */

public class CompanyVO {
	/**
	 * 公司编号
	 */
	private Integer id;
	/**
	 * 公司名称
	 */
	private String name;
	/**
	 * 复公司名称
	 */
	private String parentName;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

}
