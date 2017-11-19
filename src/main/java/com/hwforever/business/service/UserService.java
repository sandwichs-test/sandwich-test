package com.hwforever.business.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hwforever.business.mapper.UserMapper;
import com.hwforever.business.model.User;

@Service
public class UserService {
	@Resource
	private UserMapper userMapper;
	
	public List<User> getAllUsers(){
		return userMapper.getAllUsers();
	}
	public int insertUser(User user){
		return userMapper.insertUser(user);
	}
	public User getUser(Map map){
		return userMapper.getUser(map);
	}
	public List<User> findUser(User user){
		return userMapper.findUser(user);
	}
	public Integer updateUser(User user){
		return userMapper.updateUser(user);
	}
}
