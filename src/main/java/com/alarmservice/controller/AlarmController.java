package com.alarmservice.controller;

import com.alarmservice.dto.Comment;
import com.alarmservice.dto.User;
import com.alarmservice.service.AlarmManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmManagement alarmManagement;

    @PostMapping("/alarm")
    public void commentAlarm(@RequestParam Comment comment, User articleWriter) {
        alarmManagement.sendMail(comment,articleWriter);
    }
}
