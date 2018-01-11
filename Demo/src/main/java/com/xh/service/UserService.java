package com.xh.service;

import java.util.List;

import com.xh.pojo.User;

public interface UserService {
	/**
	 * 
	 * @param user查询条件
	 * @param page当前页码
	 * @param rows每页条数(默认5)
	 * @return
	 * @throws Exception
	 */
	List<User> queryUser(User user, Integer page, Integer rows) throws Exception;
}
