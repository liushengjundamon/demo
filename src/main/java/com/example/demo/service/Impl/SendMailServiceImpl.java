package com.example.demo.service.Impl;

import com.example.demo.entity.MailEntity;
import com.example.demo.service.SendMailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;

/**
 * 邮件service实现类
 */
@Service
public class SendMailServiceImpl implements SendMailService {

    //注入邮件工具类
    @Resource
    private JavaMailSender javaMailSender;

    //设置发件人，从配置文件中取
    @Value("${spring.mail.username}")
    private String sendMailer;

    private static final Logger logger = LoggerFactory.getLogger(SendMailServiceImpl.class);

    public void checkMail(MailEntity mailEntity) {
        Assert.notNull(mailEntity, "邮件请求不能为空");
        Assert.notNull(mailEntity.getSendTo(), "邮件收件人不能为空");
        Assert.notNull(mailEntity.getSubject(), "邮件主题不能为空");
        Assert.notNull(mailEntity.getText(), "邮件收件人不能为空");
    }

    /**
     * 普通邮件
     *
     * @param mailEntity
     * @return
     */
    @Override
    public int sendSimpleMail(MailEntity mailEntity) {

        SimpleMailMessage message = new SimpleMailMessage();

        //检查是否为空
        checkMail(mailEntity);
        //邮件发件人
        message.setFrom(sendMailer);
        //邮件收件人 1或多个
        message.setTo(mailEntity.getSendTo().split(","));
        //邮件主题
        message.setSubject(mailEntity.getSubject());
        //邮件内容
        message.setText(mailEntity.getText());
        //邮件发送时间
        message.setSentDate(new Date());

        javaMailSender.send(message);
        logger.info("发送邮件成功:{}->{}", sendMailer, mailEntity.getSendTo());

        return 1;
    }

    /**
     * html格式邮件
     * filePath格式："C:\\Users\\liush\\Desktop\\周末part.zip"
     *
     * @param mailEntity
     * @return
     */
    @Override
    public int sendHtmlMail(MailEntity mailEntity) {

        MimeMessage message = javaMailSender.createMimeMessage();

        //检查是否为空
        checkMail(mailEntity);
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            //邮件发件人
            helper.setFrom(sendMailer);
            //邮件收件人 1或多个
            helper.setTo(mailEntity.getSendTo().split(","));
            //邮件主题
            helper.setSubject(mailEntity.getSubject());
            //邮件内容
            helper.setText(mailEntity.getText(), true);
            //邮件发送时间
            helper.setSentDate(new Date());
            //邮件附件
            String filePath = mailEntity.getFilePath();
            if (StringUtils.hasText(filePath)) {
                FileSystemResource file = new FileSystemResource(new File(filePath));
                //获取文件名
                String fileName = filePath.substring(filePath.lastIndexOf(File.separator) + 1);
                helper.addAttachment(fileName, file);
            }

            javaMailSender.send(message);
            logger.info("发送邮件成功:{}->{}", sendMailer, mailEntity.getSendTo());
            return 1;
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }
        return 0;
    }
}
