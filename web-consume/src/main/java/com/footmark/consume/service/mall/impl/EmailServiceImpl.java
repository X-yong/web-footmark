package com.footmark.consume.service.mall.impl;

import com.footmark.consume.service.mall.EmailService;
import com.common.footmark.consume.SendEmail;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/8/16 16:35
 */

@Service
@Log
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private TemplateEngine templateEngine;

    @Override
    @Async
    public Map sendEmail(SendEmail sendEmail) {
        log.info("---------------发送邮件---------------------");
        Map res = new HashMap();

        if ("template".equals(sendEmail.getType())) {
           sendTemplateMail(sendEmail);
        } else {

            if (CollectionUtils.isEmpty(sendEmail.getFilePath()) && CollectionUtils.isEmpty(sendEmail.getImages())) {
                sendTextEmail(sendEmail,res);
            } else {
                try {
                    sendMediaEmail(sendEmail,res);
                } catch (MessagingException e) {
                    throw new RuntimeException("邮件发送失败");
                }
            }
        }

        return res;
    }

    public Map sendTextEmail(SendEmail sendEmail,Map map) {
        SimpleMailMessage message = new SimpleMailMessage();
        List<String> to = sendEmail.getToUser();
        String [] toArr = new String[to.size()];
        for (int i = 0; i < to.size(); i++) {
            toArr[i] = to.get(i);
        }
        message.setTo(toArr);
        message.setSubject(sendEmail.getSubject());
        message.setText(sendEmail.getContent());
        message.setFrom(sendEmail.getFrom());
        message.setSentDate(new Date());
        mailSender.send(message);
        log.info("---------------发送邮件成功---------------------");
        return map;
    }

    public Map sendMediaEmail(SendEmail sendEmail, Map map) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        mimeMessage.setSentDate(new Date());
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);

        List<String> to = sendEmail.getToUser();
        String [] toArr = new String[to.size()];
        for (int i = 0; i < to.size(); i++) {
            toArr[i] = to.get(i);
        }
        helper.setTo(toArr);
        helper.setSubject(sendEmail.getSubject());
        helper.setFrom(sendEmail.getFrom());
        String content = sendEmail.getContent();


        // 附件邮件
        List<String> filepaths = sendEmail.getFilePath();
        if (!CollectionUtils.isEmpty(filepaths)) {
            String path = "";
            for (int i = 0; i < filepaths.size(); i++) {
                path = filepaths.get(i);
                //文件流:获取本地文件

                FileSystemResource file = new FileSystemResource(new File(path));
                String filename = null;
                try {
                    filename = new String(file.getFilename().getBytes(),"UTF-8");
                } catch (Exception e) {
                    e.printStackTrace();
                    log.info("文件名格式转换失败");
                }
                //可以发送多个
                helper.addAttachment(filename,file);
            }
        }
        //图片邮件
        List<Map> images = sendEmail.getImages();
        if (!CollectionUtils.isEmpty(images)) {
            StringBuilder stringBuilder = new StringBuilder("<html><body>");
            stringBuilder.append("<P>");
            stringBuilder.append(content);
            stringBuilder.append("</P>");
            for (int i = 0; i < images.size(); i++) {
                Map<String,String> image = images.get(i);
                String ipath = image.get("rscPath");
                String id = image.get("rscId");
                FileSystemResource imagefile = new FileSystemResource(new File(ipath));
                helper.addInline(id,imagefile);
                stringBuilder.append("<div><img src=\'cid:"+ id +"\' /></div>");
                if (i == images.size()-1) {
                    helper.addInline(id,imagefile);
                    stringBuilder.append("<div style=\"display: none\"><img src=\'cid:"+ id +"\' /></div>");
                }
            }
            stringBuilder.append("</body></html>");
            content = stringBuilder.toString();
        }
        log.info(content);
        helper.setText(content,true);
        mailSender.send(mimeMessage);
        log.info("---------------发送邮件成功---------------------");
        return map;
    }

    public void  sendTemplateMail(SendEmail sendEmail) {
        try {
            Context context = new Context();
            Map params = sendEmail.getParam();
            if (params == null) {
                throw new RuntimeException("参数不能为空");
            }

            params.forEach((k,v) -> {
                //设置参数
                context.setVariable(k.toString(), v);
            });

            //emailTemplate为模板文件的文件名，即html demo的文件名
            String tempContext = templateEngine.process("emailTemplate", context);
            sendEmail.setContent(tempContext);
            sendEmail.setFilePath(null);
            sendEmail.setImages(null);
            sendMediaEmail(sendEmail, new HashMap<>());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }


}
