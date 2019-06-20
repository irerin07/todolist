package com.tistory.irerin07.todolist.controller.api;

import com.tistory.irerin07.todolist.domain.Task;
import com.tistory.irerin07.todolist.dto.TaskDto;
import com.tistory.irerin07.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class ToDoAPIController {

    @Autowired
    ToDoService toDoService;

    @GetMapping("/tasks")
    public ResponseEntity getAllTasks(@Valid @ModelAttribute TaskDto taskDto){
        List<Task> allTasks = toDoService.getTasks();
        return new ResponseEntity(allTasks, HttpStatus.OK);
    }
//    @PostMapping("/newtasks")
//    public ResponseEntity newTasks(){
//        return new ResponseEntity(allTasks, HttpStatus.OK);
//    }

}
