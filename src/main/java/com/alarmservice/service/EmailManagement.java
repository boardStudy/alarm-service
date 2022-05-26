package com.alarmservice.service;

import com.alarmservice.dto.Comment;
import com.alarmservice.dto.User;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;

import static com.alarmservice.EmailAlarmProperties.*;

@Service
@RequiredArgsConstructor
class AlarmManagement { // 이메일 재사용성을 위해 분리

    private final JavaMailSender javaMailSender;

    public void sendMail(Comment comment, User articleWriter) {

        String commenter = comment.getCommenter();

        String to = articleWriter.getEmail();
        String writer = articleWriter.getUserId();

        if(!commenter.equals(writer)) {
            try {
                MimeMessage mail = javaMailSender.createMimeMessage();
                MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");
                mailHelper.setFrom(FROM);
                mailHelper.setTo(to);
                mailHelper.setSubject(TITLE);
                mailHelper.setText(String.format(CONTENT,commenter,comment.getComment()));
                javaMailSender.send(mail);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

