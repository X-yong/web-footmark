package com.footmark.consume.controller.mail;

import com.footmark.consume.service.mall.EmailService;
import com.common.footmark.consume.SendEmail;
import com.common.util.InterfaceResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: panda
 * @Date: 2019/8/16 15:50
 */
@RestController
@RequestMapping("/email")
@Api("邮件服务")
public class EmailController {


    @Autowired
    private EmailService emailService;

    @PostMapping(value = "/sendEmail", consumes = {"application/json"},produces = {"application/json"})
    @ApiOperation(value = "邮件发送",notes = "邮件发送")
    @ApiImplicitParam(value = "sendEmail" ,name = "sendEmail",dataType = "SendEmail")
    public InterfaceResult sendEmail(@RequestBody SendEmail sendEmail ) {
        return InterfaceResult.success(emailService.sendEmail(sendEmail));
    }


}
