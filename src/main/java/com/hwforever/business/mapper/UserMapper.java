package com.hwforever.business.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.hwforever.business.model.User;

/**
 * @Author： LiKai
 * @Description：
 * @Date： Created in 16:38 2017/11/18
 */
@Mapper
public interface UserMapper {
	User getUser(Map<String,String> map);
	Integer insertUser(User user);
	List<User> getAllUsers();
	List<User> findUser(User user);
	Integer updateUser(User user);
}
