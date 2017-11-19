package com.hwforever.business.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hwforever.business.model.User;
import com.hwforever.business.service.UserService;
@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("/userCtrl")
	public String userCtrl(HttpServletRequest request){
		request.setAttribute("users", userService.getAllUsers());
		return "userCtrl";
	}
	
	@RequestMapping("/findUser")
	@ResponseBody
	public List<User> findUser(String username,String password,String email,HttpServletRequest request){
		User user=new User();
		user.setEmail(email);
		user.setPassword(password);
		user.setUsername(username);
		return userService.findUser(user);
	}
	
	@RequestMapping("/addUser")
	public String addUser(String username1,String password1,String email1){
		User user = new User();
		user.setEmail(email1);
		user.setPassword(password1);
		user.setUsername(username1);
		userService.insertUser(user);
		return "forward:userCtrl";
	}
	
	@RequestMapping("/updateUser")
	public String updateUser(String username2,String password2,String email2){
		User user = new User();
		user.setEmail(email2);
		user.setPassword(password2);
		user.setUsername(username2);
		userService.updateUser(user);
		System.out.println(username2);
		return "forward:userCtrl";
	}
	
	@RequestMapping("/checkUsername")
	@ResponseBody
	public Map<String,Integer> checkUsername(String username){
		Map<String , String> map=new HashMap<>();
		map.put("username", username);
		User user = userService.getUser(map);
		Map<String, Integer> map1=new HashMap<>();
		if(user!=null){
			map1.put("res", 1);
		}else{
			map1.put("res", 0);
		}
		return map1;
	}
}
