package com.hwforever.business.model;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:34 2017/11/12
 */
public class Module {
    private Integer id;
    private String code;
    private String name;
    private Integer pro_id;
    private String pro_name;
    private Integer ele_id;
    private String ele_name;

    public String getPro_name() {
        return pro_name;
    }

    public void setPro_name(String pro_name) {
        this.pro_name = pro_name;
    }

    public String getEle_name() {
        return ele_name;
    }

    public void setEle_name(String ele_name) {
        this.ele_name = ele_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    public Integer getEle_id() {
        return ele_id;
    }

    public void setEle_id(Integer ele_id) {
        this.ele_id = ele_id;
    }

    @Override
    public String toString() {
        return "Module{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", pro_id=" + pro_id +
                ", pro_name='" + pro_name + '\'' +
                ", ele_id=" + ele_id +
                ", ele_name='" + ele_name + '\'' +
                '}';
    }
}
