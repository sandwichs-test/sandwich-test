package com.hwforever;

import com.hwforever.common.CodeEnum;
import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 17:26 2017/11/10
 */
public class TestCommon {
    @Test
    public void test1(){
        System.out.println(LocalDate.now().toString().replace("-","")+LocalTime.now().toString().replace(":","").substring(0,6));
    }

    @Test
    public void test2(){
        System.out.println(CodeEnum.getCode(CodeEnum.PROJECT_CODE));
    }
}
