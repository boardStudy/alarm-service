package com.example.alarmservice.mapper;

import com.example.alarmservice.dto.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AlarmMapper {

    // 작성자 정보 가져오기
    User getWriter(int boardId);

}
