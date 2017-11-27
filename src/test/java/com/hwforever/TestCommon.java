package com.hwforever;

import com.hwforever.business.mapper.UserMapper;
import com.hwforever.business.model.User;
import com.hwforever.common.CodeEnum;
import com.hwforever.utils.CodeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 17:26 2017/11/10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestCommon {
    @Test
    public void test1(){
        System.out.println(LocalDate.now().toString().replace("-","")+LocalTime.now().toString().replace(":","").replace(".",""));
    }

    @Test
    public void test2(){
        System.out.println(CodeEnum.getCode(CodeEnum.PROJECT_CODE));
    }

    @Resource
    private UserMapper userMapper;

    @Test
    public void test3(){
        User user = new User();
        user.setUsername("zhangqiufeng");
        user.setPassword(CodeUtils.md5Encode("zhangqiufeng"));
        Integer uid = 4;
        System.out.println(userMapper.insertUser(user));
    }
}
