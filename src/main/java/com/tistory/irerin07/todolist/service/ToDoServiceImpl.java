package com.tistory.irerin07.todolist.service;

import com.tistory.irerin07.todolist.domain.Task;
import com.tistory.irerin07.todolist.dto.TaskDto;
import com.tistory.irerin07.todolist.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoServiceImpl implements ToDoService {
    @Autowired
    ToDoRepository toDoRepository;

    @Override
    public Task getTask(long id){
        Task task = toDoRepository.getOne(id);
        return task;
    }

    @Override
    public List<Task> getTasks() {
        List<Task> tasks = null;
//        tasks = toDoRepository.findAll();
        //Task를 important 체크 된 것들을 위로, 나머지는 아래로 정렬 시켜주기 위해 findAll 대신 getAllTasks를 사용
        tasks = toDoRepository.getAllTasks();
        return tasks;
    }

    @Override
    public void addTodo(TaskDto taskDto) {
        Task task = new Task();
        task.setTitle(taskDto.getTitle());
        task.setContent("");
        task.setImportant(0);
        toDoRepository.save(task);
    }

    @Override
    public void deleteTodo(long id) {
        Task task = toDoRepository.getOne(id);
        toDoRepository.delete(task);
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
