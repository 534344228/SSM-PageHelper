package com.xh.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.xh.pojo.User;
import com.xh.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping("/queryUser")
	private ModelAndView queryUser(User user, @RequestParam(required = false, defaultValue = "1") Integer page,
			@RequestParam(required = false, defaultValue = "5") Integer rows) throws Exception {
		List<User> userList = userService.queryUser(user, page, rows);
		PageInfo<User> pageInfo = new PageInfo<User>(userList);
		ModelAndView mv = new ModelAndView();
		//每一页的信息
		mv.addObject("pageInfo", pageInfo);
		//查询参数
		mv.addObject("queryParam", user);
		mv.setViewName("user");
		return mv;
	}
}
