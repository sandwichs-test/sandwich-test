package com.hwforever;

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
}
