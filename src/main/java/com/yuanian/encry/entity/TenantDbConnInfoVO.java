package com.yuanian.encry.entity;

/**
 * 多租户DM数据库连接信息实体类
 *
 * @author zhahsh
 * @date 2021/5/10
 */
public class TenantDbConnInfoVO {

    /**
    驱动类型名称
     */
    private String driverClassName;
    /**
     * 数据库类型
     */
    private String jdbc;
    /**
     * 数据服务器IP地址
     */
    private String ip;
    /**
     * 端口号
     */
    private String port;
    /**
     * 数据库名称
     */
    private String dbName;
    /**
    数据管理员账号
     */
    private String userName;
    /**
    * 数据管理员密码
    */
    private String pwd;

    public TenantDbConnInfoVO(String driverClassName, String jdbc, String ip, String port, String dbName, String userName, String pwd) {
        this.driverClassName = driverClassName;
        this.jdbc = jdbc;
        this.ip = ip;
        this.port = port;
        this.dbName = dbName;
        this.userName = userName;
        this.pwd = pwd;
    }

    public TenantDbConnInfoVO() {
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getJdbc() {
        return jdbc;
    }

    public void setJdbc(String jdbc) {
        this.jdbc = jdbc;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDbName() {
        return dbName;
    }

    public void setDbName(String dbName) {
        this.dbName = dbName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "TenantDbConnInfoVO{" +
                "driverClassName='" + driverClassName + '\'' +
                ", jdbc='" + jdbc + '\'' +
                ", ip='" + ip + '\'' +
                ", port='" + port + '\'' +
                ", dbName='" + dbName + '\'' +
                ", userName='" + userName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}