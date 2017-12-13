package com.hwforever.business.model;

import java.time.LocalDateTime;

/**
 * @author： ZhangQiufeng
 * @Description：
 * @Date： Created in 15:44 2017/12/13
 */
public class Result {
    private Integer id;
    private String serial_number;
    private Integer case_id;
    private String case_code;
    private String case_name;
    private Integer user_id;
    private String user_name;
    private String type;//状态类型，成功或失败
    private LocalDateTime execute_date;
    private Integer execute_time;
    private String failed_reason;
    private String response_code;
    private String request_message;

    public String getCase_code() {
        return case_code;
    }

    public void setCase_code(String case_code) {
        this.case_code = case_code;
    }

    public String getCase_name() {
        return case_name;
    }

    public void setCase_name(String case_name) {
        this.case_name = case_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSerial_number() {
        return serial_number;
    }

    public void setSerial_number(String serial_number) {
        this.serial_number = serial_number;
    }

    public Integer getCase_id() {
        return case_id;
    }

    public void setCase_id(Integer case_id) {
        this.case_id = case_id;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public LocalDateTime getExecute_date() {
        return execute_date;
    }

    public void setExecute_date(LocalDateTime execute_date) {
        this.execute_date = execute_date;
    }

    public Integer getExecute_time() {
        return execute_time;
    }

    public void setExecute_time(Integer execute_time) {
        this.execute_time = execute_time;
    }

    public String getFailed_reason() {
        return failed_reason;
    }

    public void setFailed_reason(String failed_reason) {
        this.failed_reason = failed_reason;
    }

    public String getResponse_code() {
        return response_code;
    }

    public void setResponse_code(String response_code) {
        this.response_code = response_code;
    }

    public String getRequest_message() {
        return request_message;
    }

    public void setRequest_message(String request_message) {
        this.request_message = request_message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "id=" + id +
                ", serial_number='" + serial_number + '\'' +
                ", case_id=" + case_id +
                ", case_code='" + case_code + '\'' +
                ", case_name='" + case_name + '\'' +
                ", user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", type='" + type + '\'' +
                ", execute_date=" + execute_date +
                ", execute_time=" + execute_time +
                ", failed_reason='" + failed_reason + '\'' +
                ", response_code='" + response_code + '\'' +
                ", request_message='" + request_message + '\'' +
                '}';
    }
}
