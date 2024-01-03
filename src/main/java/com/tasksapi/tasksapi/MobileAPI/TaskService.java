package com.tasksapi.tasksapi.MobileAPI;

import jakarta.persistence.EntityManager;
import jakarta.persistence.ParameterMode;
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



    public Task addTask(Task task) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("InsertEvent");
        storedProcedureQuery.registerStoredProcedureParameter("title", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("note", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("createdAt", java.sql.Timestamp.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("updatedAt", java.sql.Timestamp.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("color", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("title", task.getTitle());
        storedProcedureQuery.setParameter("note", task.getNote());
        storedProcedureQuery.setParameter("createdAt", task.getCreatedAt());
        storedProcedureQuery.setParameter("updatedAt", task.getUpdatedAt());
        storedProcedureQuery.setParameter("color", task.getColor());
        storedProcedureQuery.execute();
        return task;
    }


    public Task updateTask(Task task) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("UpdateEvent");
        storedProcedureQuery.registerStoredProcedureParameter("id", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("title", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("note", String.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("updatedAt", java.sql.Timestamp.class, ParameterMode.IN);
        storedProcedureQuery.registerStoredProcedureParameter("color", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("id", task.getId());
        storedProcedureQuery.setParameter("title", task.getTitle());
        storedProcedureQuery.setParameter("note", task.getNote());
        storedProcedureQuery.setParameter("updatedAt", task.getUpdatedAt());
        storedProcedureQuery.setParameter("color", task.getColor());
        storedProcedureQuery.execute();
        return task;
    }

    public void deleteTask(String id) {
        StoredProcedureQuery storedProcedureQuery = entityManager.createStoredProcedureQuery("DeleteEvent");
        storedProcedureQuery.registerStoredProcedureParameter("id", String.class, ParameterMode.IN);
        storedProcedureQuery.setParameter("id", id);
        storedProcedureQuery.execute();
    }

}
