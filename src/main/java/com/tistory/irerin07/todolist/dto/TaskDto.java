package com.tistory.irerin07.todolist.dto;

import lombok.Data;

import java.util.Date;

@Data
public class TaskDto {
    private long id;
    private String title;
    private String content;
    private Date regdate;
    private Date findate;
    private long taskOrder;
    private char completed;
    private int important;
}
