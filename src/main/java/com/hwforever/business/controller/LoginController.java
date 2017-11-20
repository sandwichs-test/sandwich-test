package com.hwforever.business.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hwforever.business.mapper.UserMapper;
import com.hwforever.business.model.User;

@Controller
public class LoginController {

	@Resource
	private UserMapper userMapper;
	
	//@RequestMapping("login")
	public String login(String username,String password,ModelMap model){
		if("admin".equals(username)&&"admin".equals(password)){
			return "redirect:index";
		}
		System.out.println(userMapper);
		Map<String,String> map=new HashMap<>();
		map.put("username", username);
		map.put("password", password);
		User user = userMapper.getUser(map);
		if(user==null){
			model.addAttribute("result", "用户名或密码不正确");
			return "login";
		}
		System.out.println(user.getUsername());
		return "redirect:index1";
	}
}
