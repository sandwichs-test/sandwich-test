package com.hwforever.business.mapper;

import com.hwforever.business.model.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * @Author： LiKai
 * @Description：
 * @Date： Created in 16:38 2017/11/18
 */
@Mapper
public interface UserMapper {
	User getUser(Map<String, String> map);
	List<User> getAllUsers();
	List<User> findUser(User user);
	Integer updateUser(User user);

    User selectUserByUserName(String username);
    boolean insertUser(User user);
}
