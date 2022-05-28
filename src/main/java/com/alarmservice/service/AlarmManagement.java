package com.alarmservice.service;

import com.alarmservice.dto.AlarmRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

import static com.alarmservice.EmailAlarmProperties.*;

@Service
@RequiredArgsConstructor
public class AlarmManagement {

    private final JavaMailSender javaMailSender;

    public void sendMail(AlarmRequest alarmRequest) {

        String commenter = alarmRequest.getCommenter();
        String to = alarmRequest.getEmail();
        String writer = alarmRequest.getWriter();

        if(!commenter.equals(writer)) {
            try {
                MimeMessage mail = javaMailSender.createMimeMessage();
                MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
                mailHelper.setFrom(FROM);
                mailHelper.setTo(to);
                mailHelper.setSubject(String.format(TITLE,commenter));
                mailHelper.setText(String.format(CONTENT,commenter,alarmRequest.getComment()));
                javaMailSender.send(mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

