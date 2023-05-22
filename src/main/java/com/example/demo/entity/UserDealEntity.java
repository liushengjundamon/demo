package com.example.demo.entity;

import java.util.Date;

/**
 * 交易用户实体
 */
public class UserDealEntity {

    /**
     * 用户id
     */
    private String userId;
    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 创建时间
     */
    private Date createDate;
    /**
     * 修改时间
     */
    private Date udtDate;

    public UserDealEntity() {
    }

    public UserDealEntity(String userId, String userName, String password, Date createDate, Date udtDate) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
        this.udtDate = udtDate;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUdtDate() {
        return udtDate;
    }

    public void setUdtDate(Date udtDate) {
        this.udtDate = udtDate;
    }
}
