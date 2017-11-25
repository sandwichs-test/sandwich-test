package com.hwforever.common;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:04 2017/11/12
 */
public enum CodeEnum {
    ENVIRONMENT_CODE("01","环境"),
    PROJECT_CODE("02","项目"),
    ELEMENT_CODE("03","组件"),
    MODULE_CODE("04","模块"),
    CASE_CODE("05","案例");

    private String code;
    private String name;

    CodeEnum(String code,String name){
        this.code = code;
        this.name = name;
    }

    public static String getCode(CodeEnum codeEnum){
        return LocalDate.now().toString().replace("-","").substring(2,8)+codeEnum.code+ LocalTime.now().toString().replace(":","").replace(".","");
    }
}
