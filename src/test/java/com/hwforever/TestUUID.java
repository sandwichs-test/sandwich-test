package com.hwforever;

import org.junit.Test;

import java.util.UUID;

/**
 * @author： ZhangQiufeng
 * @Description：
 * @Date： Created in 12:02 2017/12/13
 */
public class TestUUID {
    @Test
    public void test1(){
        String uuid = UUID.randomUUID().toString();
        System.out.println(uuid);
    }
}
