package com.hwforever.business.model;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:33 2017/11/12
 */
public class Element {
    private Integer id;
    private String code;
    private String name;
    private String ename;
    private String description;
    private Integer pro_id;

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

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPro_id() {
        return pro_id;
    }

    public void setPro_id(Integer pro_id) {
        this.pro_id = pro_id;
    }

    @Override
    public String toString() {
        return "Element{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", ename='" + ename + '\'' +
                ", description='" + description + '\'' +
                ", pro_id=" + pro_id +
                '}';
    }
}
