package com.hwforever.business.model;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 14:34 2017/11/12
 */
public class Case {
    private Integer id;
    private String code;
    private String name;
    private Integer case_type;
    private Integer service_id;
    private String service_name;
    private Integer protocol;
    private Integer envir_id;
    private Integer pro_id;
    private Integer ele_id;
    private Integer mod_id;
    private String nature;
    private String platform;
    private String request_message;
    private String response_message_hope;
    private String response_message_actually;
    private String description;

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

    public Integer getCase_type() {
        return case_type;
    }

    public void setCase_type(Integer case_type) {
        this.case_type = case_type;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public String getService_name() {
        return service_name;
    }

    public void setService_name(String service_name) {
        this.service_name = service_name;
    }

    public Integer getProtocol() {
        return protocol;
    }

    public void setProtocol(Integer protocol) {
        this.protocol = protocol;
    }

    public Integer getEnvir_id() {
        return envir_id;
    }

    public void setEnvir_id(Integer envir_id) {
        this.envir_id = envir_id;
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

    public Integer getMod_id() {
        return mod_id;
    }

    public void setMod_id(Integer mod_id) {
        this.mod_id = mod_id;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getRequest_message() {
        return request_message;
    }

    public void setRequest_message(String request_message) {
        this.request_message = request_message;
    }

    public String getResponse_message_hope() {
        return response_message_hope;
    }

    public void setResponse_message_hope(String response_message_hope) {
        this.response_message_hope = response_message_hope;
    }

    public String getResponse_message_actually() {
        return response_message_actually;
    }

    public void setResponse_message_actually(String response_message_actually) {
        this.response_message_actually = response_message_actually;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Case{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", case_type=" + case_type +
                ", service_id=" + service_id +
                ", service_name='" + service_name + '\'' +
                ", protocol=" + protocol +
                ", envir_id=" + envir_id +
                ", pro_id=" + pro_id +
                ", ele_id=" + ele_id +
                ", mod_id=" + mod_id +
                ", nature='" + nature + '\'' +
                ", platform='" + platform + '\'' +
                ", request_message='" + request_message + '\'' +
                ", response_message_hope='" + response_message_hope + '\'' +
                ", response_message_actually='" + response_message_actually + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}