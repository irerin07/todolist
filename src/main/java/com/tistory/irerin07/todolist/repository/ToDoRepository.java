package com.tistory.irerin07.todolist.repository;

import com.tistory.irerin07.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ToDoRepository extends JpaRepository<Task, Long> {

    @Query("select t from task t ORDER BY t.task_order asc")
    public List<Task> getTasks();

}
