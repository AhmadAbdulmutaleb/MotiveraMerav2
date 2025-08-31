package com.butiksystem.motiveramerav2.Repostory;


import com.butiksystem.motiveramerav2.Entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  TaskRepository extends JpaRepository<Task, Integer> {
    Task findById (int Id);
    List<Task> findByUserId(int userId);

}
