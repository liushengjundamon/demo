package com.example.demo.excelVO;

import cn.afterturn.easypoi.excel.annotation.Excel;

import java.util.Date;

/**
 * 用户表excel实体类
 */
public class UserExcelVO {

    @Excel(name = "用户ID", orderNum = "0", width = 50)
    private String userId;

    @Excel(name = "用户名", orderNum = "1", width = 50)
    private String userName;

    @Excel(name = "用户密码", orderNum = "2", width = 50)
    private String password;

    @Excel(name = "创建日期", orderNum = "3", width = 50, databaseFormat = "yyyy-MM-dd HH:mm:ss", format = "yyyy-MM-dd")
    private Date createDate;

    @Excel(name = "备注", orderNum = "4", width = 50)
    private String remarks;

    public UserExcelVO() {
    }

    public UserExcelVO(String userId, String userName, String password, Date createDate, String remarks) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.createDate = createDate;
        this.remarks = remarks;
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

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
