package com.hwforever.business.model;

/**
 * @Author： ZhangQiufeng
 * @Description：
 * @Date： Created in 9:46 2017/11/10
 */
public class Environment {
    private Integer id;
    private String code;
    private String name;
    private String ip;
    private Integer port;
    private String url;

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

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public Integer getPort() {
        return port;
    }

    public void setPort(Integer port) {
        this.port = port;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", ip='" + ip + '\'' +
                ", port=" + port +
                ", url='" + url + '\'' +
                '}';
    }
}
