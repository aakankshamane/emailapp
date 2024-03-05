

package com.csi.service;

import com.csi.model.EmailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;

@Service
@Slf4j
public class EmailService {

    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(EmailModel emailModel) {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        try {
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

            mimeMessageHelper.setFrom("aakankshamane733@gmail.com");

            mimeMessageHelper.setTo(emailModel.getToEmail());
            mimeMessageHelper.setCc(emailModel.getCcEmail());
            mimeMessageHelper.setBcc(emailModel.getBccEmail());
            Date SpecificiedDate=new Date();
            mimeMessage.setSentDate(SpecificiedDate);
            mimeMessageHelper.setSubject(emailModel.getEmailSubject());
            mimeMessageHelper.setText(emailModel.getEmailBody());


            FileSystemResource fileSystemResource = new FileSystemResource(emailModel.getEmailAttachment());

            mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);

            javaMailSender.send(mimeMessage);

            log.info("Email Sent Successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }


    }
}