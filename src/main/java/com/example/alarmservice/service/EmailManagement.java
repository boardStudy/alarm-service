package com.example.alarmservice.service;

import com.example.alarmservice.mapper.AlarmMapper;
import com.example.alarmservice.dto.Comment;
import com.example.alarmservice.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.internet.MimeMessage;

import static com.example.alarmservice.EmailAlarmProperties.*;


@Service
@RequiredArgsConstructor
class AlarmManagement { // 이메일 재사용성을 위해 분리

    private final JavaMailSender javaMailSender;
    private final AlarmMapper alarmMapper;

    public void sendMail(Comment comment) {

        String commenter = comment.getCommenter();

        int boardId = comment.getBoardId();
        User articleWriter = getWriter(boardId);
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

    // 작성자 정보
    @Transactional
    public User getWriter(int boardId) {
        return alarmMapper.getWriter(boardId);
    }

}

