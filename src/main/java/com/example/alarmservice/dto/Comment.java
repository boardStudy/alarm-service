package com.example.alarmservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comment {
    private int commentId;
    private int boardId;
    private Integer parentId;
    private String commenter;
    private String comment;
    private LocalDateTime regDate;
    private LocalDateTime updDate;

    public Comment(int boardId, String commenter, Integer parentId, String comment, LocalDateTime currentTime){
        this.boardId = boardId;
        this.commenter = commenter;
        this.parentId = parentId;
        this.comment = comment;
        this.updDate = currentTime;
    }
}
