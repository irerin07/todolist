package com.tistory.irerin07.todolist.repository;

import com.tistory.irerin07.todolist.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface ToDoRepository extends JpaRepository<Task, Long> {

    @Query("select t from Task t order by t.important desc, t.id asc")
    public List<Task> getAllTasks();

    @Query("select t from Task t where t.important =:important order by t.id asc")
    public List<Task> getImportantTasks(@Param("important") int important);

    @Query("select t from Task t where t.completed =:c order by t.id asc")
    public List<Task> getCompletedTasks(@Param("c") char c);

    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.title = :title where t.id = :id")
    public void updateTaskTitle(@Param("title") String title,
                                  @Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.content = :content where t.id = :id")
    public void updateTaskContent(@Param("content") String content,
                                  @Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.findate = :date where t.id = :id")
    public void updateTaskFinDate(@Param("date") Date date,
                                  @Param("id") long id);

    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.important = :imp where t.id = :id")
    public void updateTaskImpt(@Param("imp") int imp,
                                  @Param("id") long id);



}
