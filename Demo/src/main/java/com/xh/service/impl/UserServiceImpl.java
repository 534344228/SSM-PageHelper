package com.xh.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.xh.dao.UserMapper;
import com.xh.pojo.User;
import com.xh.pojo.UserExample;
import com.xh.service.UserService;

@Transactional
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> queryUser(User user, Integer page, Integer rows) throws Exception {
		UserExample example = new UserExample();
		UserExample.Criteria criteria = example.createCriteria();
		if (user.getPassword() != null && user.getPassword().length() != 0) {
			criteria.andPasswordEqualTo(user.getPassword());
		}
		// 开始分页
		PageHelper.startPage(page, rows);
		return userMapper.selectByExample(example);
	}

}
