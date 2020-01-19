package com.sendemail;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.mail.MessagingException;

import java.util.UUID;


@SpringBootTest
public class EmailServiceImplTest {


    @Autowired
    private EmailServiceImpl EmailServiceImpl;
    @Test
    void sendMail() {
        EmailServiceImpl.sendMail("2265959231@qq.com","测试","xiaopingguo");
    }

    @Test
    void sendMailWithAttachment() throws MessagingException {
        EmailServiceImpl.sendMailWithAttachment("2265959231@qq.com","测试","xiaopingguo",null);
    }

    @Test
    public void testSend() throws Exception {
        String to = "2265959231@qq.com";
        EmailServiceImpl.sendTemplateMail(to, "模板邮件", UUID.randomUUID().toString().toUpperCase());
    }

}