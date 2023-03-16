package com.example.demo.entity;

import java.io.Serializable;

/**
 * 邮件实体类
 */
public class MailEntity implements Serializable {
    /**
     * 接收人
     */
    private String sendTo;

    /**
     * 邮件主题
     */
    private String subject;

    /**
     * 邮件内容
     */
    private String text;

    /**
     * 附件路径
     */
    private String filePath;

    public MailEntity() {
    }


    public MailEntity(String sendTo, String subject, String text, String filePath) {
        this.sendTo = sendTo;
        this.subject = subject;
        this.text = text;
        this.filePath = filePath;
    }

    public String getSendTo() {
        return sendTo;
    }

    public void setSendTo(String sendTo) {
        this.sendTo = sendTo;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }
}
