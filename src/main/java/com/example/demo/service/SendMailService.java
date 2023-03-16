package com.example.demo.service;

import com.example.demo.entity.MailEntity;

/**
 * 邮件service
 */
public interface SendMailService {
    /**
     * 普通文本邮件
     *
     * @param mailEntity
     * @return
     */
    int sendSimpleMail(MailEntity mailEntity);

    /**
     * html格式邮件
     *
     * @param mailEntity
     * @return
     */
    int sendHtmlMail(MailEntity mailEntity);
}
