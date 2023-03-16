package com.example.demo.controler;

import com.example.demo.entity.MailEntity;
import com.example.demo.entity.ResponseEntity;
import com.example.demo.service.SendMailService;
import com.example.demo.util.DemoResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 邮件Controller
 */
@RestController
@RequestMapping(value = "sendMail")
public class SendMailController {

    @Autowired
    private SendMailService sendMailService;

    /**
     * 普通文本邮件
     *
     * @param mailEntity
     */
    @PostMapping("/simpleSendMail")
    public ResponseEntity<Object> SendSimpleMessage(@RequestBody MailEntity mailEntity) {
        if (sendMailService.sendSimpleMail(mailEntity) > 0) {
            return new ResponseEntity<>(DemoResponseCode.OK, "发送邮件成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "发送邮件失败！");
    }

    /**
     * html格式邮件
     *
     * @param mailEntity
     */
    @PostMapping("/htmlSendMail")
    public ResponseEntity<Object> SendHtmlMessage(@RequestBody MailEntity mailEntity) {
        if (sendMailService.sendHtmlMail(mailEntity) > 0) {
            return new ResponseEntity<>(DemoResponseCode.OK, "发送邮件成功！");
        }
        return new ResponseEntity<>(DemoResponseCode.DO_FAIL, "发送邮件失败！");
    }

}
