package com.tistory.irerin07.todolist.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "task")
@Setter
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String content;
    private Date regDate;
    private Date finDate;
    private long taskOrder;
    private Character completed;

    public Task(){
        regDate = new Date();
        finDate = new Date();
    }
}
