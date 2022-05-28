package com.alarmservice.controller;

import com.alarmservice.dto.AlarmRequest;
import com.alarmservice.service.AlarmManagement;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AlarmController {

    private final AlarmManagement alarmManagement;

    @PostMapping("/alarm")
    public void alarmByEmail(@RequestBody AlarmRequest alarmRequest) {
        alarmManagement.sendMail(alarmRequest);
    }
}
