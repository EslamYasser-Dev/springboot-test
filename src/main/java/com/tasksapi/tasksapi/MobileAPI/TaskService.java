package com.tasksapi.tasksapi.MobileAPI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.StoredProcedureQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @Autowired
    public TaskService(TaskRepository taskRepository) {
    }

    @PersistenceContext
    private EntityManager entityManager;
    public List<Task> getTasks() {
        StoredProcedureQuery storedProcedureQuery = entityManager.createNamedStoredProcedureQuery("GetTasks");
        List<Object[]> results = storedProcedureQuery.getResultList();

        List<Task> tasks = new ArrayList<>();
        for (Object[] result : results) {
            Task task = new Task();
            task.setId((String) result[0]);
            task.setTitle((String) result[1]);
            task.setNote((String) result[2]);
            task.setDate((Date) result[3]);
            task.setStartTime((String) result[4]);
            task.setEndTime((String) result[5]);
            task.setColor((String) result[6]);
            task.setRemind((Integer) result[7]);
            task.setRepeat((String) result[8]);
            task.setIsCompleted((Integer) result[9]);
            tasks.add(task);
        }

        return tasks;
    }

    public Task addTask(Task task) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("InsertTask");
        storedProcedureQuery.registerStoredProcedureParameter("title", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("note", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("date", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("startTime", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("endTime", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("color", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("remind", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("repeat", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("isCompleted", Integer.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("title", task.getTitle());
        storedProcedureQuery.setParameter("note", task.getNote());
        storedProcedureQuery.setParameter("date", task.getDate());
        storedProcedureQuery.setParameter("startTime", task.getStartTime());
        storedProcedureQuery.setParameter("endTime", task.getEndTime());
        storedProcedureQuery.setParameter("color", task.getColor());
        storedProcedureQuery.setParameter("remind", task.getRemind());
        storedProcedureQuery.setParameter("repeat", task.getRepeat());
        storedProcedureQuery.setParameter("isCompleted", task.getIsCompleted());
        storedProcedureQuery.execute();
        return task;
    }

    public Task updateTask(Task task) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("UpdateTask");
        storedProcedureQuery.registerStoredProcedureParameter("id", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("title", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("note", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("date", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("startTime", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("endTime", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("color", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("remind", Integer.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("repeat", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("isCompleted", Integer.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("id", task.getId());
        storedProcedureQuery.setParameter("title", task.getTitle());
        storedProcedureQuery.setParameter("note", task.getNote());
        storedProcedureQuery.setParameter("date", task.getDate());
        storedProcedureQuery.setParameter("startTime", task.getStartTime());
        storedProcedureQuery.setParameter("endTime", task.getEndTime());
        storedProcedureQuery.setParameter("color", task.getColor());
        storedProcedureQuery.setParameter("remind", task.getRemind());
        storedProcedureQuery.setParameter("repeat", task.getRepeat());
        storedProcedureQuery.setParameter("isCompleted", task.getIsCompleted());
        storedProcedureQuery.execute();
        return task;
    }

    public void deleteTask(String id) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("DeleteTask");
        storedProcedureQuery.registerStoredProcedureParameter("id", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("id", id);
        storedProcedureQuery.execute();
    }
}
