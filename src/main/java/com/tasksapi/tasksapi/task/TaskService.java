package com.tasksapi.tasksapi.task;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @PersistenceContext
    private EntityManager entityManager;
    public List<Task> getTasks() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("GetEvents");
        List<Object[]> results = storedProcedureQuery.getResultList();

        List<Task> tasks = new ArrayList<>();
        for (Object[] result : results) {
            Task task = new Task();
            task.setId((String) result[0]);
            task.setTitle((String) result[1]);
            task.setNote((String) result[2]);
            task.setCreatedAt((java.sql.Timestamp) result[3]);  // No need to cast to String
            task.setUpdatedAt((java.sql.Timestamp) result[4]);
            task.setColor((String) result[5]);
            tasks.add(task);
        }

        return tasks;
    }

    public Task getTask(Integer id) {
        return taskRepository.findById(id).orElse(null);
    }

    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task task) {
        return taskRepository.save(task);
    }

    public void deleteTask(Integer id) {
        taskRepository.deleteById(id);
    }
}
