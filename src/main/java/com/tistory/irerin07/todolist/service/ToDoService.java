package com.tistory.irerin07.todolist.service;

import com.tistory.irerin07.todolist.domain.Task;
import com.tistory.irerin07.todolist.dto.TaskDto;

import java.util.List;

public interface ToDoService {
    List<Task> getTasks();
    void addTodo(TaskDto taskDto); //Todo를 추가
    void deleteTodo(); //Todo를 삭제
    void modifyTodo(); //Todo를 수정. 제목, 내용, 끝나는 날짜 등
    void changeStatusTodo(); //Todo의 상태를 변경. f=끝남, n=안끝남
    void updateTodoPriority(); //Todo의 중요도를 바꾼다.

}
