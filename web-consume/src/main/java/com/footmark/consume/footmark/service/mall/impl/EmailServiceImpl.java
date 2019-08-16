package com.footmark.consume.footmark.service.mall.impl;

import com.footmark.consume.footmark.service.mall.EmailService;
import com.web.common.footmark.consume.SendEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/8/16 16:35
 */

@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public Map sendEmail(SendEmail sendEmail) {

        Map res = new HashMap();

        if (CollectionUtils.isEmpty(sendEmail.getFilePath()) && CollectionUtils.isEmpty(sendEmail.getImages())) {
            sendTextEmail(sendEmail,res);
        } else {
            try {
                sendMediaEmail(sendEmail,res);
            } catch (MessagingException e) {
                throw new RuntimeException("邮件发送失败");
            }
        }

        return res;
    }

    public Map sendTextEmail(SendEmail sendEmail,Map map) {
        SimpleMailMessage message = new SimpleMailMessage();
        List to = sendEmail.getToUser();
        String [] toArr = (String[]) to.toArray();
        message.setTo(toArr);
        message.setSubject(sendEmail.getSubject());
        message.setText(sendEmail.getContent());
        message.setFrom(sendEmail.getFrom());
        mailSender.send(message);

        return map;
    }

    public Map sendMediaEmail(SendEmail sendEmail, Map map) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        List to = sendEmail.getToUser();
        String [] toArr = (String[]) to.toArray();
        helper.setTo(toArr);
        helper.setSubject(sendEmail.getSubject());
        helper.setFrom(sendEmail.getFrom());
        helper.setText(sendEmail.getContent(),true);

        // 附件邮件
        List<String> filepaths = sendEmail.getFilePath();
        if (!CollectionUtils.isEmpty(filepaths)) {
            String path = "";
            for (int i = 0; i < filepaths.size(); i++) {
                path = filepaths.get(i);
                //文件流:获取本地文件
                FileSystemResource file = new FileSystemResource(new File(path));
                String filename = file.getFilename();
                //可以发送多个
                helper.addAttachment(filename,file);
            }
        }
        //图片邮件
        List<Map> images = sendEmail.getImages();
        if (!CollectionUtils.isEmpty(filepaths)) {
            for (int i = 0; i < images.size(); i++) {
                Map<String,String> image = images.get(i);
                String path = image.get("rscPath");
                String id = image.get("rscId");
                FileSystemResource file = new FileSystemResource(new File(path));
                helper.addInline(id,file);
            }
        }

        mailSender.send(mimeMessage);
        return map;
    }

}
