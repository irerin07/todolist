package com.tistory.irerin07.todolist.service;

import com.tistory.irerin07.todolist.domain.Task;
import com.tistory.irerin07.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public List<Task> getTasks() {
        List<Task> tasks = null;
        tasks = toDoRepository.findAll();
        return tasks;
    }

    @Override
    public void addTodo(Task task) {
        toDoRepository.save(task);
    }

    @Override
    public void deleteTodo() {

    }

    @Override
    public void modifyTodo() {

    }

    @Override
    public void changeStatusTodo() {

    }

    @Override
    public void updateTodoPriority() {

    }
}
