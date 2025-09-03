package com.butiksystem.motiveramerav2.Service;

import com.butiksystem.motiveramerav2.Entity.Task;
import com.butiksystem.motiveramerav2.Repostory.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task getTastById(int id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(int id, Task task) {
        task.setId(id);
        return taskRepository.save(task);
    }

    public void deleteTask(int id) {
        taskRepository.deleteById(id);
    }

    public List<Task> findTaskByUserId(int userId) {
        return taskRepository.findTaskByUserId(userId);
    }

}
