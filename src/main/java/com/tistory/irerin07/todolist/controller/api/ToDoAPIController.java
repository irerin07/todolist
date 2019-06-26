package com.tistory.irerin07.todolist.controller.api;

import com.tistory.irerin07.todolist.domain.Task;
import com.tistory.irerin07.todolist.dto.TaskDto;
import com.tistory.irerin07.todolist.dto.TaskPostResultDto;
import com.tistory.irerin07.todolist.service.ToDoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.xml.ws.Response;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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
    @PostMapping("/newtasks")
    public ResponseEntity newTasks(@RequestBody TaskDto taskDto){
        TaskPostResultDto taskPostResultDto = new TaskPostResultDto();
        if(taskDto.getTitle().equals("")){
            taskPostResultDto.setResult("타이틀을 작성해주세요.");
            return new ResponseEntity(taskPostResultDto, HttpStatus.NOT_FOUND);
        }
        toDoService.addTodo(taskDto);
        taskPostResultDto.setResult("작성완료");
        return new ResponseEntity(taskPostResultDto, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{taskId}")
    public ResponseEntity deleteTask(@PathVariable(value = "taskId")long id){
        TaskPostResultDto taskPostResultDto = new TaskPostResultDto();
        Task task = toDoService.getTask(id);
        if(task == null){
            taskPostResultDto.setResult("없는 투두 내역");
            return new ResponseEntity(taskPostResultDto, HttpStatus.NOT_FOUND);
        }
        toDoService.deleteTodo(id);
        taskPostResultDto.setResult("삭제완료");
        return new ResponseEntity(taskPostResultDto, HttpStatus.OK);
    }
}
