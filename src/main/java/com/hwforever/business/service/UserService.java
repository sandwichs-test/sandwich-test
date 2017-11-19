package com.hwforever.business.service;

import com.hwforever.business.model.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User loginByUserNameAndPassword(String username, String password) {
    	return null;
    }

    public User selectUserById(Integer uid){
        return null;
    }

    public boolean updateUserLoginstr(User user) {
        return true;
    }
}
