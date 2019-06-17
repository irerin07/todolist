package com.tistory.irerin07.todolist.controller.api;

import com.tistory.irerin07.todolist.domain.Task;
import com.tistory.irerin07.todolist.dto.TaskDto;
import com.tistory.irerin07.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ToDoAPIController {

    @Autowired
    ToDoService toDoService;

    @GetMapping("/getAllTasks")
    public ResponseEntity getAllTasks(@Valid @ModelAttribute TaskDto taskDto){
        List<Task> allTasks = toDoService.getTasks();
        return new ResponseEntity(allTasks, HttpStatus.OK);
    }

}
