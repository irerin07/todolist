package com.tistory.irerin07.todolist.repositoryTest;

import com.tistory.irerin07.todolist.domain.Task;
import com.tistory.irerin07.todolist.repository.ToDoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskRepositoryTest {
    @Autowired
    ToDoRepository toDoRepository;

    @Test
    public void 전제_투두_가져오기(){
        List<Task> lists = new ArrayList<>();
        lists = toDoRepository.getAllTasks();
        Assert.assertNotNull(lists);
        for(Task t: lists){
            System.out.println(t.getId() + " task order: " + t.getTaskOrder() +" task importance: " +  t.getImportant());
        }
    }

    @Test
    public void 중요_투두만_가져오기(){
        List<Task> lists = new ArrayList<>();
        lists = toDoRepository.getImportantTasks(1);
        Assert.assertNotNull(lists);
        for(Task t: lists){
            System.out.println(t.getId() + " task order: " + t.getTaskOrder() +" task importance: " +  t.getImportant());
        }
    }

    @Test
    public void 완료_투두만_가져오기(){
        List<Task> lists = new ArrayList<>();
        lists = toDoRepository.getCompletedTasks('c');
        Assert.assertNotNull(lists);
        for(Task t: lists){
            System.out.println(t.getId());
        }
    }

    @Test
    @Transactional
    public void 투두_제목_수정(){
        String titleBefore = toDoRepository.getOne(3l).getTitle();
        toDoRepository.updateTaskTitle("새로운 제목", 3);
        String titleAfter = toDoRepository.getOne(3L).getTitle();
        Assert.assertNotSame(titleBefore,titleAfter);
    }

    @Test
    @Transactional
    public void 투두_내용_수정(){
        String contentBefore = toDoRepository.getOne(3l).getContent();
        toDoRepository.updateTaskContent("삼겹살이나 사와", 3);
        String contentAfter = toDoRepository.getOne(3L).getContent();
        Assert.assertNotSame(contentBefore,contentAfter);
    }

    @Test
    @Transactional
    public void 투두_완료날짜_변경(){
        Date dateBefore = toDoRepository.getOne(3l).getFindate();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        String date = dateFormat.format(new Date());

        Date date1 = null;

        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        toDoRepository.updateTaskFinDate(date1, 3l);

        Date dateAfter = toDoRepository.getOne(3l).getFindate();
        System.out.println(dateBefore);
        System.out.println(dateAfter);

        Assert.assertNotSame(dateBefore,dateAfter);
    }

    @Test
    @Transactional
    public void 투두_중요도_변경(){
        int impBefore = toDoRepository.getOne(3l).getImportant();
        toDoRepository.updateTaskImpt(1, 3l);
        int impAfter = toDoRepository.getOne(3l).getImportant();

        Assert.assertNotSame(impBefore, impAfter);
    }
}
