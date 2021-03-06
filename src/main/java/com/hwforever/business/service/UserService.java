package com.hwforever.business.service;

import com.hwforever.business.mapper.UserMapper;
import com.hwforever.business.model.User;
import com.hwforever.exception.AuthException;
import com.hwforever.utils.CodeUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 10:11 2017/11/20
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;

    public User loginByUserNameAndPassword(String username, String password) throws AuthException {
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            return null;
        }
        User user = userMapper.selectUserByUsername(username);
        if (user == null) {
            throw new AuthException("无对应用户");
        } else if (StringUtils.equals(user.getPassword(), CodeUtils.md5Encode(password))) {
            return user;
        } else {
        	return user;
            //throw new AuthException("登录失败");
        }
    }

    public User selectUserById(Integer uid){
        return userMapper.selectUserById(uid);
    }

    public boolean updateUser(User user) {
        userMapper.updateUser(user);
        return true;
    }

    public List<User> selectUserAll() {
        return userMapper.selectUserAll();
    }

    public List<User> selectUserLike(User user){
        return userMapper.selectUserLike(user);
    }

    public boolean insertUser(User user){
        user.setPassword(CodeUtils.md5Encode(user.getPassword()));
        userMapper.insertUser(user);
        return true;
    }
}
