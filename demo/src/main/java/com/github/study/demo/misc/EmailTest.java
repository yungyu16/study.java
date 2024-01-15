package com.github.study.demo.misc;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.Email;
import org.apache.commons.mail.SimpleEmail;

/**
 * CreatedDate: 2020/6/24
 * Author: songjialin
 */
public class EmailTest {
    public static void main(String[] args) throws Exception {
        Email email = new SimpleEmail();
        email.setHostName("smtp.50lion.com");
        email.setSmtpPort(465);
        email.setAuthenticator(new DefaultAuthenticator("notice@50lion.com", "dongshi123%"));
        email.setSSLOnConnect(true);
        email.setFrom("notice@50lion.com");
        email.setSubject("TestMail");
        email.setMsg("This is a test mail ... :-)");
        email.addTo("songjialin@50lion.com");
        String retCode = email.send();
        System.out.println(retCode);
    }
}
